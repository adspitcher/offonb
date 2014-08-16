package com.offonb.view;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.offonb.R;

public class PostOfferActivity extends ActionBarActivity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_postoffer);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_menu_postoffer, menu);
   
        return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Log.d("Search View","Inside Options Selected");
		// The action bar home/up action should open or close the drawer.
        // ActionBarDrawerToggle will take care of this.
       if (super.onOptionsItemSelected(item)) {
           return true;
       }
		// Handle presses on the action bar items
		switch (item.getItemId()) {
		case R.id.action_post: {
			finish();
			return true;
		}
		default:
			return super.onOptionsItemSelected(item);
		}
	}

}
