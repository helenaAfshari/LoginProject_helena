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
import java.lang.Boolean;
import java.lang.Class;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class SignDao_Impl implements SignDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<SignModel> __insertionAdapterOfSignModel;

  private final EntityDeletionOrUpdateAdapter<SignModel> __deletionAdapterOfSignModel;

  private final EntityDeletionOrUpdateAdapter<SignModel> __updateAdapterOfSignModel;

  private final SharedSQLiteStatement __preparedStmtOfGetDeleteId;

  public SignDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSignModel = new EntityInsertionAdapter<SignModel>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `tbl_sign` (`id`,`name`,`familyName`,`cheked`,`nameKarbari`,`kalameObor`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SignModel value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getFamilyName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getFamilyName());
        }
        final Integer _tmp;
        _tmp = value.getGender() == null ? null : (value.getGender() ? 1 : 0);
        if (_tmp == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, _tmp);
        }
        if (value.getNameKarbari() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getNameKarbari());
        }
        if (value.getKalameObor() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getKalameObor());
        }
      }
    };
    this.__deletionAdapterOfSignModel = new EntityDeletionOrUpdateAdapter<SignModel>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `tbl_sign` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SignModel value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfSignModel = new EntityDeletionOrUpdateAdapter<SignModel>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `tbl_sign` SET `id` = ?,`name` = ?,`familyName` = ?,`cheked` = ?,`nameKarbari` = ?,`kalameObor` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SignModel value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getFamilyName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getFamilyName());
        }
        final Integer _tmp;
        _tmp = value.getGender() == null ? null : (value.getGender() ? 1 : 0);
        if (_tmp == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, _tmp);
        }
        if (value.getNameKarbari() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getNameKarbari());
        }
        if (value.getKalameObor() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getKalameObor());
        }
        stmt.bindLong(7, value.getId());
      }
    };
    this.__preparedStmtOfGetDeleteId = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM tbl_sign WHERE id";
        return _query;
      }
    };
  }

  @Override
  public int addSign(final SignModel model) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public int deleteSign(final SignModel model) {
    __db.assertNotSuspendingTransaction();
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__deletionAdapterOfSignModel.handle(model);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int updateSign(final SignModel model) {
    __db.assertNotSuspendingTransaction();
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__updateAdapterOfSignModel.handle(model);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<SignModel> getDeleteId(final int id) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public String getAllSign(final String userName) {
    final String _sql = "SELECT * FROM tbl_sign WHERE nameKarbari = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (userName == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userName);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final String _result;
      if(_cursor.moveToFirst()) {
        _result = new String();
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<SignModel> searchName(final String keyWord) {
    final String _sql = "SELECT * FROM tbl_sign WHERE name LIKE '%' ||?|| '%'";
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
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfFamilyName = CursorUtil.getColumnIndexOrThrow(_cursor, "familyName");
      final int _cursorIndexOfIsGender = CursorUtil.getColumnIndexOrThrow(_cursor, "cheked");
      final int _cursorIndexOfNameKarbari = CursorUtil.getColumnIndexOrThrow(_cursor, "nameKarbari");
      final int _cursorIndexOfKalameObor = CursorUtil.getColumnIndexOrThrow(_cursor, "kalameObor");
      final List<SignModel> _result = new ArrayList<SignModel>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final SignModel _item;
        _item = new SignModel();
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        _item.setName(_tmpName);
        final String _tmpFamilyName;
        if (_cursor.isNull(_cursorIndexOfFamilyName)) {
          _tmpFamilyName = null;
        } else {
          _tmpFamilyName = _cursor.getString(_cursorIndexOfFamilyName);
        }
        _item.setFamilyName(_tmpFamilyName);
        final Boolean _tmpIsGender;
        final Integer _tmp;
        if (_cursor.isNull(_cursorIndexOfIsGender)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getInt(_cursorIndexOfIsGender);
        }
        _tmpIsGender = _tmp == null ? null : _tmp != 0;
        _item.setGender(_tmpIsGender);
        final String _tmpNameKarbari;
        if (_cursor.isNull(_cursorIndexOfNameKarbari)) {
          _tmpNameKarbari = null;
        } else {
          _tmpNameKarbari = _cursor.getString(_cursorIndexOfNameKarbari);
        }
        _item.setNameKarbari(_tmpNameKarbari);
        final String _tmpKalameObor;
        if (_cursor.isNull(_cursorIndexOfKalameObor)) {
          _tmpKalameObor = null;
        } else {
          _tmpKalameObor = _cursor.getString(_cursorIndexOfKalameObor);
        }
        _item.setKalameObor(_tmpKalameObor);
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
