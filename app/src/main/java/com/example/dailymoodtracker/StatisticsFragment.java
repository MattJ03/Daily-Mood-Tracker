package com.example.dailymoodtracker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class StatisticsFragment extends Fragment {

public StatisticsFragment() {

}

EditText numberHappy, numberSad, numberNeutral;
MoodViewModel moodViewModel;


@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    return inflater.inflate(R.layout.statistics_fragment, container, false);
}

public void onViewCreated(@NonNull View view, @NonNull Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    numberHappy = view.findViewById(R.id.editTextNumberHappy);
    numberNeutral = view.findViewById(R.id.editTextNumberNeutral);
    numberSad = view.findViewById(R.id.editTextNumberSad);

    moodViewModel = new ViewModelProvider(requireActivity()).get(MoodViewModel.class);

    moodViewModel.getAllHappyMoods().observe(getViewLifecycleOwner(), happyMoods -> {
        if(happyMoods != null) {
            int happyCount = happyMoods.size();
            numberHappy.setText("Happy Days: " + happyCount);
        }
        else {
            numberHappy.setText("Happy count is 0");
        }
    });

    moodViewModel.getAllNeutralMoods().observe(getViewLifecycleOwner(), neutralMoods -> {
        if(neutralMoods != null) {
            int neutralCount = neutralMoods.size();
            numberNeutral.setText("Neutral Days:" + neutralCount);
        } else {
            numberNeutral.setText("Neutral count is: 0");
        }
    });

    moodViewModel.getAllNeutralMoods().observe(getViewLifecycleOwner(), sadMoods -> {
        if(sadMoods != null) {
            int sadCount = sadMoods.size();
            numberSad.setText("Sad Days: " + sadCount);
        } else {
            numberSad.setText("Sad count is: " + 0);
        }
    });

}
}
