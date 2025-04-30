package com.example.dailymoodtracker;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MoodViewModel extends ViewModel {
    private final MutableLiveData<List<MoodEntry>> moodEntries = new MutableLiveData<>();
    private final Executor executor = Executors.newSingleThreadExecutor();
    private final EnterMoodDAO enterMoodDAO;

    public MoodViewModel(@NonNull Application application) {
        MoodDatabase moodDatabase = MoodDatabase.getInstance(application);
        enterMoodDAO = moodDatabase.moodDao();
        loadMoods();
    }

    public LiveData<List<MoodEntry>> getAllMoods() {
        return enterMoodDAO.getAllMoods();

    }

    public void loadMoods() {
        executor.execute(() -> {
            LiveData<List<MoodEntry>> moods = enterMoodDAO.getAllMoods();
        });
    }

    public void insert(MoodEntry moodEntry) {
        executor.execute(() -> {
            enterMoodDAO.insert(moodEntry);
            loadMoods(); //to refresh the list
        });
    }

}
