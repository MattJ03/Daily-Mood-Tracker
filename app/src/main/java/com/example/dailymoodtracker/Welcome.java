package com.example.dailymoodtracker;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Handler;

public class Welcome extends AppCompatActivity {

    EditText welcomeText;
    Runnable changeScreen;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

        welcomeText = findViewById(R.id.editTextText);

        String name = getIntent().getStringExtra("usernameText").trim();
        String message = "Welcome " + name + "!";
        welcomeText.setText(message);


        new Handler().postDelayed(() -> {
            Intent intent = new Intent(Welcome.this, MainActivity.class);
            intent.putExtra("usernameText", name);
            startActivity(intent);
            finish();
            }, 2000);

    }
}