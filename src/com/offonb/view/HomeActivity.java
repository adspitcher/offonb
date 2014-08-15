package com.offonb.view;

import com.offonb.R;
import com.offonb.adapters.HomePagerAdapter;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar.Tab;
import android.view.Menu;

public class HomeActivity extends ActionBarActivity implements
ActionBar.TabListener{
	
	private ViewPager viewPager;
	private ActionBar actionBar;
	private HomePagerAdapter mAdapter;
	private Menu homeMenu;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		// Initilization
				viewPager = (ViewPager) findViewById(R.id.pager);
				actionBar = getSupportActionBar();
				mAdapter = new HomePagerAdapter(getSupportFragmentManager());

				viewPager.setAdapter(mAdapter);
				actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

				Resources itemTexts = getResources();
				String[] tabs = itemTexts.getStringArray(R.array.home_tabs_array);

				// Adding Tabs
				for (String tab_name : tabs) {
					actionBar.addTab(actionBar.newTab().setText(tab_name)
							.setTabListener(this));
				}

				/**
				 * on swiping the viewpager make respective tab selected
				 * */
				viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

					@Override
					public void onPageSelected(int position) {
						// on changing the page
						// make respected tab selected
						actionBar.setSelectedNavigationItem(position);
					}

					@Override
					public void onPageScrolled(int arg0, float arg1, int arg2) {
					}

					@Override
					public void onPageScrollStateChanged(int arg0) {
					}
				});
	}
	
	@Override
	public void onTabReselected(Tab tab, FragmentTransaction arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction arg1) {
		// on tab selected
		// show respected fragment view
		viewPager.setCurrentItem(tab.getPosition());

	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction arg1) {
		// TODO Auto-generated method stub

	}

}
