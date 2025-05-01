package com.example.dailymoodtracker;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.PrimaryKey;
import androidx.room.Query;

import java.util.List;

@Dao
public interface EnterMoodDAO {

    @Insert
    void insert(MoodEntry entry);

    @Query("SELECT * from MOOD_ENTRIES")
    List<MoodEntry> getAllMoodsSync();

    @Query("SELECT * FROM mood_entries ORDER BY id DESC")
    LiveData<List<MoodEntry>> getAllMoods();  // Using LiveData to observe the changes
}