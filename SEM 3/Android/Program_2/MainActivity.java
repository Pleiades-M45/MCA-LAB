package com.example.factorial;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText inputNumber;
    Button calculateButton;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputNumber = findViewById(R.id.inputNumber);
        calculateButton = findViewById(R.id.calculateButton);
        resultText = findViewById(R.id.resultText);

        calculateButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.calculateButton) {
            String input = inputNumber.getText().toString();
            if (!input.isEmpty()) {
                int number = Integer.parseInt(input);
                long factorial = calculateFactorial(number);
                resultText.setText("Factorial of " + number + " is: " + factorial);
            } else {
                resultText.setText("Please enter a number.");
            }
        }
    }

    private long calculateFactorial(int n) {
        if (n < 0) return -1;
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
