package com.example.dailymoodtracker;


import android.widget.ImageView;

import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "mood_entries")
public class MoodEntry {
   @PrimaryKey(autoGenerate = true)
    public int id;

   public String mood;
   public String note;
   public int moodImage;

   public MoodEntry(String mood, String note) {
       this.mood = mood;
       this.note = note;
       this.moodImage = moodImage;
   }

}
