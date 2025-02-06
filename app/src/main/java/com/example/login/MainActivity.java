package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button login, signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.btn_login);
        signUp = findViewById(R.id.Sign_up);

        login.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, Login.class)));
        signUp.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, SignActivity.class)));
    }
}
