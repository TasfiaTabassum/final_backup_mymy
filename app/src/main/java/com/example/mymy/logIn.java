package com.example.mymy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class logIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
    }

    public void goMainActivity(View view){
        Intent obj = new Intent(this, MainActivity.class);
        startActivity(obj);
    }

    public void goForgotPassword(View view){
        Intent obj2 = new Intent(this, forgotPasswordActivity.class);
        startActivity(obj2);
    }

    public void goSignUp(View view){
        Intent obj3 = new Intent(this, SignUp.class);
        startActivity(obj3);
    }

}