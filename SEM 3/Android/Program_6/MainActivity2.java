package com.example.registration;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    TextView tvWelcome, tvEmail, tvPassword, tvPhone, tvLocation, tvSaveLogin;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvWelcome = findViewById(R.id.tv_welcome);
        tvEmail = findViewById(R.id.tv_email);
        tvPassword = findViewById(R.id.tv_password);
        tvPhone = findViewById(R.id.tv_phone);
        tvLocation = findViewById(R.id.tv_location);
        tvSaveLogin = findViewById(R.id.tv_savelogin);
        imageView = findViewById(R.id.imageView);

        String email = getIntent().getStringExtra("email");
        String password = getIntent().getStringExtra("password");
        String phone = getIntent().getStringExtra("phone");
        String location = getIntent().getStringExtra("location");
        boolean saveLogin = getIntent().getBooleanExtra("saveLogin", false);

        tvWelcome.setText("Welcome " + email + "!");
        tvEmail.setText("Email: " + email);
        tvPassword.setText("Password: " + password);
        tvPhone.setText("Phone: " + phone);
        tvLocation.setText("Location: " + location);
        tvSaveLogin.setText("Save Login: " + (saveLogin ? "Yes" : "No"));
    }
}
