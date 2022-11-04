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



