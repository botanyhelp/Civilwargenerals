/**Copyright (C) 2015 Thomas Maher
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */
package com.jimsuplee.civilwargenerals;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
//import android.util.Log;

/**
 * Created on 4/7/15.
 */

public class DBAdapter {
    static final String TAG = "CWG";
    static final String DATABASE_NAME = "civilwargenerals";
    static final String DATABASE_TABLE = "civilwargenerals";
    static final int DATABASE_VERSION = 1;

    static final String keyname = "keyname";
    static final String general = "general";
    static final String generaldata = "generaldata";
    static final String army = "army";

    static final String DATABASE_CREATE = "CREATE TABLE civilwargenerals (keyname text default null,general text default null,generaldata text default null,army integer default null);";

    final Context context;

    DatabaseHelper DBHelper;
    SQLiteDatabase db;

    public DBAdapter(Context ctx) {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                db.execSQL(DATABASE_CREATE);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            ////////Log.w(TAG, "Upgrading database from version " + oldVersion + " to "+ newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS civilwargenerals");
            onCreate(db);
        }
    }


    public DBAdapter open() throws SQLException {
        db = DBHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        DBHelper.close();
    }

    public Cursor getByGeneralName(String nameParam) throws SQLException {
        //Log.w(TAG, "In DBAdapter.getByFighterName("+nameParam+")");
        //String[] columns = new String[] {fightername, fighterdata};
        //We only need the fightername column to be returned, even though we search on fighterdata
        String[] columns = new String[] {keyname,general,generaldata,army};

        String selection;
        //We assume that the fighterdataParam has ALREADY be pre-and-post-pended with "%" for LIKE sql:
        //selection = "info LIKE ?";
        selection = "keyname = ?";
        String[] selectionArgs = new String[] { nameParam };
        //Log.w(TAG, "In DBAdapter.getByFighterName, about to dbquery("+selection+" "+selectionArgs[0]);
        Cursor mCursor = db.query(DATABASE_TABLE, columns, selection, selectionArgs, null, null, null);
        //Log.w(TAG, "In DBAdapter.getByFighterName(StringfighterdataParam), About to check if Cursor c is null");
        if (mCursor != null) {
            //Log.w(TAG,"In DBAdapter.getByFighterName(String fighterdataParam), c is NOT null, about to NOT c.moveToFirst()");
            //mCursor.moveToFirst();
            if(mCursor.moveToFirst()) {
                //Log.w(TAG,"In DBAdapter.getByFighterName(),mCursor.moveToFirst() is true");
            } else {
                //Log.w(TAG,"In DBAdapter.getByFighterName(),mCursor.moveToFirst() is NOT true");
            }
        }
        //Log.w(TAG, "In DBAdapter.getByFighterName(String fighterdataParam), about to return cursor, c");
        return mCursor;
    }
    public Cursor getByCarrierdata(String generaldataParam) throws SQLException {
        String[] columns = new String[] {keyname};
        String selection;
        selection = "generaldata LIKE ?";
        String[] selectionArgs = new String[] { generaldataParam };
        Cursor mCursor = db.query(DATABASE_TABLE, columns, selection, selectionArgs, null, null, null);
        if (mCursor != null) {
            if(mCursor.moveToFirst()) {
            } else {
            }
        }
        return mCursor;
    }
    public Cursor getByCarrierdata(String generaldataParam, String generaldataParamtwo) throws SQLException {
        String[] columns = new String[] {keyname};
        String selection;
        selection = "generaldata LIKE ? AND generaldata LIKE ?";
        String[] selectionArgs = new String[] { generaldataParam, generaldataParamtwo};
        Cursor mCursor = db.query(DATABASE_TABLE, columns, selection, selectionArgs, null, null, null);
        if (mCursor != null) {
            if(mCursor.moveToFirst()) {
            } else {
            }
        }
        return mCursor;
    }

    public Cursor getByCarrierdata(String generaldataParam, String generaldataParamtwo, String generaldataParamthree) throws SQLException {
        String[] columns = new String[] {keyname};
        String selection;
        selection = "generaldata LIKE ? AND generaldata LIKE ? AND generaldata LIKE ?";
        String[] selectionArgs = new String[] { generaldataParam, generaldataParamtwo, generaldataParamthree};
        Cursor mCursor = db.query(DATABASE_TABLE, columns, selection, selectionArgs, null, null, null);
        if (mCursor != null) {
            if(mCursor.moveToFirst()) {
            } else {
            }
        }
        return mCursor;
    }
    public Cursor getByCarrierdata(String generaldataParam, String generaldataParamtwo, String generaldataParamthree, String generaldataParamfour) throws SQLException {
        String[] columns = new String[] {keyname};
        String selection;
        selection = "generaldata LIKE ? AND generaldata LIKE ? AND generaldata LIKE ? AND generaldata LIKE ?";
        String[] selectionArgs = new String[] { generaldataParam, generaldataParamtwo, generaldataParamthree, generaldataParamfour};
        Cursor mCursor = db.query(DATABASE_TABLE, columns, selection, selectionArgs, null, null, null);
        if (mCursor != null) {
            if(mCursor.moveToFirst()) {
            } else {
            }
        }
        return mCursor;
    }	public Cursor getByCarrierdata(String generaldataParam, String generaldataParamtwo, String generaldataParamthree, String generaldataParamfour, String generaldataParamfive) throws SQLException
    {
        String[] columns = new String[] {keyname};
        String selection;
        selection = "generaldata LIKE ? AND generaldata LIKE ? AND generaldata LIKE ? AND generaldata LIKE ? AND generaldata LIKE ?";
        String[] selectionArgs = new String[] { generaldataParam, generaldataParamtwo, generaldataParamthree, generaldataParamfour, generaldataParamfive};
        Cursor mCursor = db.query(DATABASE_TABLE, columns, selection, selectionArgs, null, null, null);
        if (mCursor != null) {
            if(mCursor.moveToFirst()) {
            } else {
            }
        }
        return mCursor;
    }

}

