package com.example.mark_percentage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {

    TextView resultText;
    Button previousButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultText = findViewById(R.id.resultText);
        previousButton = findViewById(R.id.previousButton);

        // Get data from intent
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        int mark1 = intent.getIntExtra("mark1", 0);
        int mark2 = intent.getIntExtra("mark2", 0);

        int total = mark1 + mark2;
        float percentage = (total / 200.0f) * 100;

        String message = "Welcome " + name + "\nYour percentage is " + percentage + "%";
        resultText.setText(message);

        previousButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.previousButton) {
            finish(); // Go back to MainActivity
        }
    }
}
