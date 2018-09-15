package com.colinares.tictactoe.RoomDatabase;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.colinares.tictactoe.Constants.AppConstants;
import com.colinares.tictactoe.Model.Winner;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by Colinares on 9/15/2018.
 */

@Dao
public interface LocalDao {
    // Dao method to get all score
    @Query("SELECT * FROM " + AppConstants.TBL_WINNER + " ORDER BY id DESC")
    LiveData<List<Winner>> getAllWinner();

    // Dao method to insert score
    @Insert(onConflict = REPLACE)
    void insertWinner(Winner winner);

}
