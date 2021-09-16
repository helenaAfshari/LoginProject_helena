package com.example.loginproject_helena.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tbl_user")
class User {

  @PrimaryKey (autoGenerate = true)
  int id;

  String name;
  boolean gender;
  String userName;
  String password;
  String mobileNumber;

  public User(int id, String name, boolean gender, String userName, String password, String mobileNumber) {
    this.id = id;
    this.name = name;
    this.gender = gender;
    this.userName = userName;
    this.password = password;
    this.mobileNumber = mobileNumber;
  }

  public User() {

  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isGender() {
    return gender;
  }

  public void setGender(boolean gender) {
    this.gender = gender;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getMobileNumber() {
    return mobileNumber;
  }

  public void setMobileNumber(String mobileNumber) {
    this.mobileNumber = mobileNumber;
  }
}
