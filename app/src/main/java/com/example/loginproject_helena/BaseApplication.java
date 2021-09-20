package com.example.loginproject_helena;

import android.app.Application;
import android.content.SharedPreferences;
import android.widget.Toast;

public class BaseApplication extends Application {

  SharedPreferences pref;
  SharedPreferences.Editor editor;

  @Override
  public void onCreate() {
    //اینجا shared PreferenceوووdataBaseرو دو تا Objectاز روش میسازیم
    stringShared();
    isLogin();
    super.onCreate();
  }

//single tone
  public SharedPreferences getSharedPreference() {
    if(pref == null)
      pref = getSharedPreferences("Login_Prj", MODE_PRIVATE);
    return pref;
  }


  public SharedPreferences isLogin()
  {
    boolean enable = pref.getBoolean("isLog",false);

    if (enable)
    {
      Toast.makeText(this, "true", Toast.LENGTH_SHORT).show();
    }else {
      Toast.makeText(this, "false", Toast.LENGTH_SHORT).show();
    }
    return pref;
  }

  public void stringShared()
  {
    editor.putString("hh","kk");
    editor.putLong("long",1);
    editor.putFloat("floate",0.3f);
    editor.putBoolean("isLog",false);
    editor.commit();
  }




  public SharedPreferences.Editor getEditor() {
    return pref.edit();
  }


}
