package com.example.mymy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class appAdapter extends RecyclerView.Adapter<appAdapter.adapter_design_backend> {

    List<appModel> appModels = new ArrayList<>();
    Context con ;

    public appAdapter(List<appModel> appModels, Context con) {
        this.appModels = appModels;
        this.con = con;
    }

    @NonNull
    @Override
    public appAdapter.adapter_design_backend onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(con).inflate(R.layout.adapter_design, parent, false) ;
        adapter_design_backend design = new adapter_design_backend(view);
        return design;
    }

    @Override
    public void onBindViewHolder(@NonNull appAdapter.adapter_design_backend holder, int position) {

        appModel app = appModels.get(position);
        holder.appname.setText(app.getAppname());
        holder.appicon.setImageDrawable(app.getAppicon());

        if(app.getStatus() == 0){
            holder.appstatus.setImageResource(R.drawable.unlock);
        }
        else{
            holder.appstatus.setImageResource(R.drawable.lock);
        }

    }

    @Override
    public int getItemCount() {
        return appModels.size();
    }

    public class adapter_design_backend extends RecyclerView.ViewHolder {

        TextView appname;
        ImageView appicon , appstatus ;

        public adapter_design_backend(@NonNull View itemView) {
            super(itemView);

            appname = itemView.findViewById(R.id.appname);
            appicon = itemView.findViewById(R.id.appicon);
            appstatus = itemView.findViewById(R.id.appstatus);
        }
    }
}
