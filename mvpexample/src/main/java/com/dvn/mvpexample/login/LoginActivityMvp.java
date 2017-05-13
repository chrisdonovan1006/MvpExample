package com.dvn.mvpexample.login;

/**
 * Created by Christopher on 13/05/2017.
 * <p>
 * (Class Info: )
 */

public interface LoginActivityMvp {
	
	interface View{
		String getFirstName();
		String getLastName();
		
		void showUserNotAvailable();
		void showUserInputError();
		void showUserSavedMessage();
		
		void setFirstName(String fname);
		void setLastName(String lname);
		
	}
	
	interface Presenter{
		
		void setView(LoginActivityMvp.View view);
		
		void loginButtonClicked();
		
		void getCurrentUser();
		
	}
	
	interface Model{
		void createUser(String fname, String lname);
		
		User getUser();
	}
}
