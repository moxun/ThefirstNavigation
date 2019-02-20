package com.example.administrator.thefirstnavigation.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.administrator.thefirstnavigation.bean.GreenBean.LoginBean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "LOGIN_BEAN".
*/
public class LoginBeanDao extends AbstractDao<LoginBean, Long> {

    public static final String TABLENAME = "LOGIN_BEAN";

    /**
     * Properties of entity LoginBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Phone = new Property(1, String.class, "phone", false, "PHONE");
        public final static Property Islogin = new Property(2, boolean.class, "islogin", false, "ISLOGIN");
    }


    public LoginBeanDao(DaoConfig config) {
        super(config);
    }
    
    public LoginBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"LOGIN_BEAN\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"PHONE\" TEXT," + // 1: phone
                "\"ISLOGIN\" INTEGER NOT NULL );"); // 2: islogin
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"LOGIN_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, LoginBean entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String phone = entity.getPhone();
        if (phone != null) {
            stmt.bindString(2, phone);
        }
        stmt.bindLong(3, entity.getIslogin() ? 1L: 0L);
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, LoginBean entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String phone = entity.getPhone();
        if (phone != null) {
            stmt.bindString(2, phone);
        }
        stmt.bindLong(3, entity.getIslogin() ? 1L: 0L);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public LoginBean readEntity(Cursor cursor, int offset) {
        LoginBean entity = new LoginBean( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // phone
            cursor.getShort(offset + 2) != 0 // islogin
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, LoginBean entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setPhone(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setIslogin(cursor.getShort(offset + 2) != 0);
     }
    
    @Override
    protected final Long updateKeyAfterInsert(LoginBean entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(LoginBean entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(LoginBean entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
