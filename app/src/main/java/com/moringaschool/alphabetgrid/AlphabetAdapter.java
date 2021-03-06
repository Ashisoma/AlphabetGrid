package com.moringaschool.alphabetgrid;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class AlphabetAdapter extends BaseAdapter {
    private Context mContext;
    private String [] mLetters ;
    private Typeface mTypeface;

    public AlphabetAdapter(Context context, String [] letters, Typeface typeface){
        this.mContext = context;
        this.mLetters = letters;
        this.mTypeface = typeface;
    }

    @Override
    public int getCount() {
        return mLetters.length;
    }

    @Override
    public Object getItem(int position) {
        String letters = mLetters[position];

        return String.format("%s \nServes great: %s", letters);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View gridView;
        if(convertView==null){
            // get the layout form the xml file
            gridView = inflater.inflate(R.layout.alphabet_grid_item, null);
            // pulling views
            TextView letterView = (TextView) gridView.findViewById(R.id.grid_item_letter);
            // setting values into views
            letterView.setText(mLetters[position]); // passing each of hte letters form the array
            letterView.setTypeface(mTypeface);
        }else {
            gridView =(View) convertView;

        }
        return gridView;
    }
}
