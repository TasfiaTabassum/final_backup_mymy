package com.example.mymy;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import android.preference.PreferenceManager;
import android.util.Log;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class SharedPrefUtil{

    private SharedPreferences pref ;
    private Gson gson;



    Context context;
    private SharedPreferences.Editor mEditor ;
   // private List<String> lockedAppList;
    private ArrayList<String> applockunlockstatename ;


    public SharedPrefUtil(Context context) {
        pref = context.getSharedPreferences("SharedPref" , Context.MODE_PRIVATE);
        gson = new Gson();
    }

    public void saveState(ArrayList<String> applockunlockstatename){

        Log.d("tasfia" ,"setting data"  +  gson.toJson(applockunlockstatename)) ;
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("tasks" , gson.toJson(applockunlockstatename)) ;
        editor.apply();

        printapplockunlockList(applockunlockstatename);

    }

    public ArrayList<String> getState(){
        String stateString = pref.getString("tasks" , null);
        Type taskListType = new TypeToken<ArrayList<String>>(){}.getType() ;
        ArrayList<String> state = gson.fromJson(stateString , taskListType);
        Log.d("tasfia" , "received data" + stateString) ;
        if(state != null){
            return  state;
        }
        else{
            return new ArrayList<>();
        }
    }










    public static SharedPrefUtil getInstance(Context context){
        return new SharedPrefUtil(context);
    }

    public void putString(String key, String value){
        pref.edit().putString(key, value).apply();
       /* mEditor.putString(key,value);
        mEditor.apply();*/
    }

    public void putInt(String key, int value){
        pref.edit().putInt(key, value).apply();
        // pref.getInt(String.valueOf(R.string.id), 0);
    }

    public void putBoolean(String key, boolean value){
        pref.edit().putBoolean(key, value).apply();
    }

    public  String getString(String key){
        String s = pref.getString(key,"default_value");
//        return  pref.getString(key, "");
//        getRe
        return s;
    }

    public  int getInt(String key)
    {
        return  pref.getInt(key,0);
    }

    public  boolean getBoolean(String key){
        return  pref.getBoolean(key,false);
    }

    private void printList(List<String> list){
        for(int i=0; i < list.size(); i++)
        {
            Log.d("wadith vai" , list.get(i));
        }
    }
    private void printapplockunlockList(ArrayList<String> applockunlockstatename){
        for(int i=0; i < applockunlockstatename.size(); i++)
        {
            Log.d("wadith vai copy" , applockunlockstatename.get(i));
        }
    }



    /*



    public void putListString(ArrayList<String> applockunlockstatename){


//        lockedAppList.add(list.get(0));
//        for(int i=0; i<list.size(); i++){
//            lockedAppList.add(list.get(i));
//        }
//        printList(lockedAppList);
        Log.d("wadith vai", "List add hoche");
//        printList(lockedAppList);
        for(int i=0; i < applockunlockstatename.size(); i++)
        {
            putString("App_"+i, applockunlockstatename.get(i));

        }
        String s = getString("App_");
        Log.d("wadith", s);
        putInt("listSize", applockunlockstatename.size());
    }

    public ArrayList<String> getListString(){
        Log.d("wadith vai", "List pathache hoche");
        int size = getInt("listSize");
        ArrayList<String> temp = new ArrayList<>();
        for(int i=0; i < size; i++)
        {
            temp.add(getString("app_"+i));
        }
        printList(temp);
        return temp;
//        return lockedAppList;
    }





     */


}





















