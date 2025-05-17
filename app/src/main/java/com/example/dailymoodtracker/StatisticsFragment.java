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
int[] happyCount;
int[] neutralCount;
int[] sadCount;

@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    return inflater.inflate(R.layout.statistics_fragment, container, false);
}

public void onViewCreated(@NonNull View view, @NonNull Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    numberHappy = view.findViewById(R.id.editTextNumberHappy);
    numberNeutral = view.findViewById(R.id.editTextNumberNeutral);
    numberSad = view.findViewById(R.id.editTextNumberSad);

    moodViewModel = new ViewModelProvider(this).get(MoodViewModel.class);

    moodViewModel.getAllMoods();




}
}
