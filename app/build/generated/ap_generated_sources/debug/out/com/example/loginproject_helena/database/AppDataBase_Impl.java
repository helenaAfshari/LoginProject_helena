package com.example.loginproject_helena.database;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.example.loginproject_helena.model.ArtistDao;
import com.example.loginproject_helena.model.ArtistDao_Impl;
import com.example.loginproject_helena.model.SignDao;
import com.example.loginproject_helena.model.SignDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDataBase_Impl extends AppDataBase {
  private volatile SignDao _signDao;

  private volatile ArtistDao _artistDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `tbl_sign` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT, `familyName` TEXT, `cheked` INTEGER, `nameKarbari` TEXT, `kalameObor` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `tbl_artist` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `content` TEXT, `title` TEXT, `image` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '981dfa5509ffc07a4bc2e3a3ea78b17d')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `tbl_sign`");
        _db.execSQL("DROP TABLE IF EXISTS `tbl_artist`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsTblSign = new HashMap<String, TableInfo.Column>(6);
        _columnsTblSign.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblSign.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblSign.put("familyName", new TableInfo.Column("familyName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblSign.put("cheked", new TableInfo.Column("cheked", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblSign.put("nameKarbari", new TableInfo.Column("nameKarbari", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblSign.put("kalameObor", new TableInfo.Column("kalameObor", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTblSign = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTblSign = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTblSign = new TableInfo("tbl_sign", _columnsTblSign, _foreignKeysTblSign, _indicesTblSign);
        final TableInfo _existingTblSign = TableInfo.read(_db, "tbl_sign");
        if (! _infoTblSign.equals(_existingTblSign)) {
          return new RoomOpenHelper.ValidationResult(false, "tbl_sign(com.example.loginproject_helena.model.SignModel).\n"
                  + " Expected:\n" + _infoTblSign + "\n"
                  + " Found:\n" + _existingTblSign);
        }
        final HashMap<String, TableInfo.Column> _columnsTblArtist = new HashMap<String, TableInfo.Column>(4);
        _columnsTblArtist.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblArtist.put("content", new TableInfo.Column("content", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblArtist.put("title", new TableInfo.Column("title", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblArtist.put("image", new TableInfo.Column("image", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTblArtist = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTblArtist = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTblArtist = new TableInfo("tbl_artist", _columnsTblArtist, _foreignKeysTblArtist, _indicesTblArtist);
        final TableInfo _existingTblArtist = TableInfo.read(_db, "tbl_artist");
        if (! _infoTblArtist.equals(_existingTblArtist)) {
          return new RoomOpenHelper.ValidationResult(false, "tbl_artist(com.example.loginproject_helena.model.ArtistModel).\n"
                  + " Expected:\n" + _infoTblArtist + "\n"
                  + " Found:\n" + _existingTblArtist);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "981dfa5509ffc07a4bc2e3a3ea78b17d", "a4006988c10bb3483a2f8171bf7a4bcf");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "tbl_sign","tbl_artist");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `tbl_sign`");
      _db.execSQL("DELETE FROM `tbl_artist`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(SignDao.class, SignDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ArtistDao.class, ArtistDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public SignDao getSignDao() {
    if (_signDao != null) {
      return _signDao;
    } else {
      synchronized(this) {
        if(_signDao == null) {
          _signDao = new SignDao_Impl(this);
        }
        return _signDao;
      }
    }
  }

  @Override
  public ArtistDao getArtistDao() {
    if (_artistDao != null) {
      return _artistDao;
    } else {
      synchronized(this) {
        if(_artistDao == null) {
          _artistDao = new ArtistDao_Impl(this);
        }
        return _artistDao;
      }
    }
  }
}
