package com.dvn.mvpexample.login;

import android.support.annotation.Nullable;

/**
 * Created by Christopher on 13/05/2017.
 * <p>
 * (Class Info: )
 */

public class LoginActivityPresenter implements LoginActivityMvp.Presenter{
	
	@Nullable
	private LoginActivityMvp.View view;
	private LoginActivityMvp.Model model;
	
	public LoginActivityPresenter(LoginActivityMvp.Model model) {
		this.model = model;
	}
	
	
	@Override
	public void setView(LoginActivityMvp.View view) {
		this.view = view;
	}
	
	@Override
	public void loginButtonClicked() {
		
		if (view != null) {
			if (view.getFirstName().trim().equals("") || view.getLastName().trim().equals("")) {
				view.showUserInputError();
			} else {
				model.createUser(view.getFirstName(), view.getLastName());
				view.showUserSavedMessage();
			}
		}
		
	}
	
	@Override
	public void getCurrentUser() {
		
		User user = model.getUser();
		
		if (view != null) {
			if (user != null) {
				view.setFirstName(user.getFirstName());
				view.setLastName(user.getLastName());
			} else {
				view.showUserNotAvailable();
			}
		}
	}
}
