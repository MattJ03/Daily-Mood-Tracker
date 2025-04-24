package com.example.dailymoodtracker;

import androidx.room.Dao;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.PrimaryKey;
import androidx.room.Query;

import java.util.List;

public interface EnterMoodDAO {

    @Insert
    void insert(MoodEntry entry);

    @Query("SELECT * FROM mood_entries ORDER BY timestamp DESC")
    List<MoodEntry> getAllMoods();
}
