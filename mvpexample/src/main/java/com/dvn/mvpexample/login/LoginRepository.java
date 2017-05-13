package com.dvn.mvpexample.login;

/**
 * Created by Christopher on 13/05/2017.
 * <p>
 * (Class Info: )
 */

public interface LoginRepository {
	
	User getUser();
	
	void saveUser(User user);
}
