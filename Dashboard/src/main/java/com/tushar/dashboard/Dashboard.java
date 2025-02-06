package com.tushar.dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.unity3d.player.UnityPlayerActivity;

public class Dashboard extends AppCompatActivity {

    TextView dashboardUname;
    CardView launchUnityActivity, launchShoppingActivity, launchWorkingOnActivity, launchAboutUsActivity, launchSupportCenterActivity, launchTutorialActivity;
    ImageView launchProfileActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        String userNameData = getIntent().getStringExtra("username");
        String emailData = getIntent().getStringExtra("email");
        String mobileNoData = getIntent().getStringExtra("mobileNo");
        String passwordData = getIntent().getStringExtra("pass");

        dashboardUname = findViewById(R.id.dashboardUname);
        dashboardUname.setText(userNameData);

        launchUnityActivity = findViewById(R.id.launchUnityActivity);
        launchUnityActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this, UnityPlayerActivity.class));
            }
        });

        launchShoppingActivity = findViewById(R.id.launchShoppingActivity);
        launchShoppingActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this, ShoppingActivity.class));
            }
        });

        launchWorkingOnActivity = findViewById(R.id.launchWorkingOnActivity);
        launchWorkingOnActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this, WorkingOnActivity.class));
            }
        });

        launchProfileActivity = findViewById(R.id.launchProfileActivity);
        launchProfileActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, ProfileActivity.class);
                intent.putExtra("username", userNameData);
                intent.putExtra("email", emailData);
                intent.putExtra("password", passwordData);
                intent.putExtra("mobileNo", mobileNoData);
                startActivity(intent);
            }
        });

        launchAboutUsActivity = findViewById(R.id.launchAboutUsActivity);
        launchAboutUsActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this, AboutUsActivity.class));
            }
        });

        launchSupportCenterActivity = findViewById(R.id.launchSupportCenterActivity);
        launchSupportCenterActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this, SupportCenterActivity.class));
            }
        });

        launchTutorialActivity = findViewById(R.id.launchTutorialActivity);
        launchTutorialActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this, TutorialActivity.class));
            }
        });
    }
}