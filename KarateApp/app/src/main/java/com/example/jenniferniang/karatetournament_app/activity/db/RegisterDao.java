package com.example.jenniferniang.karatetournament_app.activity.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface RegisterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(RegisterTable registerTable);

    @Query("DELETE FROM register_table")
    void deleteAll();

    @Query("SELECT * from register_table ORDER BY username ASC")
    LiveData<List<RegisterTable>> getAll();
}
