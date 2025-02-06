package com.tushar.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Watch3Activity extends AppCompatActivity {

    Button buy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch3);

        buy = findViewById(R.id.buyWatch3Btn);
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri=Uri.parse("https://www.amazon.in/Emporio-Armani-Analog-Blue-Watch-AR11362/dp/B09BBLT21C/ref=sr_1_12?crid=I1TKQLFE6P6R&keywords=armani+watches+for+men&qid=1652148405&sprefix=armani+watches+for+men%2Caps%2C229&sr=8-12");
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });
    }
}