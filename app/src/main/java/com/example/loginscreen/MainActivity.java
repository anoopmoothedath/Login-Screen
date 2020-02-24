package com.example.loginscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private Button sign_in, sign_up;
    private TextInputEditText uname, pword;
    private TextInputLayout usernameLayout,passwordLayout;
    private SharedPreferences mSharedPreferences;
    private String sharedPrefFile = "com.example.loginscreen";

    private String username, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sign_in = (Button)findViewById(R.id.sign_in_button);
        sign_up = (Button)findViewById(R.id.sign_up_button);
        uname = (TextInputEditText)findViewById(R.id.username_field);
        pword = (TextInputEditText)findViewById(R.id.password_field);
        usernameLayout = (TextInputLayout)findViewById(R.id.username_field_input_layout);
        passwordLayout = (TextInputLayout)findViewById(R.id.password_field_input_layout);
        mSharedPreferences = getSharedPreferences(sharedPrefFile,MODE_PRIVATE);

        uname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length() == 0)
                    usernameLayout.setError("Please enter username");
                else
                    usernameLayout.setError(null);
            }
        });

        pword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length() == 0)
                    passwordLayout.setError("Please enter password");
                else
                    passwordLayout.setError(null);
            }
        });

        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = uname.getText().toString();
                password = pword.getText().toString();

                if(username.trim().length() > 0 && password.trim().length() > 0){
                    String uName = null, pWord = null;
                    if (mSharedPreferences.contains("username")){
                        uName = mSharedPreferences.getString("username","");
                    }
                    if (mSharedPreferences.contains("password")){
                        pWord = mSharedPreferences.getString("password","");
                    }


                    if(username.equals(uName) && password.equals(pWord)){
                        Toast.makeText(MainActivity.this,"Login Successfull", Toast.LENGTH_LONG).show();
                        Intent welcome = new Intent(MainActivity.this, WelcomeActivity.class);
                        startActivity(welcome);
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Username/Password is incorrect"+uName+pWord, Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Please enter username and password", Toast.LENGTH_LONG).show();

                }
            }
        });

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signup = new Intent(MainActivity.this, RegistrationActivity.class);
                startActivity(signup);
                finish();
            }
        });
    }
}
