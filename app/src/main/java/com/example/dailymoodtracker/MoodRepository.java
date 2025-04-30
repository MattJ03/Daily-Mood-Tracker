package com.example.dailymoodtracker;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

public class MoodRepository {

    private static EnterMoodDAO enterMoodDao;

    public MoodRepository(Context context) {
      MoodDatabase moodDatabase = MoodDatabase.getInstance(context);
      enterMoodDao = moodDatabase.moodDao();  //enter mood data takes the instance of the database
    }

    public LiveData<List<MoodEntry>> getAllMoods() {
        return enterMoodDao.getAllMoods();
    }

    public MoodEntry insert(MoodEntry moodEntry) {
        enterMoodDao.insert(moodEntry);
    }
}
