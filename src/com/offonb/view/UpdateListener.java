package com.offonb.view;

import com.offonb.controllers.AppEventsController;
import com.offonb.listeners.ActivityUpdateListener;
import com.offonb.listeners.ConnListener;
import com.offonb.models.ConnectionModel;

public class UpdateListener implements ActivityUpdateListener {

	private ConnectionModel connModel;

	public UpdateListener() {
	}

	@Override
	public void updateActivity() {
		connModel = AppEventsController.getInstance().getModelFacade()
				.getConnModel();
		((ConnListener) connModel.getListener()).onConnection();
	}
}