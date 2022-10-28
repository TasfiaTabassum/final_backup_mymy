package com.example.mymy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity<noHistory, name, label, excludeFromRecents, activity> extends AppCompatActivity {

    Button btnapplocker , btnapppermission , buttonprofile , btntimeslotsetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // calling the action bar
        ActionBar actionBar = getSupportActionBar();

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);


        btnapppermission = findViewById(R.id.btnapppermission);
        btnapppermission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view2) {
                Intent intentperm = new Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS);
                startActivity(intentperm);
            }
        });

        btntimeslotsetting = findViewById(R.id.buttontimeslot);
        btntimeslotsetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent objprofile = new Intent(MainActivity.this, timeSlotSettingActivity.class);
                startActivity(objprofile);
            }
        });

        btnapplocker = findViewById(R.id.buttonapplocker);
        btnapplocker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                appprivacysettingActivity();

            }
        });

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


    private void appprivacysettingActivity() {
        if(!isAccessGranted()){

            Toast.makeText(MainActivity.this, "Sorry! First allow app usage permission" , Toast.LENGTH_LONG).show();
        }
        else {
            Intent intentlock = new Intent( MainActivity.this , app_privacy_setting.class);
            startActivity(intentlock);
        }

    }

    public void profileSettingActivity(View view)
    {
        buttonprofile = findViewById(R.id.buttonprofile);
        buttonprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent objprofile = new Intent(MainActivity.this, profile_setting.class);
                startActivity(objprofile);
            }
        });

    }

    public void timeSlotSettingActivity(View view)
    {


    }


    private boolean isAccessGranted() {
        try {
            PackageManager packageManager = getPackageManager();
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(getPackageName(),0);
            AppOpsManager appOpsManager = null;
            if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT)
            {
                appOpsManager = (AppOpsManager) getSystemService(Context.APP_OPS_SERVICE);
            }
            int mode = 0 ;
            if (android.os.Build.VERSION.SDK_INT > android.os.Build.VERSION_CODES.KITKAT) {
                mode = appOpsManager.checkOpNoThrow(AppOpsManager.OPSTR_GET_USAGE_STATS,
                        applicationInfo.uid, applicationInfo.packageName);
            }
            Log.d("tasfia" , "no error" + mode + " " + AppOpsManager.MODE_ALLOWED );
            return (mode == AppOpsManager.MODE_ALLOWED || mode == AppOpsManager.MODE_DEFAULT );

        } catch (PackageManager.NameNotFoundException e) {
            Log.d("tasfia" , "error hochche" + e.toString() );
            return false;
        }
    }


}