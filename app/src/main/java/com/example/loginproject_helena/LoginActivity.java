package com.example.loginproject_helena;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginproject_helena.activities.SplashActivity;
import com.example.loginproject_helena.database.AppDataBase;
import com.example.loginproject_helena.model.SignDao;
import com.example.loginproject_helena.model.SignModel;

import androidx.appcompat.app.AppCompatActivity;


public class LoginActivity extends AppCompatActivity {
  EditText edt_nameLogin, edt_paswordLogin;
  Button login;
  TextView registerLogin;
  SignDao signDao;
  String signModel;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    edt_nameLogin = findViewById(R.id.edt_nameLogin);
    edt_paswordLogin = findViewById(R.id.edt_paswordLogin);
    login = findViewById(R.id.login);
    registerLogin = findViewById(R.id.registerLogin);

    SignModel model = new SignModel();
    String s = edt_nameLogin.getText().toString();

    SharedPreferences prefLoginn = getSharedPreferences("MYSHARED",MODE_PRIVATE);
    String userName = prefLoginn.getString("nameLogin","name");
    String password = prefLoginn.getString("passWordLogin","pass");


    login.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        // islogin را trueمیکنیم همونجا در کلاس splash
        //اینجا میگیم اگر islogدرست trueبود بره داخل main
        SplashActivity splashActivity = new SplashActivity();
        if (splashActivity.isLog)
        {
          Intent intent = new Intent(LoginActivity.this,MainActivity.class);
          startActivity(intent);
        }
      }
    });

    signDao = AppDataBase.getDataBase(this).getSignDao();
    signModel =signDao.getAllSign("");
     toLogin();
  }


  //در این تابع
  public void toLogin()
  {
    String username = String.valueOf(edt_nameLogin.getText());
    String password = String.valueOf(edt_paswordLogin.getText());
    if (username.equals("")&& password.equals(""))
    {
      SplashActivity splash = new SplashActivity();
      if (splash.isLog)
      {
        SharedPreferences sharedd = getSharedPreferences("MYSHARED",MODE_PRIVATE);
        //valueofبرای تبدیل داده ها استفاده می شود
        sharedd.getString("nameLogin", String.valueOf(edt_nameLogin));
        sharedd.getString("passWordLogin",String.valueOf(edt_paswordLogin));
        
        Toast.makeText(this, "اطلاعات ذخیره شد", Toast.LENGTH_SHORT).show();
      }else {
        Toast.makeText(this, "اطلاعات ذخیره نشد", Toast.LENGTH_SHORT).show();
      }
    }
  }
}