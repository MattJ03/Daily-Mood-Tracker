package com.example.dailymoodtracker;

import android.Manifest.permission;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.graphics.PaintKt;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;
import android.widget.ImageView;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.os.Bundle;
import android.os.Handler;
import android.Manifest;
import java.security.Permission;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    EditText time;
    TextView welcome;
    Handler handler = new Handler();
    ImageView settingsImage, profileImage, statisticsImage, homeImage;
    Runnable getTime;
    MoodAdapter adapter;
    MoodViewModel moodViewModel;

    int CALL_PHONE_PERMISSION = 1;
    int CAMERA_PERMISSION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, CALL_PHONE_PERMISSION);
        }

        if(ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CAMERA}, CAMERA_PERMISSION);
        }

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



        String username = getIntent().getStringExtra("usernameText"); // get the username from login and send to settings fragment


        RecyclerView recyclerView = findViewById(R.id.RecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MoodAdapter(new ArrayList<>());
        recyclerView.setAdapter(adapter);

        moodViewModel = new ViewModelProvider(this).get(MoodViewModel.class);

        moodViewModel.getAllMoods().observe(this, moodEntryList -> {
            adapter.setMoodList(moodEntryList);
        });


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
            bundle.putString("usernameText", username);
            fragment.setArguments(bundle);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
        });

        profileImage.setOnClickListener(v -> {
            ProfileFragment fragment = new ProfileFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
        });

         statisticsImage.setOnClickListener(view -> {
             StatisticsFragment statisticsFragment = new StatisticsFragment();
             getSupportFragmentManager()
                     .beginTransaction()
                     .replace(R.id.fragment_container, statisticsFragment)
                     .commit();
         });


    }



}