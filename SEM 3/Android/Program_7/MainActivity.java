package com.example.toggleimages;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView img1, img2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);

        img1.setOnClickListener(this);
        img2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();   // check which view was clicked

        if (id == R.id.img1) {
            img1.setVisibility(View.GONE);
            img2.setVisibility(View.VISIBLE);
        } else if (id == R.id.img2) {
            img2.setVisibility(View.GONE);
            img1.setVisibility(View.VISIBLE);
        }
    }
}
