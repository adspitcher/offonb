package com.offonb.view;

import com.offonb.R;
import com.offonb.controllers.AppEventsController;
import com.offonb.defines.NetworkEvents;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends ActionBarActivity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		// Action on click of SignIn Button
		TextView textview_signin = (TextView) findViewById(R.id.btn_login);
		textview_signin.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				Intent screenChangeIntent = null;
				screenChangeIntent = new Intent(LoginActivity.this,
						HomeActivity.class);
				LoginActivity.this.startActivity(screenChangeIntent);
			}
		});
		
		// Action on click of Create An Account Button
		TextView textview_createaccount = (TextView) findViewById(R.id.btn_register);
		textview_createaccount.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				Intent screenChangeIntent = null;
				screenChangeIntent = new Intent(LoginActivity.this,
						SignupActivity.class);
				LoginActivity.this.startActivity(screenChangeIntent);
			}
		});
		
		if( !AppEventsController.getInstance().getModelFacade().getLocalModel().isRetrievedMastedFilterData() ){
			AppEventsController.getInstance().handleEvent(NetworkEvents.EVENT_ID_GET_BRANDS,
				 null, textview_createaccount);
		}
	}
	
	@Override
	public boolean dispatchTouchEvent(MotionEvent event) {
		View view = getCurrentFocus();
		boolean ret = super.dispatchTouchEvent(event);

		if (view instanceof EditText) {
			View w = getCurrentFocus();
			int scrcoords[] = new int[2];
			w.getLocationOnScreen(scrcoords);
			float x = event.getRawX() + w.getLeft() - scrcoords[0];
			float y = event.getRawY() + w.getTop() - scrcoords[1];

			if (event.getAction() == MotionEvent.ACTION_UP
					&& (x < w.getLeft() || x >= w.getRight() || y < w.getTop() || y > w
							.getBottom())) {
				InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(getWindow().getCurrentFocus()
						.getWindowToken(), 0);
			}
		}
		return ret;
	}

}
