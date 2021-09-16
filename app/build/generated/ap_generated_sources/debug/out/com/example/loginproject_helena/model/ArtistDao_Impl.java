package com.example.loginproject_helena.model;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ArtistDao_Impl implements ArtistDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ArtistModel> __insertionAdapterOfArtistModel;

  private final EntityDeletionOrUpdateAdapter<ArtistModel> __deletionAdapterOfArtistModel;

  private final EntityDeletionOrUpdateAdapter<ArtistModel> __updateAdapterOfArtistModel;

  private final SharedSQLiteStatement __preparedStmtOfGetDeleteId;

  public ArtistDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfArtistModel = new EntityInsertionAdapter<ArtistModel>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `tbl_artist` (`id`,`content`,`title`,`image`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ArtistModel value) {
        stmt.bindLong(1, value.getId());
        if (value.getContent() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getContent());
        }
        if (value.getTitle() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTitle());
        }
      }
    };
    this.__deletionAdapterOfArtistModel = new EntityDeletionOrUpdateAdapter<ArtistModel>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `tbl_artist` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ArtistModel value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfArtistModel = new EntityDeletionOrUpdateAdapter<ArtistModel>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `tbl_artist` SET `id` = ?,`content` = ?,`title` = ?,`image` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ArtistModel value) {
        stmt.bindLong(1, value.getId());
        if (value.getContent() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getContent());
        }
        if (value.getTitle() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTitle());
        }
        stmt.bindLong(5, value.getId());
      }
    };
    this.__preparedStmtOfGetDeleteId = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM tbl_artist WHERE id";
        return _query;
      }
    };
  }

  @Override
  public long addArtist(final ArtistModel artistModel) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfArtistModel.insertAndReturnId(artistModel);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int deleteArtist(final ArtistModel artistModel) {
    __db.assertNotSuspendingTransaction();
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__deletionAdapterOfArtistModel.handle(artistModel);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int updateArtist(final ArtistModel artistModel) {
    __db.assertNotSuspendingTransaction();
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__updateAdapterOfArtistModel.handle(artistModel);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<ArtistModel> getDeleteId() {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public List<ArtistModel> getAllArtist() {
    final String _sql = "SELECT * FROM tbl_artist";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfContent = CursorUtil.getColumnIndexOrThrow(_cursor, "content");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfImage = CursorUtil.getColumnIndexOrThrow(_cursor, "image");
      final List<ArtistModel> _result = new ArrayList<ArtistModel>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ArtistModel _item;
        _item = new ArtistModel();
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpContent;
        if (_cursor.isNull(_cursorIndexOfContent)) {
          _tmpContent = null;
        } else {
          _tmpContent = _cursor.getString(_cursorIndexOfContent);
        }
        _item.setContent(_tmpContent);
        final String _tmpTitle;
        if (_cursor.isNull(_cursorIndexOfTitle)) {
          _tmpTitle = null;
        } else {
          _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        }
        _item.setTitle(_tmpTitle);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<ArtistModel> getSearch(final String keyWord) {
    final String _sql = "SELECT * FROM tbl_artist WHERE title LIKE '%' ||?|| '%'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (keyWord == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyWord);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfContent = CursorUtil.getColumnIndexOrThrow(_cursor, "content");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfImage = CursorUtil.getColumnIndexOrThrow(_cursor, "image");
      final List<ArtistModel> _result = new ArrayList<ArtistModel>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ArtistModel _item;
        _item = new ArtistModel();
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpContent;
        if (_cursor.isNull(_cursorIndexOfContent)) {
          _tmpContent = null;
        } else {
          _tmpContent = _cursor.getString(_cursorIndexOfContent);
        }
        _item.setContent(_tmpContent);
        final String _tmpTitle;
        if (_cursor.isNull(_cursorIndexOfTitle)) {
          _tmpTitle = null;
        } else {
          _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        }
        _item.setTitle(_tmpTitle);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
