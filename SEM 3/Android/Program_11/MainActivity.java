package com.example.adapter3;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ListView l;
    String[] data = {"Labrador Retriever", "German Shepherd", "Dachshund", "Beagle", "Rottweiler", "Dalmatian"};
    int[] images = {R.drawable.ci1, R.drawable.ci2, R.drawable.ci3, R.drawable.ci4, R.drawable.ci5, R.drawable.ci6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        l = findViewById(R.id.list);
        com.example.adapter3.CustomAdapter adapter = new com.example.adapter3.CustomAdapter(this, data, images);
        l.setAdapter(adapter);
    }
}
