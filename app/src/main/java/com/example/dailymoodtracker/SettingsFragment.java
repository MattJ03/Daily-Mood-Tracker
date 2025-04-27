package com.example.dailymoodtracker;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.content.Intent;
import android.Manifest;
import android.os.BaseBundle;
public class SettingsFragment extends Fragment {

    int suicideNumber = 116123;

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
        gendersDropDown = view.findViewById(R.id.gendersDropDown);
        username = view.findViewById(R.id.editTextSettingsEmail);
        suicideButton = view.findViewById(R.id.buttonSuicideHotline);
        logOutBtn = view.findViewById(R.id.buttonLogOut);

        Bundle bundle = getArguments();
        if (bundle != null && bundle.getString("usernameText") != null) {
            username.setText(bundle.getString("usernameText"));
        }

        suicideButton.setOnClickListener(view2 -> {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + suicideNumber));
            startActivity(intent);
               });

        logOutBtn.setOnClickListener(view3 -> {
          Intent intent = new Intent(getActivity(), LogIn.class);
          startActivity(intent);
        });

    }

}
