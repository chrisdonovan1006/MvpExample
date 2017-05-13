package com.dvn.mvpexample;

import com.dvn.mvpexample.login.LoginActivityMvp;
import com.dvn.mvpexample.login.LoginActivityPresenter;
import com.dvn.mvpexample.login.User;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Christopher on 13/05/2017.
 * <p>
 * (Class Info: )
 */

public class PresenterTests {

	LoginActivityMvp.Model mockLoginModel;
	LoginActivityMvp.View mockLoginView;
	LoginActivityPresenter presenter;
	User user;
	
	@Before
	public void setup(){
		
		mockLoginModel = mock(LoginActivityMvp.Model.class);
		
		user = new User("chris", "donovan");
		
		when(mockLoginModel.getUser()).thenReturn(user);
		
		mockLoginView = mock(LoginActivityMvp.View.class);
		
		presenter = new LoginActivityPresenter(mockLoginModel);
		
		presenter.setView(mockLoginView);
	}
	
	
	@Test
	public void noInteractionWithView()
	{
		presenter.getCurrentUser();
		
		//verifyZeroInteractions(mockLoginView);
	}
	
	@Test
	public void loadUserFromRepositoryWhenValidUserIsPresent()
	{
		when(mockLoginModel.getUser()).thenReturn(user);
		
		presenter.getCurrentUser();
		
		verify(mockLoginModel, times(1)).getUser();
		
		verify(mockLoginView, times(1)).setFirstName("chris");
		verify(mockLoginView, times(1)).setLastName("donovan");
		verify(mockLoginView, never()).showUserNotAvailable();
	}
	
	@Test
	public void shouldShouldErrorMessageWhenUserIsNull()
	{
		when(mockLoginModel.getUser()).thenReturn(null);
		
		presenter.getCurrentUser();
		
		verify(mockLoginModel, times(1)).getUser();
		
		verify(mockLoginView, never()).setFirstName("chris");
		verify(mockLoginView, never()).setLastName("donovan");
		verify(mockLoginView, times(1)).showUserNotAvailable();
	}
	
	@Test
	public void shouldCreateErrorMessageIfFieldAreEmpty()
	{
		when(mockLoginView.getFirstName()).thenReturn("");
		
		presenter.loginButtonClicked();
		
		verify(mockLoginView, times(1)).getFirstName();
		verify(mockLoginView, never()).getLastName();
		verify(mockLoginView, times(1)).showUserInputError();
		
		when(mockLoginView.getFirstName()).thenReturn("chris");
		when(mockLoginView.getLastName()).thenReturn("");
		
		presenter.loginButtonClicked();
		
		verify(mockLoginView, times(2)).getFirstName();
		verify(mockLoginView, times(1)).getLastName();
		verify(mockLoginView, times(2)).showUserInputError();
	}
	
	@Test
	public void shouldBeAbleToSaveValidUser()
	{
		when(mockLoginView.getFirstName()).thenReturn("Dana");
		when(mockLoginView.getLastName()).thenReturn("Scully");
		
		presenter.loginButtonClicked();
		
		// Called two more times in the saveUser call.
		verify(mockLoginView, times(2)).getFirstName();
		verify(mockLoginView, times(2)).getLastName();
		
		// Make sure the repository saved the user
		verify(mockLoginModel, times(1)).createUser("Dana", "Scully");
		
		// Make sure that the view showed the user saved message
		verify(mockLoginView, times(1)).showUserSavedMessage();
	}
	
	
}
