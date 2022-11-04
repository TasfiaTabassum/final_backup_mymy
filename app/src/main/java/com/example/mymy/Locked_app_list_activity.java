package com.example.mymy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class Locked_app_list_activity extends AppCompatActivity {

    Context context ;

    RecyclerView recyclerView ;
    List<appModel> appModelList = new ArrayList<>();
    ArrayList<String> applockunlockstatename = new ArrayList<>();
    appAdapter adapter ;
    ProgressDialog progressDialog;

    private SharedPrefUtil pref ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locked_app_list);


        // calling the action bar
        ActionBar actionBar = getSupportActionBar();

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);





        context = this ;


        recyclerView = findViewById(R.id.lockedapplist);

        adapter = new appAdapter(appModelList , this) ;

        pref= new SharedPrefUtil(this);
        applockunlockstatename = pref.getState();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        progressDialog = new ProgressDialog(this);
        progressDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                //getInstalledapps(context);
                getlockedapps(getApplicationContext());
            }
        });

    }
    @Override
    protected void onResume() {
        super.onResume();
        progressDialog.setTitle("Fetching apps");
        progressDialog.setMessage("Loading...");
        progressDialog.show();
    }

    @Override
    protected void onStop(){
        super.onStop();
        progressDialog.setOnShowListener(null);
    }

    private void printList(List<String> list){
        for(int i=0; i < list.size(); i++)
        {
            Log.d("wadith vai" , list.get(i));
        }
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

    public void getlockedapps(Context context){


        pref= new SharedPrefUtil(this);
        applockunlockstatename = pref.getState();



        // List<String> list = SharedPrefUtil.getInstance(context).getListString();


        List<PackageInfo> packageInfos = getPackageManager().getInstalledPackages(0);
        //printList(list);
       // printapplockunlockList(applockunlockstatename);

        // add to list of dataset
        for(int i = 0; i < packageInfos.size(); i++)
        {
            String name = packageInfos.get(i).applicationInfo.loadLabel(getPackageManager()).toString();
            Drawable icon = packageInfos.get(i).applicationInfo.loadIcon(getPackageManager());
            String packname = packageInfos.get(i).packageName;

            if(applockunlockstatename.contains(packname)){
                appModelList.add( new appModel(name, icon, 1, packname));
            }
            else{
                continue;
            }

        }
        adapter.notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();
        progressDialog.dismiss();
    }


}