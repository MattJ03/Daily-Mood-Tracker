package com.example.dailymoodtracker;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.content.Intent;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.widget.Button;

public class EnterMoodFragment extends Fragment {

    private String selectedMood;

    public EnterMoodFragment() {
        //Empty constructor which is needed for fragments
    }

    ImageView smiley, neutral, sad, home, settings, stats, profile;
    EditText notes;
    Button buttonEnter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.enter_mood_fragment, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
       super.onViewCreated(view, savedInstanceState);

       smiley = view.findViewById(R.id.imageViewHappy);
       neutral = view.findViewById(R.id.imageViewNeutral);
       sad = view.findViewById(R.id.imageViewSad);
       home = view.findViewById(R.id.imageViewHome);
       settings = view.findViewById(R.id.imageViewSettings);
       stats = view.findViewById(R.id.imageViewStats);
       profile = view.findViewById(R.id.imageViewProfile);
       buttonEnter = view.findViewById(R.id.buttonEMF);
       notes = view.findViewById(R.id.editTextTextJE);


       smiley.setOnClickListener(view1 -> {
           selectedMood = "Happy";
           Toast.makeText(getContext(), "You selected happy", Toast.LENGTH_LONG).show();
       });

       neutral.setOnClickListener( view1-> {
           selectedMood = "Neutral";
           Toast.makeText(getContext(), "You selected neutral", Toast.LENGTH_LONG).show();
       });

       sad.setOnClickListener(view1 -> {
           selectedMood = "Sad";
           Toast.makeText(getContext(), "You selected sad", Toast.LENGTH_LONG).show();

       });

       buttonEnter.setOnClickListener(v -> {
          if(selectedMood.isEmpty() && !notes.getText().toString().isEmpty()) {
              Toast.makeText(getContext(), "Select an emoji", Toast.LENGTH_SHORT).show();
          } else if(!selectedMood.isEmpty() && notes.getText().toString().isEmpty()) {
              Toast.makeText(getContext(), "Enter a note", Toast.LENGTH_SHORT).show();
          } else if(selectedMood.isEmpty() && notes.getText().toString().isEmpty()) {
              Toast.makeText(getContext(), "Enter information", Toast.LENGTH_SHORT).show();
          }
          else {
               MoodEntry moodEntry = new MoodEntry(selectedMood, notes.getText().toString());
               new Thread(() -> {
                   MoodDatabase.getInstance(getContext()).moodDao().insert(moodEntry);
               }).start();
           }
       });



    }
}
