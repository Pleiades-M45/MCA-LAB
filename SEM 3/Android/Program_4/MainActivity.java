package com.example.custom_toast;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText user, pwd;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.user);
        pwd = findViewById(R.id.pass);
        b = findViewById(R.id.login);

        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == b.getId()) {
            if (user.getText().toString().equals("Orca") &&
                pwd.getText().toString().equals("123")) {

                LayoutInflater lin = getLayoutInflater();
                View appear = lin.inflate(R.layout.toast_layout, (ViewGroup) findViewById(R.id.toast_id));  // Syntax: View inflate(int resource, ViewGroup root)

                Toast t1 = Toast.makeText(this, "", Toast.LENGTH_LONG);
                t1.setGravity(Gravity.TOP, 0, 200);
                t1.setView(appear);
                t1.show();
            } else {
                Toast.makeText(this, "Login Failed", Toast.LENGTH_LONG).show();
            }
        }
    }
}
