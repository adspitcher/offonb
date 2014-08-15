package com.offonb.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
import android.view.WindowManager;

import com.offonb.R;

public class SplashActivity extends FragmentActivity{

	// Time in Milliseconds
	private int SPLASH_TIMER = 2000;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.activity_splash);
		
		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				Intent screenChangeIntent = null;
				screenChangeIntent = new Intent(SplashActivity.this,
						LoginActivity.class);
				SplashActivity.this.startActivity(screenChangeIntent);
				SplashActivity.this.finish();
			}
		}, SPLASH_TIMER);

	}
}
