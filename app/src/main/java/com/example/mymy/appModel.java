package com.example.mymy;

import android.graphics.drawable.Drawable;

public class appModel {

    String appname;
    Drawable appicon;
    int status; //status is 0 then app is unlocked otherwise app is locked
    String packagename;


    public appModel(String appname, Drawable appicon, int status, String packagename) {
        this.appname = appname;
        this.appicon = appicon;
        this.status = status;
        this.packagename = packagename;
    }

    public String getAppname() {
        return appname;
    }

    public void setAppname(String appname) {
        this.appname = appname;
    }

    public Drawable getAppicon() {
        return appicon;
    }

    public void setAppicon(Drawable appicon) {
        this.appicon = appicon;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPackagename() {
        return packagename;
    }

    public void setPackagename(String packagename) {
        this.packagename = packagename;
    }
}
