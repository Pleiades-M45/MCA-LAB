package com.example.adapter2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView l;
    ImageView v;
    String[] img = {"Image 1","Image 2","Image 3","Image 4","Image 5"};
    int image[]={R.drawable.fp1, R.drawable.fp2, R.drawable.fp3, R.drawable.fp4, R.drawable.fp5};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        l = (ListView) findViewById(R.id.list);
        v = (ImageView) findViewById(R.id.iv);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,img);
        l.setAdapter(adapter);
        l.setOnItemClickListener(this);
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
        v.setImageResource(image[i]);
    }
}
