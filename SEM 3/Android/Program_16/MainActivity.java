package com.example.togglebutton;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    LinearLayout ll1;
    ToggleButton t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ll1 = findViewById(R.id.ll1);
        t1 = findViewById(R.id.tb);
        t1.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if (b) { // 'b' is true if the button is ON
            ll1.setBackgroundResource(R.drawable.star);
        } else { // 'b' is false if the button is OFF
            ll1.setBackgroundResource(R.drawable.pikachu);
        }
    }
}
