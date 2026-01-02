package com.example.adapterspinner;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner sp;
    ListView lt;
    ImageView img;

    String[] fruits = {"Apple", "Banana", "Orange", "Mango", "Grapes"};
    int[] fruitImg = {R.drawable.apple, R.drawable.banana, R.drawable.orange, R.drawable.mango, R.drawable.grapes};

    String[] vegetables = {"Carrot", "Tomato", "Potato", "Cabbage", "Spinach"};
    int[] vegImg = {R.drawable.carrot, R.drawable.tomato, R.drawable.potato, R.drawable.cabbage, R.drawable.spinach};

    String[] currentItems;
    int[] currentImages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = findViewById(R.id.spCategory);
        lt = findViewById(R.id.listItems);
        img = findViewById(R.id.imgDisplay);

        // Spinner setup
        String[] categories = {"Fruits", "Vegetables"};
        ArrayAdapter<String> spAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, categories);
        spAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(spAdapter);

        sp.setOnItemSelectedListener(this);

        // ListView item click
        lt.setOnItemClickListener((parent, v, position, id) -> {
            if (currentImages != null) {
                img.setImageResource(currentImages[position]);
                Toast.makeText(MainActivity.this,
                        "You selected " + currentItems[position],
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
        String selected = parent.getItemAtPosition(position).toString();

        if (selected.equals("Fruits")) {
            currentItems = fruits;
            currentImages = fruitImg;
        } else {
            currentItems = vegetables;
            currentImages = vegImg;
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, currentItems);   // Syntax: ArrayAdapter<T> adapter = new ArrayAdapter<>(context, resource,T[] objects);
);

        lt.setAdapter(adapter);

        img.setImageDrawable(null); // clear image when category changes
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {}
}
