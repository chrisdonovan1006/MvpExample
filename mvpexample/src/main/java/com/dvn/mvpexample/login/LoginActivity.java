package com.dvn.mvpexample.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dvn.mvpexample.R;
import com.dvn.mvpexample.root.App;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity implements  LoginActivityMvp.View{
	
	@Inject
	LoginActivityMvp.Presenter presenter;
	
	private EditText firstName;
	private EditText lastName;
	private Button login;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		((App) getApplication()).getComponent().inject(this);
		
		firstName = (EditText) findViewById(R.id.loginActivity_firstName_editText);
		lastName = (EditText) findViewById(R.id.loginActivity_lastName_editText);
		login = (Button) findViewById(R.id.loginActivity_login_button);
		
		login.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				presenter.loginButtonClicked();
			}
		});
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		presenter.setView(this);
		presenter.getCurrentUser();
	}
	
	@Override
	public String getFirstName() {
		return firstName.getText().toString();
	}
	
	@Override
	public String getLastName() {
		return lastName.getText().toString();
	}
	
	@Override
	public void showUserNotAvailable() {
		Toast.makeText(this, "Error: user not available.", Toast.LENGTH_SHORT).show();
	}
	
	@Override
	public void showUserInputError() {
		Toast.makeText(this, "Error: first or last name cannot be empty.", Toast.LENGTH_SHORT).show();
	}
	
	@Override
	public void showUserSavedMessage() {
		Toast.makeText(this, "Success: user saved.", Toast.LENGTH_SHORT).show();
	}
	
	@Override
	public void setFirstName(String fname) {
		firstName.setText(fname);
	}
	
	@Override
	public void setLastName(String lname) {
		lastName.setText(lname);
	}
}
