package com.example.mymy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity<noHistory, name, label, excludeFromRecents, activity> extends AppCompatActivity {

    private CardView AppSetting,AppUsagePermission,SetUpPrivacy,TimeSlotSetting;
    Button btnapplocker , btnapppermission , buttonprofile , btntimeslotsetting;
    Button signOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppSetting = findViewById(R.id.setting_cardview);
        AppUsagePermission = findViewById(R.id.App_usage_permission);
        SetUpPrivacy = findViewById(R.id.set_up_privacy);
        TimeSlotSetting = findViewById(R.id.time_slot_setting);
        signOut = findViewById(R.id.sign_out_btn);

        AppSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,profile_setting.class);
                startActivity(intent);
            }
        });

        AppUsagePermission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS);
                startActivity(intent);
            }
        });

        SetUpPrivacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,app_privacy_setting.class);
                startActivity(intent);
            }
        });

        TimeSlotSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,timeSlotSettingActivity.class);
                startActivity(intent);
            }
        });

        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(MainActivity.this,logIn.class));

            }
        });
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
            return (mode == AppOpsManager.MODE_ALLOWED);

        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }
}