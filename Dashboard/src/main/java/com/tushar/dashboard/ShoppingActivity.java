package com.tushar.dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ShoppingActivity extends AppCompatActivity {

    CardView w1, w2, w3, w4, w5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoping);

        w1 = findViewById(R.id.watch1);
        w2 = findViewById(R.id.watch2);
        w3 = findViewById(R.id.watch3);
        w4 = findViewById(R.id.watch4);
        w5 = findViewById(R.id.watch5);

        w1.setOnClickListener(v -> startActivity(new Intent(ShoppingActivity.this, Watch1Activity.class)));

        w2.setOnClickListener(v -> startActivity(new Intent(ShoppingActivity.this, Watch2Activity.class)));

        w3.setOnClickListener(v -> startActivity(new Intent(ShoppingActivity.this, Watch3Activity.class)));

        w4.setOnClickListener(v -> startActivity(new Intent(ShoppingActivity.this, Watch4Activity.class)));

        w5.setOnClickListener(v -> startActivity(new Intent(ShoppingActivity.this, Watch5Activity.class)));


    }
}