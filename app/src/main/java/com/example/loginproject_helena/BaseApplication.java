package com.example.loginproject_helena;

import android.app.Application;
import android.content.SharedPreferences;
import android.util.Log;

public class BaseApplication extends Application {

  SharedPreferences pref;
  SharedPreferences.Editor editor;

  @Override
  public void onCreate() {
    //اینجا shared PreferenceوووdataBaseرو دو تا Objectاز روش میسازیم
    super.onCreate();
    stringShared();
    isLogin();
  }

//single tone
  public SharedPreferences getSharedPreference() {
    if(pref == null)
      pref = getSharedPreferences("Login_Prj", MODE_PRIVATE);
    return pref;
  }


  public SharedPreferences isLogin()
  {
    Log.i("islog", String.valueOf(pref.getBoolean("isLog", true)));
    Log.i("String",String.valueOf(pref.getString("logString","helena")));
    Log.i("Long",String.valueOf(pref.getLong("Long",44)));
    Log.i("Float", String.valueOf(Float.valueOf(pref.getFloat("Float",  5.5f))));

    return pref;
  }

  public void stringShared()
  {
    editor = getSharedPreference().edit();
    editor.putBoolean("isLog",true);
    editor.putString("hh","kk");
    editor.putLong("long",1);
    editor.putFloat("Float",1.3f);
    editor.apply();
  }




  public SharedPreferences.Editor getEditor() {
    return pref.edit();
  }


}
