package com.dvn.mvpexample.login;

/**
 * Created by Christopher on 13/05/2017.
 * <p>
 * (Class Info: )
 */

public class LoginActivityModel implements LoginActivityMvp.Model {
	
	private LoginRepository repository;
	
	public LoginActivityModel(LoginRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public void createUser(String fname, String lname) {
		repository.saveUser(new User(fname, lname));
	}
	
	@Override
	public User getUser() {
		return repository.getUser();
	}
}
