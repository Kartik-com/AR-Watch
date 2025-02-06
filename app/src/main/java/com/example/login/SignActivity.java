package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignActivity extends AppCompatActivity {
    EditText etEmailSignUp, etUsernameSignUp, etPassSignUp, etPassConfirmSignUp, etMobileNumber;
    Button signUp;
    TextView btnGoToLogin;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        dbHelper = new DatabaseHelper(this);
        etEmailSignUp = findViewById(R.id.etEmailSignUp);
        etPassSignUp = findViewById(R.id.etPassSignUp);
        etUsernameSignUp = findViewById(R.id.etUsernameSignUp);
        etPassConfirmSignUp = findViewById(R.id.etPassSignUpConfirm);
        etMobileNumber = findViewById(R.id.etMobileNumber);
        signUp = findViewById(R.id.signup);

        btnGoToLogin = findViewById(R.id.btn_GoToLogin);
        btnGoToLogin.setOnClickListener(view -> startActivity(new Intent(SignActivity.this, Login.class)));

        signUp.setOnClickListener(view -> {
            String email = etEmailSignUp.getText().toString().trim();
            String username = etUsernameSignUp.getText().toString().trim();
            String mobile = etMobileNumber.getText().toString().trim();
            String pass = etPassSignUp.getText().toString().trim();
            String confirmPass = etPassConfirmSignUp.getText().toString().trim();

            if (pass.equals(confirmPass)) {
                if (dbHelper.addUser(username, email, pass, mobile)) {
                    Toast.makeText(SignActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SignActivity.this, Login.class));
                    finish();
                } else {
                    Toast.makeText(SignActivity.this, "User Already Exists", Toast.LENGTH_SHORT).show();
                }
            } else {
                etPassConfirmSignUp.setError("Passwords do not match");
            }
        });
    }
}
