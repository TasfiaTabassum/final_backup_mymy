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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUp extends AppCompatActivity {

    FirebaseAuth mAuth;
    FirebaseUser user;
    EditText eTusermail;
    TextInputEditText eTuserpassword;
    CheckBox rem;
    Button btn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        eTusermail = findViewById(R.id.email);
        eTuserpassword = findViewById(R.id.password);
        btn = findViewById(R.id.signupbtn);
        rem = findViewById(R.id.rememberme);

        rem.setChecked(false);

        mAuth = FirebaseAuth.getInstance();

        ProgressDialog progressDialog = new ProgressDialog(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!rem.isChecked())
                {
                    Toast.makeText(SignUp.this, "Please check terms and conditions", Toast.LENGTH_SHORT).show();
                }
                else
                {

                    progressDialog.setTitle("Signing Up");;
                    progressDialog.show();
                    String email = eTusermail.getText().toString().trim();
                    Log.i(TAG, "onClick: " + email);
                    String pass = eTuserpassword.getText().toString().trim();
                    Log.i(TAG, "onClick: " + pass);

                    mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(
                            new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    progressDialog.hide();
                                    if (task.isSuccessful()) {

                                        // Account created successfully
                                        Toast.makeText(SignUp.this, "Signed Up successfully", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(SignUp.this,logIn.class));
                                    }
                                    else {
                                        Toast.makeText(SignUp.this, "OopS!", Toast.LENGTH_SHORT).show();

// Error occurred
                                        try {
                                            throw task.getException();
                                        }
                                        catch (Exception e) {
                                            Toast.makeText(getApplicationContext(), e.toString(),
                                                    Toast.LENGTH_SHORT).show();
                                        }

                                    }
                                }
                            });
                }
            }
        });

    }
    public void loginActivity(View view){
        Intent obj = new Intent(this, logIn.class);
        startActivity(obj);
    }
}