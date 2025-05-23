package com.example.dailymoodtracker;

import android.app.Application;
import android.content.Context;
import java.lang.*;

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

    public void insert(MoodEntry moodEntry) {
       new Thread(() -> enterMoodDao.insert(moodEntry)).start();
    }

    public LiveData<List<MoodEntry>> getAllHappyMoods() {
        return enterMoodDao.getAllHappyMoods();
    }

    public LiveData<List<MoodEntry>> getAllNeutralMoods() {
        return enterMoodDao.getAllNeutralMoods();
    }

    public LiveData<List<MoodEntry>> getAllSadMoods() {
        return enterMoodDao.getAllSadMoods();
    }
}
