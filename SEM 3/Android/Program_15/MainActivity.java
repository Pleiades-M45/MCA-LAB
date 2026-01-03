package com.example.buttonclick;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.CompoundButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, 
        TextWatcher, View.OnClickListener {

    EditText percent;
    CheckBox c;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        percent = findViewById(R.id.editf);
        c = findViewById(R.id.cb1);
        b = findViewById(R.id.b1);

        b.setEnabled(false);

        c.setOnCheckedChangeListener(this);
        percent.addTextChangedListener(this);
        b.setOnClickListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (buttonView.getId() == R.id.cb1) {
            b.setEnabled(isChecked);
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {}

    @Override
    public void afterTextChanged(Editable editable) {
        String s = editable.toString();
        if (!s.isEmpty()) {
            try {
                float num = Float.parseFloat(s);
                if (num > 100) {
                    editable.replace(0, editable.length(), "100");
                }
            } catch (NumberFormatException e) {
                // Ignore invalid input
            }
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.b1) {
            // Button click logic here
        }
    }
}