package com.dvn.mvpexample.root;

import android.app.Application;

import com.dvn.mvpexample.login.LoginModule;

/**
 * Created by Christopher on 13/05/2017.
 * <p>
 * (Class Info: )
 */

public class App extends Application {
	private ApplicationComponent component;
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		component = DaggerApplicationComponent.builder()
				.applicationModule(new ApplicationModule(this))
				.loginModule(new LoginModule())
				.build();
	}
	
	public ApplicationComponent getComponent() {
		return component;
	}
	
	
}
