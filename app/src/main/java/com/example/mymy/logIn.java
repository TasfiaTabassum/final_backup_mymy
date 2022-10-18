package com.example.mymy;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class logIn extends AppCompatActivity {

    TextInputEditText eTemail;
    TextInputEditText etPassword;
    Button bton;
    FirebaseAuth mAuth;
    FirebaseAuth user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        FirebaseUser cur_user = FirebaseAuth.getInstance().getCurrentUser();
        if(cur_user!= null){
            startActivity(new Intent(logIn.this,MainActivity.class));
            finish();
        }
        eTemail = findViewById(R.id.email_id);
        etPassword = findViewById(R.id.password);
        bton = findViewById(R.id.loginbtn);

        mAuth = FirebaseAuth.getInstance();
        ProgressDialog progressDialog = new  ProgressDialog(this);

        bton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.setTitle("loging in");;
                progressDialog.show();
                String username = eTemail.getText().toString().trim();
                Log.i(TAG,"OnClick" + username);
                String password = etPassword.getText().toString().trim();
                Log.i(TAG,"OnClick" + password);

                mAuth.signInWithEmailAndPassword(username, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            progressDialog.dismiss();
                            Toast.makeText(logIn.this, "Login successful", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(logIn.this,MainActivity.class));
                        } else {
                            progressDialog.dismiss();
                            try {
                                throw task.getException();
                            } catch (Exception e) {
                                Toast.makeText(getApplicationContext(), "Wrong Credential. Please try again.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
            }
        });

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