package com.offonb.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.offonb.R;
import com.offonb.dataobjects.ReviewsItem;
import com.offonb.fragmentadapters.ReviewsFragmentAdapter;

public class ReviewsFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater
				.inflate(R.layout.fragment_reviews, container, false);

		ListView listView_reviews_items = (ListView) view
				.findViewById(R.id.listview_reviews);

		ReviewsItem[] reviewsDataItems = new ReviewsItem[10];
		for (int i = 0; i < 10; i++) {
			reviewsDataItems[i] = new ReviewsItem("Rachna Khokhar", "2 hours ago", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.");
		}

		ReviewsFragmentAdapter adapter = new ReviewsFragmentAdapter(
				view.getContext(), R.layout.fragment_reviews, reviewsDataItems);
		listView_reviews_items.setAdapter(adapter);

		return view;
	}
}