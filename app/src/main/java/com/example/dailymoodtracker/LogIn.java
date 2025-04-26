package com.example.dailymoodtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.Manifest;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;


public class LogIn  extends AppCompatActivity {

    EditText username;
    EditText password;
    Button logInBtn, tocBtn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        username = findViewById(R.id.editTextUsername);
        password = findViewById(R.id.editTextTextPassword);
        logInBtn = findViewById(R.id.buttonLogIn);
        tocBtn = findViewById(R.id.buttonTOC);

        logInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username.getText().toString().isEmpty() && !password.getText().toString().isEmpty()) {
                    Toast.makeText(LogIn.this, "Username is empty", Toast.LENGTH_LONG).show();
                } else if(!username.getText().toString().isEmpty() && password.getText().toString().isEmpty()) {
                    Toast.makeText(LogIn.this, "Password is empty", Toast.LENGTH_LONG).show();
                } else if(username.getText().toString().isEmpty() && password.getText().toString().isEmpty()) {
                    Toast.makeText(LogIn.this, "Enter log in details", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(LogIn.this, Welcome.class);
                    intent.putExtra("email", username.getText().toString());
                    intent.putExtra("username", username.getText().toString());
                    startActivity(intent);
                }
            }
        });
        tocBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LogIn.this, TOC.class);

                startActivity(intent);
            }
        });
    }
}
