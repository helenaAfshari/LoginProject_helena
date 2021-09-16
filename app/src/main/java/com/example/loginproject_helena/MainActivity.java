package com.example.loginproject_helena;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.loginproject_helena.database.AppDataBase;
import com.example.loginproject_helena.model.ArtistDao;
import com.example.loginproject_helena.model.ArtistModel;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

//اینجا فقط لیستم باشه
public class MainActivity extends AppCompatActivity implements ArtistDao {

  private RecyclerView recyclerView;
  private ArtistDao artistDao;

  List<ArtistModel> artistModels = new ArrayList<>();

  ImageView ic_search;

  AdapterRecycler adapterRecycler;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    //check if artist tbl is null , add data to artist tbl with Server fake
    // get data from database
    // add data tp Adapter recycler

    artistDao = AppDataBase.getDataBase(this).getArtistDao();
    artistModels = artistDao.getAllArtist();

    findView();
    setupRecycler();

  }

  //این جا مدل لیستم را برای نمایش گذاشتم
  private void findView() {

    recyclerView = findViewById(R.id.recyclerView);
    recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
    ic_search = findViewById(R.id.ic_search);


    ic_search.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        List<ArtistModel> artistModels = artistDao.getSearch(artistDao.toString());
        adapterRecycler.loadRealTime(artistModels);
      }
    });


  }

  //در اینجا اومدم سرور را به اداپتور متصل کردم
  private void setupRecycler() {
    AdapterRecycler adapter = new AdapterRecycler(this, ServerFake.getData(this));
    recyclerView.setAdapter(adapter);
  }


  @Override
  public long addArtist(ArtistModel artistModel) {
    //که بتونم همون موقع داخل لیستم ببینم
    //addبشه داخل recycler
    long result = artistDao.addArtist(artistModel);
    if (result != -1) {
      artistModel.setId(result);
      adapterRecycler.addDataItem(artistModels);
      Toast.makeText(this, "ذخیره شد", Toast.LENGTH_SHORT).show();
    } else {
      Toast.makeText(this, "ذخیره نشد", Toast.LENGTH_SHORT).show();
    }
    return result;
  }

  @Override
  public int deleteArtist(ArtistModel artistModel) {
    int result = artistDao.deleteArtist(artistModel);
    if (result > 0) {
      adapterRecycler.deleteItem(artistModel);
      Toast.makeText(this, "حذف شد", Toast.LENGTH_SHORT).show();
    } else {
      Toast.makeText(this, "حذف نشد", Toast.LENGTH_SHORT).show();
    }
    return result;
  }

  @Override
  public int updateArtist(ArtistModel artistModel) {
    int result = artistDao.updateArtist(artistModel);
    if (result > 0) {
      adapterRecycler.updateItem(artistModel);
      Toast.makeText(this, "ویرایش شد", Toast.LENGTH_SHORT).show();
    } else {
      Toast.makeText(this, "ویرایش نشد", Toast.LENGTH_SHORT).show();
    }
    return result;
  }

  @Override
  public List<ArtistModel> getAllArtist() {
    return null;
  }

  @Override
  public List<ArtistModel> getDeleteId() {
    return null;
  }

  @Override
  public List<ArtistModel> getSearch(String keyWord) {
    return null;
  }
}