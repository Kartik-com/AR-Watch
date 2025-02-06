package com.tushar.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    TextView profileTitleUName;
    EditText profileUNameEdit, profileEmailEdit, profilePassEdit, profileMobileNoEdit;
    ImageView profileBackBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        profileBackBtn = findViewById(R.id.profileBackBtn);
        profileBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        profileTitleUName = findViewById(R.id.profileTitleUName);
        profileTitleUName.setText(getIntent().getStringExtra("username"));

        profileUNameEdit = findViewById(R.id.profileUNameEdit);
        profileUNameEdit.setText(getIntent().getStringExtra("username"));

        profileEmailEdit = findViewById(R.id.profileEmailEdit);
        profileEmailEdit.setText(getIntent().getStringExtra("email"));

        profileMobileNoEdit = findViewById(R.id.profileMobileNoEdit);
        profileMobileNoEdit.setText(getIntent().getStringExtra("mobileNo"));

        profilePassEdit = findViewById(R.id.profilePassEdit);
        profilePassEdit.setText(getIntent().getStringExtra("password"));

    }
}