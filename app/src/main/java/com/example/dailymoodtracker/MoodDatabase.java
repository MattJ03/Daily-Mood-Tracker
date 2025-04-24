package com.example.dailymoodtracker;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import androidx.room.Database;

@Database(entities = {MoodEntry.class}, version = 1)
public abstract class MoodDatabase extends RoomDatabase {

    private static MoodDatabase instance;

    public abstract EnterMoodDAO moodDao();

    public static synchronized MoodDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            MoodDatabase.class, "mood_database")
                    .build();
        }
        return instance;
    }
}