package com.example.loginscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.textview.MaterialTextView;

public class WelcomeActivity extends AppCompatActivity {

    MaterialTextView welcome_message;
    private String user_name, user_class;
    private SharedPreferences mSharedPreferences;
    private String sharedPrefFile = "com.example.loginscreen";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        welcome_message = (MaterialTextView)findViewById(R.id.welcome_message);

        mSharedPreferences = getSharedPreferences(sharedPrefFile,MODE_PRIVATE);

        user_name = mSharedPreferences.getString("name","");
        user_class = mSharedPreferences.getString("class","");

        welcome_message.setText("Welcome "+user_name+" of class "+user_class+".");
    }
}
