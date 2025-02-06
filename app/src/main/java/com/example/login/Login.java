package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.tushar.dashboard.Dashboard;  // Importing Dashboard class

public class Login extends AppCompatActivity {

    EditText userNameData, passwordData;
    Button loginBtn;
    TextView signUpBtn;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dbHelper = new DatabaseHelper(this);
        userNameData = findViewById(R.id.etUsernameLogin);
        passwordData = findViewById(R.id.etPassLogin);
        signUpBtn = findViewById(R.id.signUpBtn);
        loginBtn = findViewById(R.id.btn_login);

        signUpBtn.setOnClickListener(view -> startActivity(new Intent(Login.this, SignActivity.class)));
        loginBtn.setOnClickListener(view -> loginUser()); // Calling the loginUser method
    }

    public void loginUser() {
        String username = userNameData.getText().toString().trim();
        String password = passwordData.getText().toString().trim();

        if (dbHelper.checkUser(username, password)) {
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();

            // Retrieve user data from the database
            String email = dbHelper.getUserEmail(username);
            String mobileNo = dbHelper.getUserMobile(username);

            // Pass user data to Dashboard activity
            Intent intent = new Intent(Login.this, Dashboard.class);
            intent.putExtra("username", username);
            intent.putExtra("email", email);
            intent.putExtra("mobileNo", mobileNo);
            intent.putExtra("pass", password); // or use a different method to retrieve the password
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
        }
    }
}
