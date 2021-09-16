package com.example.loginproject_helena.model;


import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

//اینجا این کلاس میخوام داخل ریسایکلرم هرچی هست میخوام نمایش بدم
@Entity(tableName = "tbl_artist")
public class ArtistModel implements Parcelable {

  @PrimaryKey(autoGenerate = true)
  private long id;

  //TODO change variable name => content to link
  private String content;
  //TODO change var name >>>> title to name
  private String title;

  private Drawable image;

  public static final Creator<ArtistModel> CREATOR = new Creator<ArtistModel>() {
    @Override
    public ArtistModel createFromParcel(Parcel in) {
      return new ArtistModel();
    }

    @Override
    public ArtistModel[] newArray(int size) {
      return new ArtistModel[size];
    }
  };


  public long getId() {

    if(id == -1)
      id = 0;
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String data) {
    this.content = content;
  }

  public String getTitle() {
    if(title.equals(""))
      title = "name";
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Drawable getImage() {
    return image;
  }

  public void setImage(Drawable image) {
    this.image = image;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeLong(id);
    dest.writeString(content);
    dest.writeString(title);
    dest.writeString(String.valueOf(image));
  }


}
