package com.example.dailymoodtracker;

import android.app.Application;
import android.content.Context;

import java.util.List;

public class MoodRepository {

    private static EnterMoodDAO enterMoodDao;

    public MoodRepository(Context context) {
      MoodDatabase moodDatabase = MoodDatabase.getInstance(context);
      enterMoodDao = moodDatabase.moodDao();  //enter mood data takes the instance of the database
    }

    public List<MoodEntry> getAllMoods()
}
