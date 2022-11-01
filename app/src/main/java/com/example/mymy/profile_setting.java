package com.example.mymy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.text.InputType;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class profile_setting extends AppCompatActivity {

//    Button btnSetPin ;

    private CardView account_setting_cardview , notification_setting_cardview  ;

    Animation a1, a2 , a3 , a4 , a5 , a6 ;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_setting);

//        password = SharedPrefUtil.getInstance(this).getString(KEY);
//        final Context context = this ;

        // calling the action bar
        ActionBar actionBar = getSupportActionBar();

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);


        account_setting_cardview = findViewById(R.id.account_setting_cardview);
        notification_setting_cardview = findViewById(R.id.notification_setting_cardview);



        a1 = AnimationUtils.loadAnimation(this , R.anim.anime_1) ;
        a2 = AnimationUtils.loadAnimation(this , R.anim.anime_2) ;
        a3 = AnimationUtils.loadAnimation(this , R.anim.anime_3) ;
        a4 = AnimationUtils.loadAnimation(this , R.anim.anime_4) ;
        a5 = AnimationUtils.loadAnimation(this , R.anim.anime_5) ;
        a6 = AnimationUtils.loadAnimation(this , R.anim.anime_6) ;



        account_setting_cardview.setAnimation(a1);
        notification_setting_cardview.setAnimation(a3);
















//        btnSetPin = findViewById(R.id.setPin_cardview);

/*
        if (password.isEmpty()) {
            btnSetPin.setText("Password required");
            setPassword(context);
           // return;
        }

        if (password.contains(" ")) {
            btnSetPin.setText("Don't support space");
            setPassword(context);
          //  return;
        }

        if (password.length() < 4 || password.length() >4) {
            btnSetPin.setText("Only support 4 digit password");
            setPassword(context);
         //   return;
        }

        btnSetPin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(password.isEmpty()){
                    setPassword(context);
                }
                else{
                    UpdatePassword(context);
                }

            }
        });
*/



    }

    /*private void setPassword(Context context){
        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        TextView t1 = new TextView(context);
        t1.setText("Enter Your Pin");

        linearLayout.addView(t1);

        EditText input = new EditText(context);
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        //should we add test n stuff?? didn't add type class for text, instead added type class number on our own
        linearLayout.addView(input);

        dialog.setView(linearLayout);

        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // save password
                SharedPrefUtil.getInstance(context).putString(KEY , input.getText().toString());
                Toast.makeText(context, "Password set successful!" , Toast.LENGTH_LONG).show();

               // Toast.makeText(context, "Password set successful!" , Toast.LENGTH_LONG).show();
                password = input.getText().toString();
                btnSetPin.setText("Update password");
            }
        }).setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // dialog.dismisss();

            }
        });


        *//*public void onClick(View v) {
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

         *//*

        dialog.show();

    }

    private void UpdatePassword(Context context){
        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        TextView t1 = new TextView(context);
        t1.setText("Enter Your Previous Pin");

        linearLayout.addView(t1);

        EditText input = new EditText(context);
        input.setInputType(InputType.TYPE_CLASS_NUMBER);

        linearLayout.addView(input);


        TextView t2 = new TextView(context);
        t2.setText("Enter Your New Pin");

        linearLayout.addView(t2);

        EditText input2 = new EditText(context);
        input.setInputType(InputType.TYPE_CLASS_NUMBER);

        linearLayout.addView(input2);




        dialog.setView(linearLayout);

        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // update password

                if(password.equals(input.getText().toString())){
                    SharedPrefUtil.getInstance(context).putString(KEY , input2.getText().toString());
                    Toast.makeText(context, "Password update successful!" , Toast.LENGTH_LONG).show();

                }
                else {
                    Toast.makeText(context, "Sorry previous password is incorrect" , Toast.LENGTH_LONG).show();
                }

            }
        }).setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // dialog.dismisss();
            }
        });

        dialog.show();

    }
*/



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



