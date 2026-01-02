package com.example.registration;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etEmail, etPassword, etPhone, etLocation;
    CheckBox cbSaveLogin;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        etPhone = findViewById(R.id.et_phone);
        etLocation = findViewById(R.id.et_location);
        cbSaveLogin = findViewById(R.id.cb_save);
        btnRegister = findViewById(R.id.btn_register);

        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        String phone = etPhone.getText().toString().trim();
        String location = etLocation.getText().toString().trim();
        boolean saveLogin = cbSaveLogin.isChecked();

        if (email.isEmpty() || password.isEmpty() || phone.isEmpty() || location.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("email", email);
        intent.putExtra("password", password);
        intent.putExtra("phone", phone);
        intent.putExtra("location", location);
        intent.putExtra("saveLogin", saveLogin);
        startActivity(intent);
    }
}
