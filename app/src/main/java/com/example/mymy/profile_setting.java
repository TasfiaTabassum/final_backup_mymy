package com.example.mymy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class profile_setting extends AppCompatActivity {

    Button btnSetPin ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_setting);


        // calling the action bar
        ActionBar actionBar = getSupportActionBar();

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);

        btnSetPin = findViewById(R.id.setpin);
        btnSetPin.setOnClickListener((v) ->  {

        });



    }

    private void setPassword(Context context){
        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        TextView t1 = new TextView(context);
        t1.setText("Enter Your Pin");

        linearLayout.addView(t1);

        EditText input = new EditText(context);
        input.setInputType(InputType.TYPE_CLASS_NUMBER);

        linearLayout.addView(input);

        dialog.setView(linearLayout);

        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        }).setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });


        /*public void onClick(View v) {
            String password = passwordview.getText().toString();

            if (password.isEmpty()) {
                passwordview.setError("Password required");
                return;
            }

            if (password.contains(" ")) {
                passwordview.setError("Don't support space");
                return;
            }

            if (password.length() < 4 || password.length() >4) {
                passwordview.setError("Support 4 digint password");
                return;
            }

         */



    }

    private void UpdatePassword(Context context){


    }




    // this event will enable the back
    // function to the button on press
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}