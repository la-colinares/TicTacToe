package com.colinares.tictactoe.RoomDatabase;

import android.app.Application;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.colinares.tictactoe.Constants.AppConstants;
import com.colinares.tictactoe.Model.Winner;

/**
 * Created by Colinares on 9/15/2018.
 */

@Database(entities = Winner.class, version = 1, exportSchema = false)
public abstract class LocalDatabase extends RoomDatabase {

    private static LocalDatabase mInstance;

    public static LocalDatabase getDatabase(Context context) {
        if (mInstance == null) {
            mInstance = Room.databaseBuilder(context.getApplicationContext(), LocalDatabase.class, AppConstants.DB_NAME).build();
        }
        return mInstance;
    }

    //method to remove instance
    public static void closeDatabase() {
        mInstance = null;
    }

    //define note dao ( data access object )
    public abstract LocalDao localDao();

}
