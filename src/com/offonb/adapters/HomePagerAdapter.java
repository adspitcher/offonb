package com.offonb.adapters;

import com.offonb.fragments.DetailsFragment;
import com.offonb.fragments.NewCollectionFragment;
import com.offonb.fragments.OffersHistoryFragment;
import com.offonb.fragments.ReviewsFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class HomePagerAdapter extends FragmentPagerAdapter{

	public HomePagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int index) {
		switch (index) {
        case 0:
            return new DetailsFragment();
        case 1:
        	return new OffersHistoryFragment();
        case 2:
        	return new NewCollectionFragment();
        case 3:
        	return new ReviewsFragment();
        }
 
        return null;
	}

	@Override
	public int getCount() {
		return 4;
	}

}