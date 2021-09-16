package com.example.loginproject_helena.database;

import android.content.Context;

import com.example.loginproject_helena.model.ArtistDao;
import com.example.loginproject_helena.model.ArtistModel;
import com.example.loginproject_helena.model.SignDao;
import com.example.loginproject_helena.model.SignModel;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(version = 1,exportSchema = false, entities = {SignModel.class, ArtistModel.class})
public abstract class AppDataBase extends RoomDatabase  {

//فقط بدنه میزاریم برای کانستراکتور

  public static AppDataBase dataBase;

  public static AppDataBase getDataBase(Context context)
  {

    if (dataBase == null)
    {
      //یک دیتابیس با این دستور ایجاد میکنه با این نام
      dataBase = Room.databaseBuilder(context.getApplicationContext(), AppDataBase.class,"db_sign")
        .allowMainThreadQueries()
        .build();
    }
    return dataBase;
  }
  //این تابع abstractرو جایی که میخوام میام بازسازیش میکنم
  //چون این کلاس را abstracکرده بودم مارو مجبور میکنه که این تابع را overrideکنم خروجیش هم از همون دیتامدل accsessمن هست که دستورات رو اونجا نوشتم
  public abstract SignDao getSignDao();
  public abstract ArtistDao getArtistDao();
}
