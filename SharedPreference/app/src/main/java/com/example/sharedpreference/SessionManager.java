package com.example.sharedpreference;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;

public class SessionManager {
    Context context;
    SharedPreferences sp;
    SharedPreferences.Editor editor;

    private final String FILE_NAME="shopping";
    private final int FILE_MODE=0;

    public SessionManager(Context context){
        this.context=context;
        sp=context.getSharedPreferences(FILE_NAME,FILE_MODE);
        editor=sp.edit();
    }

    private final String KEY_NAME="Session_Name";
    private final String KEY_EMAIL="Session_Email";
    private final String KEY_PHONE="Session_Phone";
    private final String KEY_LOGGED_IN="Key_Session_If_Logged_In";

    public void CreateSession(String name,String email,String phone){
        editor.putString(KEY_NAME,name);
        editor.putString(KEY_EMAIL,email);
        editor.putString(KEY_PHONE,phone);
        editor.putBoolean(KEY_LOGGED_IN,true);
        editor.commit();
    }
    public boolean SessionCheck(){
        if (sp.contains(KEY_LOGGED_IN)) {

            return true;
        }
        else {
            return false;
        }
    }

    public void LogOut(){
        editor.clear();
        editor.commit();
        Intent i=new Intent(context, Login.class);
        context.startActivity(i);
    }
    public String SessionDetails(String Key){
        String value= sp.getString(Key,null);
        return value;
    }






}
