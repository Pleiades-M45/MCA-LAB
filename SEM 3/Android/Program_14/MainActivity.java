package com.example.edittext;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements TextWatcher {

    EditText percent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        percent = findViewById(R.id.edit1);

        percent.addTextChangedListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {}

    @Override
    public void afterTextChanged(Editable editable) {
        String s = editable.toString();
        if (!s.isEmpty()) {
            float num = Float.parseFloat(s);
            if (num > 100) {
                percent.setText("100");
                percent.setSelection(percent.getText().length()); // Move cursor to end
            }
        }
    }
}