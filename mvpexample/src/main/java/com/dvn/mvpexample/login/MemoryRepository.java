package com.dvn.mvpexample.login;

/**
 * Created by Christopher on 13/05/2017.
 * <p>
 * (Class Info: )
 */

public class MemoryRepository implements LoginRepository {
	
	private User user;
	
	@Override
	public User getUser() {
		if (user == null) {
			User user = new User("Fox", "Mulder");
			user.setId(0);
			return user;
		}
		
		return user;
	}
	
	@Override
	public void saveUser(User user) {
		if (user == null)
		{
			user = getUser();
		}
		
		this.user = user;
	}
	
}
