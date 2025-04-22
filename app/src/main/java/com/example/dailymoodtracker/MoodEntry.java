package com.example.dailymoodtracker;


import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "mood_entries")
public class MoodEntry {
   @PrimaryKey(autoGenerate = true)
    public int id;

   public String mood;
   public String note;
   public long timestamp;

   public MoodEntry(String mood, String note, long timestamp) {
       this.mood = mood;
       this.note = note;
       this.timestamp = timestamp;
   }

}
