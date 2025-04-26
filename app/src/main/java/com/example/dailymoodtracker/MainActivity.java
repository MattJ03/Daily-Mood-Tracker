package com.example.dailymoodtracker;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;
import android.widget.ImageView;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.os.Bundle;
import android.os.Handler;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class MainActivity extends AppCompatActivity {

    EditText time;
    TextView welcome;
    Handler handler = new Handler();
    ImageView settingsImage, profileImage, statisticsImage, homeImage;
    Runnable getTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        time = findViewById(R.id.editTextTime);

        settingsImage = findViewById(R.id.imageViewSettings);
        profileImage = findViewById(R.id.imageViewProfile);
        statisticsImage = findViewById(R.id.imageViewStats);
        homeImage = findViewById(R.id.imageViewHome);

        getTime = new Runnable() {
            @Override
            public void run() {
                String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd:MM:yyyy-ss:mm:HH"));
                time.setText(currentTime);
                handler.postDelayed(getTime, 1000);
            }
        };
        getTime.run();

        String username = getIntent().getStringExtra("username"); // get the username from login and send to settings fragment




        homeImage.setOnClickListener(v -> {
            EnterMoodFragment fragment = new EnterMoodFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
        });

        settingsImage.setOnClickListener(v -> {
            SettingsFragment fragment = new SettingsFragment();
            Bundle bundle = new Bundle();
            bundle.putString("username", username);
            fragment.setArguments(bundle);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
        });

    }

}