package com.offonb.view;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.offonb.R;
import com.offonb.fragments.NewDialogFragment;

public class AddBrandsActivity extends FragmentActivity{
	
	FragmentManager manager = getSupportFragmentManager();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.activity_add_brands);
		
		// Action on click of Cancel Button
		TextView button_cancel = (TextView) findViewById(R.id.button_cancel);
		button_cancel.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				finish();
			}
		});
		
		// Action on click of Add Button
		TextView button_add = (TextView) findViewById(R.id.button_apply);
		button_add.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				finish();
			}
		});
		
		// Action on click of Add Button
		LinearLayout button_addnew = (LinearLayout) findViewById(R.id.relativelayout_add);
		button_addnew.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
		        NewDialogFragment addBrandDialog = new NewDialogFragment();
		        addBrandDialog.show(manager, "Add Brand");
			}
		});
		
		
	}

}
