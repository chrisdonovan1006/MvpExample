package com.dvn.mvpexample.login;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Christopher on 13/05/2017.
 * <p>
 * (Class Info: )
 */
@Module
public class LoginModule {
	
	@Provides
	public LoginActivityMvp.Presenter provideLoginAcitivityPresenter(LoginActivityMvp.Model model)
	{
		return new LoginActivityPresenter(model);
	}
	
	@Provides
	public LoginActivityMvp.Model provideLoginActivityModel(LoginRepository repository)
	{
		return new LoginActivityModel(repository);
	}
	
	@Provides
	public LoginRepository provideLoginRepository()
	{
		return new MemoryRepository();
	}
}
