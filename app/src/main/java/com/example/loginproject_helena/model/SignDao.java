package com.example.loginproject_helena.model;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface SignDao {

  @Insert
  int addSign(SignModel model);

  @Delete
  int deleteSign(SignModel model);

  @Update
  int updateSign(SignModel model);


  //اینجا کل اطلاعات جدولم را برگردوندم
  @Query("SELECT * FROM tbl_sign WHERE nameKarbari = :userName")
  String getAllSign(String userName);

  @Query("DELETE FROM tbl_sign WHERE id")
  List<SignModel> getDeleteId(int id);

  //@Query("DELETE FROM tbl_sign WHERE nameKarbari")
  //List<SignModel>getDeleteName();

  //سرچ بر اساس نام هست فقط
  @Query("SELECT * FROM tbl_sign WHERE name LIKE '%' ||:keyWord|| '%'")
  List<SignModel> searchName(String keyWord);

}
