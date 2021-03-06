package com.offonb.fragmentadapters;

import com.offonb.R;
import com.offonb.dataobjects.NewCollectionItems;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

public class NewCollectionFragmentAdapter  extends ArrayAdapter<NewCollectionItems> {

	Context context;
	int layoutResourceId;
	NewCollectionItems[] newCollectionItems = null;
	ViewHolder holder = null;

	public NewCollectionFragmentAdapter(Context context, int layoutResourceId,
			NewCollectionItems[] objects) {
		super(context, layoutResourceId, objects);
		this.context = context;
		this.layoutResourceId = layoutResourceId;
		this.newCollectionItems = objects;
	}

	public View getView(final int position, View convertView, ViewGroup parent) {
		//ViewHolder holder = null;

		if (convertView == null) {
			holder = new ViewHolder();
			LayoutInflater layout_inflator = ((Activity) context)
					.getLayoutInflater();
			convertView = layout_inflator.inflate(R.layout.item_newproduct, null);
			holder.dataCell_text = (TextView) convertView
					.findViewById(R.id.textview_newcollectiontext);
			holder.dataCell_brandorstore = (TextView) convertView.findViewById(R.id.textview_newcollectionbrandstore);
			holder.dataCell_location = (TextView) convertView.findViewById(R.id.textview_newcollectionlocations);
			holder.dataCell_views = (TextView) convertView
					.findViewById(R.id.textview_newcollectionviews);
			holder.dataCell_reviews = (TextView) convertView
					.findViewById(R.id.textview_newcollectionreviews);
			holder.dataCell_rating = (RatingBar) convertView.findViewById(R.id.ratingbar_collection);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
			
		}

		NewCollectionItems item = newCollectionItems[position];
		holder.dataCell_text.setText(item.getNewcollection_text());
		holder.dataCell_brandorstore.setText(item.getNewcollection_brandorstore());
		holder.dataCell_location.setText(item.getNewcollection_location());
		holder.dataCell_views.setText(": " + item.getNewcollection_views());
		holder.dataCell_reviews.setText(": " + item.getNewcollection_reviews());
		holder.dataCell_rating.setRating(item.getNewcollection_rating());	

		return convertView;
	}

	/**
	 * A class defining the view holder
	 */
	static class ViewHolder {
		private TextView dataCell_text;
		private TextView dataCell_brandorstore;
		private TextView dataCell_location;
		private TextView dataCell_views;
		private TextView dataCell_reviews;
		private RatingBar dataCell_rating;
	}

}
