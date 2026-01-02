package com.example.adapter1;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView l;
    String[] days = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        l = (ListView) findViewById(R.id.list);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,days);
        l.setAdapter(adapter);
        l.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
        TextView temp = (TextView) view;
        Toast.makeText(this, temp.getText()+" "+i,Toast.LENGTH_LONG).show();
    }
}
