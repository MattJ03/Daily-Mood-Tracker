package com.example.dailymoodtracker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.content.Intent;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.widget.Button;

public class EnterMoodFragment extends Fragment{

    private String selectedMood;

    public EnterMoodFragment() {
        //Empty constructor which is needed for fragments
    }

    ImageView smiley, neutral, sad, home, settings, stats, profile;

      @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.enter_mood_fragment, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
       super.onViewCreated(view, savedInstanceState);

       smiley = view.findViewById(R.id.imageViewHappy);
       neutral = view.findViewById(R.id.imageViewNeutral);


    }
}
