package com.example.mymy;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class appAdapter extends RecyclerView.Adapter<appAdapter.adapter_design_backend> {

    List<appModel> appModels = new ArrayList<>();
    Context context ;
    //ArrayList<String> lockedApps = new ArrayList<>();
    ArrayList<String> applockunlockstatename = new ArrayList<>();

    private SharedPrefUtil pref;

    public appAdapter(List<appModel> appModels, Context context) {
        this.appModels = appModels;
        this.context = context;

    }


    @NonNull
    @Override
    public appAdapter.adapter_design_backend onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.adapter_design, parent, false) ;
        adapter_design_backend design = new adapter_design_backend(view);
        return design;
    }

    @Override
    public void onBindViewHolder(@NonNull appAdapter.adapter_design_backend holder, int position) {

        appModel app = appModels.get(position);
        holder.appname.setText(app.getAppname());
        holder.appicon.setImageDrawable(app.getAppicon());



       holder.cardView.startAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(), R.anim.anim_one));

        if(app.getStatus() == 0){
            holder.appstatus.setImageResource(R.drawable.unlock);

        }
        else{
            holder.appstatus.setImageResource(R.drawable.lock);
            //lockedApps.add(app.getPackagename());
            applockunlockstatename.add(app.getPackagename());
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if(app.getStatus()==0){
                    app.setStatus(1);
                    holder.appstatus.setImageResource(R.drawable.lock);
                    Toast.makeText(context, app.getAppname()+" is locked!!", Toast.LENGTH_LONG).show();
                   // lockedApps.add(app.getPackagename());
                    applockunlockstatename.add(app.getPackagename());
                   // applockunlockstatename.get(position).set ;
                    //SharedPrefUtil.getInstance(context).putListString(lockedApps);

                    ArrayList<String> state = SharedPrefUtil.getInstance(context).getState();
                    state.addAll(applockunlockstatename);
                  //  Log.d("tasfia1" , "Locked apps" + lockedApps );
                    Log.d("tasfia1" , "Locked apps state" + applockunlockstatename );
                    Log.d("tasfia1" , "Locked apps state 2 " + state );
                    SharedPrefUtil.getInstance(context).saveState(state);



                }
                else{
                    app.setStatus(0);
                    holder.appstatus.setImageResource(R.drawable.unlock);
                    Toast.makeText(context, app.getAppname()+" is unlocked!!", Toast.LENGTH_LONG).show();
                   // lockedApps.remove(app.getPackagename());
                    applockunlockstatename.remove(app.getPackagename());
                   // SharedPrefUtil.getInstance(context).putListString(lockedApps);
                    SharedPrefUtil.getInstance(context).getState();
                    SharedPrefUtil.getInstance(context).saveState(applockunlockstatename);

                }
            }
        });

    }

    @Override
    public int getItemCount() {

        return appModels.size();
    }

    public class adapter_design_backend extends RecyclerView.ViewHolder {

        TextView appname;

        ImageView appicon , appstatus ;
        CardView cardView ;

        public adapter_design_backend(@NonNull View itemView) {
            super(itemView);


            cardView = itemView.findViewById(R.id.eachCardView);


            appname = itemView.findViewById(R.id.appname);
            appicon = itemView.findViewById(R.id.appicon);
            appstatus = itemView.findViewById(R.id.appstatus);

        }
    }
}
