package com.example.loginproject_helena;

import android.annotation.SuppressLint;
import android.content.Context;

import com.example.loginproject_helena.model.ArtistModel;

import java.util.ArrayList;
import java.util.List;

import androidx.core.content.res.ResourcesCompat;

public class ServerFake {
  @SuppressLint("ResourceType")
  public  static  List<ArtistModel> getData(Context context)
  {
    List<ArtistModel>allNews = new ArrayList<>();
    for (int i = 1; i <=6 ; i++) {
      ArtistModel news = new ArtistModel();
      news.setId(i);
       switch (i)
       {
         case 1:
           news.setTitle("AnjelinaJoli");
           news.setContent(context.getString(R.id.txtContent));
             news.setImage(ResourcesCompat.getDrawable(context.getResources(),R.drawable.anjelina,null));
             break;

         case 2:
           news.setTitle("bradPit");
           news.setContent(context.getString(R.id.txtContent));
           news.setImage(ResourcesCompat.getDrawable(context.getResources(),R.drawable.bradtpit,null));
           break;

         case 3:
           news.setTitle("dicaprio");
           news.setContent(context.getString(R.id.txtContent));
           news.setImage(ResourcesCompat.getDrawable(context.getResources(),R.drawable.dicaprio,null));
           break;

         case 4:
           news.setTitle("dragFrame");
           news.setContent(context.getString(R.id.txtContent));
           news.setImage(ResourcesCompat.getDrawable(context.getResources(),R.drawable.drag_frame,null));
           break;
         case 5:
           news.setTitle("TomCruse");
           news.setContent(context.getString(R.id.txtContent));
           news.setImage(ResourcesCompat.getDrawable(context.getResources(),R.drawable.tomcruse,null));
           break;

         case 6:
           news.setTitle("jani Dep");
           news.setContent(context.getString(R.id.txtContent));
           news.setImage(ResourcesCompat.getDrawable(context.getResources(),R.drawable.janidep,null));
           break;
       }
       allNews.add(news);
    }
    return allNews;
  }
}
