package com.example.loginproject_helena.model;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface ArtistDao {

  @Insert
  long addArtist(ArtistModel artistModel);

  @Delete
  int deleteArtist(ArtistModel artistModel);

  @Update
  int updateArtist(ArtistModel artistModel);

  @Query("SELECT * FROM tbl_artist")
  List<ArtistModel>getAllArtist();

  @Query("DELETE FROM tbl_artist WHERE id")
  List<ArtistModel>getDeleteId();

  //سرچ بر اساس titleهست
  @Query("SELECT * FROM tbl_artist WHERE title LIKE '%' ||:keyWord|| '%'")
  List<ArtistModel>getSearch(String keyWord);

}
