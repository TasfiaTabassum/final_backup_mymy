package com.example.mymy;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnapplocker , btnapppermission , buttonprofile ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnapppermission = findViewById(R.id.btnapppermission);
        btnapppermission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view2) {
                Intent intentperm = new Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS);
                startActivity(intentperm);
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

    private void appprivacysettingActivity() {
        /*if(!isAccessGranted()){

            Toast.makeText(MainActivity.this, "Sorry! First allow app usage permission" , Toast.LENGTH_LONG).show();
        }
        else {  */
            Intent intentlock = new Intent( MainActivity.this , app_privacy_setting.class);
            startActivity(intentlock);
      //  }

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


    private boolean isAccessGranted() {
        try {
            PackageManager packageManager = getPackageManager();
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(getPackageName(), 0);
            AppOpsManager appOpsManager = (AppOpsManager) getSystemService(Context.APP_OPS_SERVICE);
            int mode = 0;
            if (android.os.Build.VERSION.SDK_INT > android.os.Build.VERSION_CODES.KITKAT) {
                mode = appOpsManager.checkOpNoThrow(AppOpsManager.OPSTR_GET_USAGE_STATS,
                        applicationInfo.uid, applicationInfo.packageName);
            }
            return (mode == AppOpsManager.MODE_ALLOWED);

        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }



}