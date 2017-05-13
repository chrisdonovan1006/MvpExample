package com.dvn.mvpexample.root;

import com.dvn.mvpexample.login.LoginActivity;
import com.dvn.mvpexample.login.LoginModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Christopher on 13/05/2017.
 * <p>
 * (Class Info: )
 */
@Singleton
@Component(modules = {ApplicationModule.class, LoginModule.class})
public interface ApplicationComponent {
	
	void inject(LoginActivity target);
}
