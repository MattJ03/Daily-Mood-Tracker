package com.example.dailymoodtracker;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ImageView;
import android.widget.EditText;
import android.widget.Button;

public class TOC extends AppCompatActivity {

    TextView tocText;
    Button tocBtn;
    CheckBox agreeBox;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toc);

        tocText = findViewById(R.id.textViewTOC);
        tocBtn = findViewById(R.id.buttonToc);
        agreeBox = findViewById(R.id.checkBox);

        agreeBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            tocBtn.setEnabled(isChecked);
        });

        tocBtn.setOnClickListener(view -> {
            Intent intent = new Intent(TOC.this, LogIn.class);
            startActivity(intent);
        });
    }
}
