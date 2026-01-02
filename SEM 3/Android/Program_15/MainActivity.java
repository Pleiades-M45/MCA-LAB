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

public class MainActivity extends AppCompatActivity {

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

        b.setEnabled(false); // Disable button initially

        c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                b.setEnabled(isChecked); // Enable button only if checkbox is checked
            }
        });

        percent.addTextChangedListener(new TextWatcher() {
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
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Button click logic here
            }
        });
    }
}
