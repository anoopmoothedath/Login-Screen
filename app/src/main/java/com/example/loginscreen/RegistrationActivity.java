package com.example.loginscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class RegistrationActivity extends AppCompatActivity {

    private TextInputEditText user_name;
    private TextInputEditText user_class;
    private TextInputEditText user_username;
    private TextInputEditText user_password;
    private TextInputEditText user_check_password;

    private SharedPreferences mSharedPreferences;
    private String sharedPrefFile = "com.example.loginscreen";

    private Button signup;

    private String username, password,name,userClass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        user_name = (TextInputEditText)findViewById(R.id.name_field);
        user_username = (TextInputEditText)findViewById(R.id.username_reg_field);
        user_class = (TextInputEditText)findViewById(R.id.class_field);
        user_check_password = (TextInputEditText)findViewById(R.id.password_reg_field);
        user_password = (TextInputEditText)findViewById(R.id.confirm_pass_field);
        signup = (Button)findViewById(R.id.signup_reg_button);

        mSharedPreferences = getSharedPreferences(sharedPrefFile,MODE_PRIVATE);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name = user_name.getText().toString();
                username = user_username.getText().toString();
                password = user_password.getText().toString();
                userClass = user_class.getText().toString();

                if(username.length()<=0){
                    Toast.makeText(getApplicationContext(), "Enter name", Toast.LENGTH_SHORT).show();
                }
                else if( password.length()<=0){
                    Toast.makeText(getApplicationContext(), "Enter password", Toast.LENGTH_SHORT).show();
                }

                SharedPreferences.Editor prefEditor = mSharedPreferences.edit();
                prefEditor.putString("name",name);
                prefEditor.putString("username",username);
                prefEditor.putString("password", password);
                prefEditor.putString("class",userClass);
                prefEditor.apply();
                prefEditor.commit();

                Toast.makeText(getApplicationContext(), "Saved!!", Toast.LENGTH_LONG).show();
                Intent signin = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(signin);
                finish();
            }
        });
    }
}
