package com.example.cis189_hw01;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ColorInfoAdapter extends BaseAdapter
{
    Context context;
    ArrayList<ColorInfo> colorList;
    private View view;

    public ColorInfoAdapter(Context c, ArrayList<ColorInfo> cl)
    {
        context = c;
        colorList = cl;

    }


    @Override
    public int getCount()
    {
        return colorList.size();
    }

    @Override
    public Object getItem(int position)
    {
        return colorList.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent)
    {
        if(view == null)
        {
            LayoutInflater mInflator = (LayoutInflater) context.getSystemService(MainActivity.LAYOUT_INFLATER_SERVICE);
            view = mInflator.inflate(R.layout.colorinfo_cell, null);
        }

        //getting gui

        TextView red = view.findViewById(R.id.tv_v_cell_red);
        TextView blue = view.findViewById(R.id.tv_v_cell_blue);
        TextView green = view.findViewById(R.id.tv_v_cell_green);
        TextView hex = view.findViewById(R.id.tv_v_cell_hex);

        //getting and setting info about the current color
        ColorInfo colorInfo = colorList.get(position);

        //setting gui
        red.setText(Integer.toString(colorInfo.getRed()));
        blue.setText(Integer.toString(colorInfo.getBlue()));
        green.setText(Integer.toString(colorInfo.getGreen()));
        hex.setText(colorInfo.getHex());

        view.setBackgroundColor(Color.parseColor(colorList.get(position).getHex()));

        return view;

    }
}
