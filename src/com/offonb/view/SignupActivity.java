package com.offonb.view;

import com.offonb.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class SignupActivity extends ActionBarActivity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_signup);
		
		// Action on click of AddBrands Button
		TextView textview_addbrands = (TextView) findViewById(R.id.link_add_brands);
		textview_addbrands.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				Intent screenChangeIntent = null;
				screenChangeIntent = new Intent(SignupActivity.this,
						AddBrandsActivity.class);
				SignupActivity.this.startActivity(screenChangeIntent);
			}
		});
		
		// Action on click of AddBrands Button
		TextView textview_addcategories = (TextView) findViewById(R.id.link_add_categories);
		textview_addcategories.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				Intent screenChangeIntent = null;
				screenChangeIntent = new Intent(SignupActivity.this,
						AddCategoriesActivity.class);
				SignupActivity.this.startActivity(screenChangeIntent);
			}
		});
	}

}
