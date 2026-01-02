package com.example.mark_percentage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText nameInput, mark1Input, mark2Input;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameInput = findViewById(R.id.nameInput);
        mark1Input = findViewById(R.id.mark1Input);
        mark2Input = findViewById(R.id.mark2Input);
        submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.submitButton) {
            String name = nameInput.getText().toString().trim();
            String mark1Str = mark1Input.getText().toString().trim();
            String mark2Str = mark2Input.getText().toString().trim();

            if (name.isEmpty() || mark1Str.isEmpty() || mark2Str.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                int mark1 = Integer.parseInt(mark1Str);
                int mark2 = Integer.parseInt(mark2Str);

                // Launch ResultActivity with data
                Intent intent = new Intent(this, com.example.mark_percentage.ResultActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("mark1", mark1);
                intent.putExtra("mark2", mark2);
                startActivity(intent);

            } catch (NumberFormatException e) {
                Toast.makeText(this, "Please enter valid numbers for marks", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
