package com.tushar.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Watch1Activity extends AppCompatActivity {

    Button buy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch1);

        buy = findViewById(R.id.buyWatch1Btn);
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri=Uri.parse("https://www.amazon.in/Fastrack-Sunburn-Analog-Multicolor-Watch-3233SL02/dp/B082WL4F5S/ref=sr_1_3_sspa?keywords=fastrack+watches+for+men&qid=1652147927&sprefix=Fastrack+,aps,221&sr=8-3-spons&psc=1");
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });
    }
}