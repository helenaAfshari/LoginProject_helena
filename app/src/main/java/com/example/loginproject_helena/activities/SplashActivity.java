package com.example.loginproject_helena.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.example.loginproject_helena.BaseApplication;
import com.example.loginproject_helena.LoginActivity;
import com.example.loginproject_helena.R;


public class SplashActivity extends Activity {

  BaseApplication baseApplication;


 public Boolean isLog;
  /*Duration of wait*/
  private final int SPLASH_DISPLAY_LENGTH = 2000;

  @Override
  protected void onCreate( Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_splash);

    new Handler().postDelayed(new Runnable() {
      @Override
      public void run() {
        /* Create an Intent that will start the MainActivity. */
        /*Intent mainIntent = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(mainIntent);
        finish();*/




        //اینجا مقادیر prefرا میگیریمgetمیکنیم
        SharedPreferences prefLogin = getSharedPreferences("MYSHARED",MODE_PRIVATE);
          isLog = prefLogin.getBoolean("isLogin",false);

        Intent intent;
        if (isLog)
        {
           intent = new Intent(SplashActivity.this,BaseApplication.class);
        }else {
          intent = new Intent(SplashActivity.this, LoginActivity.class);
        }
        startActivity(intent);

        

        /*
        * android application class
        * database va shared prefrence
        * */

        /*if(select count(*) from actors == 0)
          insert all object from actor

        if(!pref.isLogged)
          login activity
            else
              main activity*/
      }
    }, SPLASH_DISPLAY_LENGTH);
  }
}