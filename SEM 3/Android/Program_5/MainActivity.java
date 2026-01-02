package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView display;
    double num1 = 0;
    String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);

        int[] buttonIds = {
                R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3,
                R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7,
                R.id.btn8, R.id.btn9, R.id.btnAdd, R.id.btnSub,
                R.id.btnMul, R.id.btnDiv, R.id.btnEq, R.id.btnC,
                R.id.btnDot
        };

        // Attach this activity as the click listener for all buttons
        for (int id : buttonIds) {
            Button btn = findViewById(id);
            btn.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        // Get the text of the clicked button
        Button btn = (Button) v;
        String input = btn.getText().toString();
        handleClick(input);
    }

    void handleClick(String input) {
        switch (input) {
            case "C":
                display.setText("");
                num1 = 0;
                operator = "";
                break;
            case "+":
            case "-":
            case "*":
            case "/":
                num1 = getDisplayValue();
                operator = input;
                display.setText("");
                break;
            case "=":
                double num2 = getDisplayValue();
                double result = calculate(num1, num2, operator);
                display.setText(String.valueOf(result));
                operator = "";
                break;
            default:
                display.append(input);
        }
    }

    double getDisplayValue() {
        String text = display.getText().toString();
        return text.isEmpty() ? 0 : Double.parseDouble(text);
    }

    double calculate(double a, double b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return b != 0 ? a / b : 0;
            default: return 0;
        }
    }
}
