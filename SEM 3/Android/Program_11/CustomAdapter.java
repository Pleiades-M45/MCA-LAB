package com.example.adapter3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    Context context;
    String[] breedNames;
    int[] breedImages;
    LayoutInflater inflater;

    public CustomAdapter(Context context, String[] breedNames, int[] breedImages) {
        this.context = context;
        this.breedNames = breedNames;
        this.breedImages = breedImages;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return breedNames.length;
    }

    @Override
    public Object getItem(int position) {
        return breedNames[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.single_row, null);
        TextView text = view.findViewById(R.id.text);
        ImageView img = view.findViewById(R.id.img);

        text.setText(breedNames[position]);
        img.setImageResource(breedImages[position]);

        return view;
    }
}
