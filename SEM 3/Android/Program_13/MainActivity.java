package com.example.bmicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    Spinner spinnerWeightUnit, spinnerHeightUnit;
    EditText editWeight, editFeet, editInch, editCm;
    TextView textWeightUnit, textResult;
    LinearLayout layoutFtIn;
    Button buttonCalculate;

    String[] weightUnits = {"kg", "pound"};
    String[] heightUnits = {"ft/in", "cm"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerWeightUnit = findViewById(R.id.spinnerWeightUnit);
        spinnerHeightUnit = findViewById(R.id.spinnerHeightUnit);
        editWeight = findViewById(R.id.editWeight);
        textWeightUnit = findViewById(R.id.textWeightUnit);
        editFeet = findViewById(R.id.editFeet);
        editInch = findViewById(R.id.editInch);
        editCm = findViewById(R.id.editCm);
        layoutFtIn = findViewById(R.id.layoutFtIn);
        buttonCalculate = findViewById(R.id.buttonCalculate);
        textResult = findViewById(R.id.textResult);

        ArrayAdapter<String> weightAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, weightUnits);
        spinnerWeightUnit.setAdapter(weightAdapter);

        ArrayAdapter<String> heightAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, heightUnits);
        spinnerHeightUnit.setAdapter(heightAdapter);

        // Set listeners
        spinnerWeightUnit.setOnItemSelectedListener(this);
        spinnerHeightUnit.setOnItemSelectedListener(this);
        buttonCalculate.setOnClickListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getId() == R.id.spinnerWeightUnit) {
            textWeightUnit.setText(weightUnits[position]);
        } else if (parent.getId() == R.id.spinnerHeightUnit) {
            if (heightUnits[position].equals("ft/in")) {
                layoutFtIn.setVisibility(View.VISIBLE);
                editCm.setVisibility(View.GONE);
            } else {
                layoutFtIn.setVisibility(View.GONE);
                editCm.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {}

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonCalculate) {
            String weightStr = editWeight.getText().toString();
            if (weightStr.isEmpty()) return;

            double weight = Double.parseDouble(weightStr);
            String weightUnit = spinnerWeightUnit.getSelectedItem().toString();
            String heightUnit = spinnerHeightUnit.getSelectedItem().toString();

            double weightKg = weightUnit.equals("pound") ? weight * 0.453592 : weight;
            double heightM;

            if (heightUnit.equals("cm")) {
                String cmStr = editCm.getText().toString();
                if (cmStr.isEmpty()) return;
                heightM = Double.parseDouble(cmStr) / 100;
            } else {
                String ftStr = editFeet.getText().toString();
                String inStr = editInch.getText().toString();
                double ft = ftStr.isEmpty() ? 0 : Double.parseDouble(ftStr);
                double in = inStr.isEmpty() ? 0 : Double.parseDouble(inStr);
                heightM = ((ft * 12) + in) * 0.0254;
            }

            double bmi = weightKg / (heightM * heightM);
            textResult.setText("Your BMI: " + String.format("%.2f", bmi));
        }
    }
}