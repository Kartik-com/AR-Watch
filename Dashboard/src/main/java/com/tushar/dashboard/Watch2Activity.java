package com.tushar.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Watch2Activity extends AppCompatActivity {

    Button buy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch2);

        buy = findViewById(R.id.buyWatch2Btn);
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri=Uri.parse("https://www.amazon.in/Citizen-Analog-Green-Dial-Watch-AT2441-08X/dp/B07VNKCQS7/ref=sr_1_12?crid=QZV1W6HAEBW5&keywords=citizen+watches+for+men&qid=1652148314&sprefix=citizen+watches+for+men%2Caps%2C279&sr=8-12");
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });
    }
}