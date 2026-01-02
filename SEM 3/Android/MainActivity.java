package com.example.operations;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.AlertDialog;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText numEt;
    Button btnSubmit;
    String selectedOperation = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numEt = findViewById(R.id.et_num);
        btnSubmit = findViewById(R.id.btn_sub);

        btnSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (selectedOperation.isEmpty()) {
            showDialog("Please select an operation.");
            return;
        }

        String inputStr = numEt.getText().toString();
        if (inputStr.isEmpty()) {
            showDialog("Please enter a number.");
            return;
        }

        int num = Integer.parseInt(inputStr);
        String message = "";

        switch (selectedOperation) {
            case "factorial":
                message = "Factorial of " + num + " is " + factorial(num);
                break;
            case "square":
                message = "Square of " + num + " is " + (num * num);
                break;
            case "cube":
                message = "Cube of " + num + " is " + (num * num * num);
                break;
        }

        showDialog(message);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.measuresample, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.factorial) {
            selectedOperation = "factorial";
            Toast.makeText(this, "Factorial selected", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.square) {
            selectedOperation = "square";
            Toast.makeText(this, "Square selected", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.cube) {
            selectedOperation = "cube";
            Toast.makeText(this, "Cube selected", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    private void showDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Result");
        builder.setMessage(message);
        builder.setPositiveButton("OK", null);
        builder.show();
    }

    private int factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}
