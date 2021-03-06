package com.example.administrator.thefirstnavigation.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.administrator.thefirstnavigation.bean.GreenBean.SeclectorBean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "SECLECTOR_BEAN".
*/
public class SeclectorBeanDao extends AbstractDao<SeclectorBean, Long> {

    public static final String TABLENAME = "SECLECTOR_BEAN";

    /**
     * Properties of entity SeclectorBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property ChannelName = new Property(1, String.class, "channelName", false, "CHANNEL_NAME");
        public final static Property ChannelId = new Property(2, String.class, "channelId", false, "CHANNEL_ID");
        public final static Property IsShow = new Property(3, boolean.class, "isShow", false, "IS_SHOW");
    }


    public SeclectorBeanDao(DaoConfig config) {
        super(config);
    }
    
    public SeclectorBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"SECLECTOR_BEAN\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"CHANNEL_NAME\" TEXT," + // 1: channelName
                "\"CHANNEL_ID\" TEXT," + // 2: channelId
                "\"IS_SHOW\" INTEGER NOT NULL );"); // 3: isShow
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"SECLECTOR_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, SeclectorBean entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String channelName = entity.getChannelName();
        if (channelName != null) {
            stmt.bindString(2, channelName);
        }
 
        String channelId = entity.getChannelId();
        if (channelId != null) {
            stmt.bindString(3, channelId);
        }
        stmt.bindLong(4, entity.getIsShow() ? 1L: 0L);
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, SeclectorBean entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String channelName = entity.getChannelName();
        if (channelName != null) {
            stmt.bindString(2, channelName);
        }
 
        String channelId = entity.getChannelId();
        if (channelId != null) {
            stmt.bindString(3, channelId);
        }
        stmt.bindLong(4, entity.getIsShow() ? 1L: 0L);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public SeclectorBean readEntity(Cursor cursor, int offset) {
        SeclectorBean entity = new SeclectorBean( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // channelName
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // channelId
            cursor.getShort(offset + 3) != 0 // isShow
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, SeclectorBean entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setChannelName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setChannelId(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setIsShow(cursor.getShort(offset + 3) != 0);
     }
    
    @Override
    protected final Long updateKeyAfterInsert(SeclectorBean entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(SeclectorBean entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(SeclectorBean entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
