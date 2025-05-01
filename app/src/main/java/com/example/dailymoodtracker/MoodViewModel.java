package com.example.dailymoodtracker;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MoodViewModel extends AndroidViewModel {
    private final MutableLiveData<List<MoodEntry>> moodEntries = new MutableLiveData<>();
    private final Executor executor = Executors.newSingleThreadExecutor();
    private final EnterMoodDAO enterMoodDAO;

    public MoodViewModel(Application application) {
        super(application);
        MoodDatabase moodDatabase = MoodDatabase.getInstance(application);
        enterMoodDAO = moodDatabase.moodDao();
        loadMoods(); // Load moods initially
    }

    public LiveData<List<MoodEntry>> getAllMoods() {
        return moodEntries; // Return the MutableLiveData that contains the mood entries
    }

    // Load moods from database
    public void loadMoods() {
        executor.execute(() -> {
            // Get the list of moods from the DAO (synchronously)
            List<MoodEntry> moods = enterMoodDAO.getAllMoodsSync(); // Synchronous call
            // Post the list of moods to the LiveData on the main thread
            moodEntries.postValue(moods);
        });
    }

    // Insert a new mood entry
    public void insert(MoodEntry moodEntry) {
        executor.execute(() -> {
            enterMoodDAO.insert(moodEntry);
            loadMoods(); // Refresh the list after insertion
        });
    }
}