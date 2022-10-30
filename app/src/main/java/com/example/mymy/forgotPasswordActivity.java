package com.example.mymy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

//import kotlinx.coroutines.scheduling.Task;

public class forgotPasswordActivity extends AppCompatActivity {

    EditText et;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        et = findViewById(R.id.forpassEmail);
        btn = findViewById(R.id.resetbtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String e = et.getText().toString();
                FirebaseAuth.getInstance().sendPasswordResetEmail(e).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(forgotPasswordActivity.this, "sent successfully", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(forgotPasswordActivity.this, "failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }

    public void loginActivity(View view){
        Intent obj = new Intent(this, logIn.class);
        startActivity(obj);
    }
}