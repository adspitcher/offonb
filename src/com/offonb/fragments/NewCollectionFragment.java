package com.offonb.fragments;

import com.offonb.R;
import com.offonb.dataobjects.NewCollectionItems;
import com.offonb.fragmentadapters.NewCollectionFragmentAdapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class NewCollectionFragment extends Fragment{
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_newcollection, container,
				false);
		ListView listView_newrange_items = (ListView) view
				.findViewById(R.id.listview_newcollection);

		NewCollectionItems[] newCollectionDataItems = new NewCollectionItems[10];
		for (int i = 0; i < 10; i++) {
			newCollectionDataItems[i] = new NewCollectionItems(
					"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
					"Pantaloons", "Gurgaon | Mumbai", 10, 10, 2);
		}

		NewCollectionFragmentAdapter adapter = new NewCollectionFragmentAdapter(
				view.getContext(), R.layout.fragment_newcollection, newCollectionDataItems);
		listView_newrange_items.setAdapter(adapter);
		return view;
	}

}
