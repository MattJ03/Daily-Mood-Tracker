package com.example.dailymoodtracker;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.content.Intent;

public class SettingsFragment extends Fragment {


    public SettingsFragment() {
        //my empty constructor
    }

    Spinner countryDropDown, gendersDropDown;
    EditText username;
    Button suicideButton, logOutBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.settings_fragment, container, false);
    }

    public void onViewCreated(@NonNull View view, @NonNull Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        countryDropDown = view.findViewById(R.id.countryDropDown);
        username = view.findViewById(R.id.)
    }

}
