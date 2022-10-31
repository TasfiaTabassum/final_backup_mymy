package com.example.mymy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class app_privacy_setting extends AppCompatActivity {

    private Context context ;

    RecyclerView recyclerView ;
    List<appModel> appModelList = new ArrayList<>();
    appAdapter adapter ;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_privacy_setting);

        recyclerView = findViewById(R.id.recycleapplist);

        adapter = new appAdapter(appModelList , this) ;

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        progressDialog = new ProgressDialog(this);
        progressDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                getInstalledapps(context);
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

    public void getInstalledapps(Context context){



        List<String> list = SharedPrefUtil.getInstance(context).getListString();

        List<PackageInfo> packageInfos = getPackageManager().getInstalledPackages(0);


        // add to list of dataset
        for(int i = 0; i < packageInfos.size(); i++)
        {
            String name = packageInfos.get(i).applicationInfo.loadLabel(getPackageManager()).toString();
            Drawable icon = packageInfos.get(i).applicationInfo.loadIcon(getPackageManager());
            String packname = packageInfos.get(i).packageName;

            //appModelList.add( new appModel(name, icon, 0, packname));

            if(!list.isEmpty()){
                if(list.contains(appModelList.get(i).packagename)){
                    appModelList.add( new appModel(name, icon, 1, packname));
                    Log.d("tasfia" , "list empty na r list contains packname, status 1 , ei kaj cholee");
                }
                else{
                    appModelList.add( new appModel(name, icon, 0, packname));
                    Log.d("tasfia" , "list empty na r list doesn't contain packname, ei kaj cholee");
                }
            }
            else{
                appModelList.add( new appModel(name, icon, 0, packname));
                Log.d("tasfia" , "list empty r list doesn't contain packname, status 0 , ei kaj cholee");
            }

        }
        adapter.notifyDataSetChanged();
        progressDialog.dismiss();
    }

}