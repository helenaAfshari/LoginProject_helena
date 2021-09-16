package com.example.loginproject_helena.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tbl_sign")

public  class  SignModel implements Parcelable {

  @PrimaryKey(autoGenerate = true)
  private long id;
  private String name;
  private String familyName;

  public void setGender(Boolean gender) {
    isGender = gender;
  }

  @ColumnInfo(name = "cheked")
  private Boolean isGender;

  public Boolean getGender() {
    return isGender;
  }

  private String nameKarbari;
  private String kalameObor;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getFamilyName() {
    return familyName;
  }

  public void setFamilyName(String familyName) {
    this.familyName = familyName;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Boolean getCheked() {
    return isGender;
  }

  public void setCheked(Boolean cheked) {
    isGender = cheked;
  }

  public String getNameKarbari() {
    return nameKarbari;
  }

  public void setNameKarbari(String nameKarbari) {
    this.nameKarbari = nameKarbari;
  }

  public String getKalameObor() {
    return kalameObor;
  }

  public void setKalameObor(String kalameObor) {
    this.kalameObor = kalameObor;
  }


  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeLong(this.id);
    dest.writeString(this.name);
    dest.writeString(this.familyName);
    dest.writeValue(this.isGender);
    dest.writeString(this.nameKarbari);
    dest.writeString(this.kalameObor);

  }

  public void readFromParcel(Parcel source) {
    this.id = source.readLong();
    this.name = source.readString();
    this.familyName = source.readString();
    this.isGender = (Boolean) source.readValue(Boolean.class.getClassLoader());
    this.nameKarbari = source.readString();
    this.kalameObor = source.readString();

  }

  public SignModel() {
  }

  protected SignModel(Parcel in) {
    this.id = in.readLong();
    this.name = in.readString();
    this.familyName = in.readString();
    this.isGender = (Boolean) in.readValue(Boolean.class.getClassLoader());
    this.nameKarbari = in.readString();
    this.kalameObor = in.readString();
  }

  public static final Creator<SignModel> CREATOR = new Creator<SignModel>() {
    @Override
    public SignModel createFromParcel(Parcel source) {
      return new SignModel(source);
    }

    @Override
    public SignModel[] newArray(int size) {
      return new SignModel[size];
    }
  };
}
