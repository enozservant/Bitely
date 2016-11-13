/*
 *
 * This login framework is sourced from https://github.com/sourcey/materiallogindemo
 *
 */
package com.finalproject.bitelyapp;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.ButterKnife;
import butterknife.Bind;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;

    private boolean successfulLogin = false;

    // a reference to the firebase database
    private FirebaseAuth mFirebaseAuth;

    // @Bind(R.id.input_username) EditText _usernameText;
    @Bind(R.id.input_email) EditText _userEmail;
    @Bind(R.id.input_password) EditText _passwordText;
    @Bind(R.id.btn_login) Button _loginButton;
    @Bind(R.id.link_signup) TextView _signupLink;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        mFirebaseAuth = FirebaseAuth.getInstance();
        
        _loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                login();
            }
        });

        _signupLink.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Start the Signup activity
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivityForResult(intent, REQUEST_SIGNUP);
                finish();
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });
    }

    public void login() {
        Log.d(TAG, "Login");

        if (!validate()) {
            onLoginFailed();
            return;
        }

        _loginButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();

        /*
         * // TODO: Implement authentication with server
         */
        String email = _userEmail.getText().toString();
        String password = _passwordText.getText().toString();

        mFirebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>()
                {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        progressDialog.dismiss();
                        if(task.isSuccessful())
                        {
                            loginSuccess();
                            Log.d(TAG, "Login Success");
                        }
                        else
                        {
                            Log.d(TAG, "Login Failure");
                            onLoginFailed();

                        }
                    }
                });


    }

    @Override
    public void onBackPressed() {
        // Disable going back to the MainActivity
        moveTaskToBack(true);
    }

    public void loginSuccess()
    {
        _loginButton.setEnabled(true);
        finish();
        Intent intent = new Intent(this, MainScreenLogged.class);
        startActivity(intent);

    }

    public void onLoginFailed()
    {
        // handle failed fields shit
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();
        _loginButton.setEnabled(true);
    }




    /*
     * Validate the username and password are in proper form
     */
    public boolean validate() {
        boolean valid = true;

        // String username = _usernameText.getText().toString();
        String email = _userEmail.getText().toString();
        String password = _passwordText.getText().toString();

        // !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()

        if (email.isEmpty()) {
            _userEmail.setError("enter a valid email");
            valid = false;
        } else {
            _userEmail.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 50) {
            _passwordText.setError("between 4 and 50 alphanumeric characters");
            valid = false;
        } else {
            _passwordText.setError(null);
        }

        return valid;
    }
}
