package com.example.jenniferniang.karatetournament_app.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface RegisterDao {

    @Insert
    void insert(Register register);

    @Update
    void update(Register register);

    @Delete
    void delete(Register register);


    @Query("DELETE FROM register_table")
    void deleteAllRegisters();

    @Query("SELECT * FROM register_table ORDER BY username ASC")
    LiveData<List<Register>> getAllRegisters();
}
