package com.offonb.net;

import org.json.JSONObject;

import com.offonb.constants.Constants;
import com.offonb.controllers.AppEventsController;
import com.offonb.exceptions.ApplicationException;
import com.offonb.models.ConnectionModel;
import com.offonb.models.UserModel;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class NetworkResponseHandler {
	public static final String TAG = "Network Response Handler";

	public static final Handler AUTHENTICATESTORE_HANDLER = authenticateStoreHandler();
	public static final Handler REGISTERSTORE_HANDLER = registerStoreHandler();
	public static final Handler BRANDS_HANDLER = brandsHandler();
	public static final Handler CATEGORIES_HANDLER = categoriesHandler();
	
	private static Handler authenticateStoreHandler() {
		return new Handler() {
			@Override
			public void handleMessage(Message msg) {
				ConnectionModel model = AppEventsController.getInstance()
						.getModelFacade().getConnModel();
				switch (msg.what) {
				case Constants.SUCCESSFUL_RESPONSE: {
					Log.d("response==", ((JSONObject) msg.obj).toString());
						UserModel userModel = AppEventsController
								.getInstance().getModelFacade()
								.getUserModel();
						try {
							userModel.setAuthenticationDetails((JSONObject) msg.obj);
						} catch (ApplicationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						model.setConnectionStatus(ConnectionModel.SUCCESS);
					model.notifyView();
				}
					break;
				case Constants.EXCEPTION: {
					Exception exceptionObj = (Exception) msg.obj;
					Log.d(TAG, "exception:" + exceptionObj.getMessage());
					model.setConnectionStatus(ConnectionModel.ERROR);
					model.setConnectionErrorMessage(exceptionObj.getMessage());
					model.notifyView();
				}
					break;
				}
			}

		};
	}
	
	private static Handler brandsHandler() {
		return new Handler() {
			@Override
			public void handleMessage(Message msg) {
				
			}

		};
	}
	
	private static Handler categoriesHandler() {
		return new Handler() {
			@Override
			public void handleMessage(Message msg) {
			}

		};
	}
	
	private static Handler registerStoreHandler() {
		return new Handler() {
			@Override
			public void handleMessage(Message msg) {
				ConnectionModel model = AppEventsController.getInstance()
						.getModelFacade().getConnModel();
				switch (msg.what) {
				case Constants.SUCCESSFUL_RESPONSE: {
					UserModel userModel = AppEventsController
							.getInstance().getModelFacade()
							.getUserModel();
					model.notifyView();
				}
					break;
				case Constants.EXCEPTION: {
					Exception exceptionObj = (Exception) msg.obj;
					Log.d(TAG, "exception:" + exceptionObj.getMessage());
					model.setConnectionStatus(ConnectionModel.ERROR);
					model.setConnectionErrorMessage(exceptionObj.getMessage());
					model.notifyView();
				}
					break;
				}
			}

		};
	}
}
