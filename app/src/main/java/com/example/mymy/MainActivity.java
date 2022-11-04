package com.example.mymy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity<noHistory, name, label, excludeFromRecents, activity> extends AppCompatActivity {

    private CardView AppSetting,AppUsagePermission,SetUpPrivacy,TimeSlotSetting , SetUpdatePin , ShowLockedApps ;
    Button btnapplocker , btnapppermission , buttonprofile , btntimeslotsetting;
    Button signOut;


    Button btnSetPin ;
    String password ;
    static final String KEY = "pass" ;

    private SharedPrefUtil pref ;




    Animation a1, a2 , a3 , a4 , a5 , a6 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        password = SharedPrefUtil.getInstance(this).getString(KEY);
        final Context context = this ;

        AppSetting = findViewById(R.id.setting_cardview);
        AppUsagePermission = findViewById(R.id.App_usage_permission);
        SetUpPrivacy = findViewById(R.id.set_up_privacy);
        TimeSlotSetting = findViewById(R.id.time_slot_setting);
        signOut = findViewById(R.id.sign_out_btn);
        ShowLockedApps = findViewById(R.id.showLockedApps_cardview);
        SetUpdatePin = findViewById(R.id.setPin_cardview);


        a1 = AnimationUtils.loadAnimation(this , R.anim.anime_1) ;
        a2 = AnimationUtils.loadAnimation(this , R.anim.anime_2) ;
        a3 = AnimationUtils.loadAnimation(this , R.anim.anime_3) ;
        a4 = AnimationUtils.loadAnimation(this , R.anim.anime_4) ;
        a5 = AnimationUtils.loadAnimation(this , R.anim.anime_5) ;
        a6 = AnimationUtils.loadAnimation(this , R.anim.anime_6) ;



        AppSetting.setAnimation(a1);
        AppUsagePermission.setAnimation(a3);
        SetUpPrivacy.setAnimation(a3);
        SetUpdatePin.setAnimation(a1);
        TimeSlotSetting.setAnimation(a1);
        ShowLockedApps.setAnimation(a3);



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
                /*Intent intent = new Intent(MainActivity.this,app_privacy_setting.class);
                startActivity(intent);*/

                appprivacysettingActivity(context);

            }
        });



        ShowLockedApps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Locked_app_list_activity.class);
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



        //btnSetPin = findViewById(R.id.setPin_cardview);

        if (password.isEmpty()) {
            //btnSetPin.setText("Update Pin");

           // setPassword(context);
            // return;

            Toast.makeText(context, "Set Pin" , Toast.LENGTH_LONG).show();
            Log.d("tasfia" , "eitar karon ei ki shob jamela?" );

        }


       /* if else (password.contains(" ")) {
            btnSetPin.setText("Don't support space");
            setPassword(context);
            //  return;
        }

        if else (password.length() < 4 || password.length() >4) {
            btnSetPin.setText("Only support 4 digit password");
            setPassword(context);
            //   return;
        }*/
/*
        else{
           // btnSetPin.setText("Update Pin");
            //   UpdatePassword(context);

            Toast.makeText(context, "Update Pin" , Toast.LENGTH_LONG).show();
            Log.d("tasfia" , "eitar karon ei ki shob jamela? ( 2 )" );

        }
*/
/*
        || password.contains(" ") || ( password.length() < 4 || password.length() >4)       --add to password check condition if needed

        */


        SetUpdatePin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(password.isEmpty()  ){
                   // btnSetPin.setText("Pin required");
                    Log.d("tasfia" , "set pin kaj on click e  koree" );
                    setPassword(context);
                }
                else{
                    UpdatePassword(context);
                    Log.d("tasfia" , "update pin on click e kaj koree" );
                }

            }
        });



    }





   /* @Override
    public void onBindViewHolder(@NonNull appAdapter.adapter_design_backend holder, int position) {

       *//* appModel app = appModels.get(position);
        holder.appname.setText(app.getAppname());
        holder.appicon.setImageDrawable(app.getAppicon());

        AppSetting,AppUsagePermission,SetUpPrivacy,TimeSlotSetting , SetUpdatePin , ShowLockedApps ;

        *//*


        holder.AppSetting.startAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(), R.anim.anim_one));
        holder.AppUsagePermission.startAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(), R.anim.anim_one));
        holder.SetUpPrivacy.startAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(), R.anim.anim_one));
        holder.TimeSlotSetting.startAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(), R.anim.anim_one));
        holder.SetUpdatePin.startAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(), R.anim.anim_one));
        holder.ShowLockedApps.startAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(), R.anim.anim_one));



        *//*if(app.getStatus() == 0){
            holder.appstatus.setImageResource(R.drawable.unlock);
        }
        else{
            holder.appstatus.setImageResource(R.drawable.lock);
            lockedApps.add(app.getPackagename());
        }*//*

        *//*holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(app.getStatus()==0){
                    app.setStatus(1);
                    holder.appstatus.setImageResource(R.drawable.lock);
                    Toast.makeText(context, app.getAppname()+" is locked!!", Toast.LENGTH_LONG).show();
                    lockedApps.add(app.getPackagename());

                    SharedPrefUtil.getInstance(context).putListString(lockedApps);

                }
                else{
                    app.setStatus(0);
                    holder.appstatus.setImageResource(R.drawable.unlock);
                    Toast.makeText(context, app.getAppname()+" is unlocked!!", Toast.LENGTH_LONG).show();
                    lockedApps.remove(app.getPackagename());

                    SharedPrefUtil.getInstance(context).putListString(lockedApps);

                }
            }
        });*//*

    }*/






    private void setPassword(Context context){
        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        TextView t1 = new TextView(context);
        t1.setText("Enter Your Pin");

        linearLayout.addView(t1);

        EditText input = new EditText(context);

        //| InputType.TYPE_NUMBER_VARIATION_PASSWORD

        input.setInputType(InputType.TYPE_CLASS_NUMBER ) ;
        //should we add text n stuff?? didn't add type class for text, instead added type class number on our own
        linearLayout.addView(input);

        dialog.setView(linearLayout);

        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // save password
                System.out.println(input.getText().toString());
                if(input.getText().toString().length()>4)
                {
                    System.out.println("More than 4");

                    Toast.makeText(context, "Password can't be more than 4 digits" , Toast.LENGTH_LONG).show();
                }
                else{
                    SharedPrefUtil.getInstance(context).putString(KEY , input.getText().toString());
                    Log.d("tasfia" , "set pin kaj kore ki ei khane ashe?" );
                    Toast.makeText(context, "Password set successful!" , Toast.LENGTH_LONG).show();

                    // Toast.makeText(context, "Password set successful!" , Toast.LENGTH_LONG).show();
                    password = input.getText().toString();
                    //btnSetPin.setText("Update password");
                }



            }
        }).setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // dialog.dismisss();
              //  dialog.cancel();

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

        dialog.show();
        Log.d("tasfia" , "set pin kaj koree" );

    }

    private void UpdatePassword(Context context){
        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        TextView t1 = new TextView(context);
        t1.setText("Enter Your Previous Pin");

        linearLayout.addView(t1);

        EditText input = new EditText(context);

        //| InputType.TYPE_NUMBER_VARIATION_PASSWORD

        input.setInputType(InputType.TYPE_CLASS_NUMBER ) ;
        linearLayout.addView(input);


        TextView t2 = new TextView(context);
        t2.setText("Enter Your New Pin");

        linearLayout.addView(t2);

        EditText input2 = new EditText(context);
        input2.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD) ;

        linearLayout.addView(input2);




        dialog.setView(linearLayout);

        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // update password

                if(password.equals(input.getText().toString())){
                    if(input2.getText().toString().length()>4)
                    {
                        Toast.makeText(context, "Password can't be more than 4 digits" , Toast.LENGTH_LONG).show();
                    }
                    else{
                        SharedPrefUtil.getInstance(context).putString(KEY , input2.getText().toString());
                        Toast.makeText(context, "Pin update successful!" , Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    Toast.makeText(context, "Sorry old pin is incorrect" , Toast.LENGTH_LONG).show();
                }

            }
        }).setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // dialog.dismisss();

            }
        });

        dialog.show();
        Log.d("tasfia" , "update pin kaj koree" );

    }



    private void appprivacysettingActivity(Context context) {
        if(!isAccessGranted()){
            Toast.makeText(MainActivity.this, "Sorry! First allow app usage permission" , Toast.LENGTH_LONG).show();
        }
        else {

            if(!password.isEmpty() ){
                Intent intentlock = new Intent( MainActivity.this , app_privacy_setting.class);
                startActivity(intentlock);
            }
            else{
                Toast.makeText(MainActivity.this, "Sorry! Set a pin first!" , Toast.LENGTH_LONG).show();
                setPassword(context);
            }
        }

    }

    /*
    public void profileSettingActivity(View view)
    {
        buttonprofile = findViewById(R.id.setting_cardview);
        buttonprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent objprofile = new Intent(MainActivity.this, profile_setting.class);
                startActivity(objprofile);
            }
        });

    }
*/








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



