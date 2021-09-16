package com.example.loginproject_helena;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.loginproject_helena.database.AppDataBase;
import com.example.loginproject_helena.model.SignDao;
import com.example.loginproject_helena.model.SignModel;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
//اینجا هرچی مربوط به signUpهست را مینویسیم
public class SignUpp extends AppCompatActivity implements SignDao  {


  EditText edtName,edt_lastName,nameKarbari,password,againPassword;
  Button btn_register;

  String signModels;
  SignDao signDao;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_sign_upp);
    //اینجا اومدم گفتم دیتابیس را بگیر به signDao
    signDao = AppDataBase.getDataBase(this).getSignDao();
    signModels = signDao.getAllSign("");

    findView();

    //روی دکمه کلیک کرد ذخیره بشه داخل دیتابیس
    btn_register.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        SignModel signModel = new SignModel();
        signModel.setName(edtName.getText().toString());
        signModel.setNameKarbari(nameKarbari.getText().toString());
        signModel.setFamilyName(edt_lastName.getText().toString());
        signModel.setCheked(false);
        signModel.setKalameObor(password.getText().toString());
      }
    });


  }

  private void findView() {
    edtName = findViewById(R.id.edtName);
    edt_lastName = findViewById(R.id.edt_lastName);
    nameKarbari = findViewById(R.id.nameKarbari);
    password = findViewById(R.id.password);
    againPassword = findViewById(R.id.againPassword);
    btn_register =findViewById(R.id.btn_register);

  }



  @Override
  public int addSign(SignModel model) {
    long result = signDao.addSign(model);
    if (result>0)
    {
      model.setId(result);
      Toast.makeText(this, "اضافه شد", Toast.LENGTH_SHORT).show();
    }else {
      Toast.makeText(this, "اضافه نشد", Toast.LENGTH_SHORT).show();
    }
    return (int) result;
  }

  @Override
  public int deleteSign(SignModel model) {
    int result = signDao.deleteSign(model);
    if (result>0)
    {
      Toast.makeText(this, "حذف شد", Toast.LENGTH_SHORT).show();
    }else {
      Toast.makeText(this, "حذف نشد", Toast.LENGTH_SHORT).show();
    }
    return result;
  }

  @Override
  public int updateSign(SignModel model) {
   int result = signDao.updateSign(model);
    if (result>0)
    {
      model.setId(result);
      Toast.makeText(this, "ویرایش شد", Toast.LENGTH_SHORT).show();
    }else {
      Toast.makeText(this, "ویرایش نشد", Toast.LENGTH_SHORT).show();
    }
    return result;
  }

  @Override
  public String getAllSign(String userName) {
    return null;
  }

  @Override
  public List<SignModel> getDeleteId(int id) {
    return null;
  }

  @Override
  public List<SignModel> searchName(String keyWord) {
    return null;
  }


}