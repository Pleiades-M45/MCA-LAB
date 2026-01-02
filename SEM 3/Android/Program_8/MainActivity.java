package com.example.happyface;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText et1, et2, et3;
    Button btn;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);
        btn = findViewById(R.id.btn);
        img = findViewById(R.id.img);

        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int m1 = Integer.parseInt(et1.getText().toString());
        int m2 = Integer.parseInt(et2.getText().toString());
        int m3 = Integer.parseInt(et3.getText().toString());

        int total = m1 + m2 + m3;
        double percentage = (total / 300.0) * 100;

        if (percentage >= 50) {
            img.setImageResource(R.drawable.happy);
        } else {
            img.setImageResource(R.drawable.sad);
        }
    }
}
