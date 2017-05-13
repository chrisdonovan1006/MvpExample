package com.dvn.mvpexample.root;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Christopher on 13/05/2017.
 * <p>
 * (Class Info: )
 *
 * Provides the Application Context for the App.
 */
@Module
public class ApplicationModule {

	private Application application;
	
	public ApplicationModule(Application application) {
		this.application = application;
	}
	
	@Provides
	@Singleton
	public Context provideContext()
	{
		return application;
	}
}
