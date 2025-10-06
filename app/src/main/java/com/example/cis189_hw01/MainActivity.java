package com.example.cis189_hw01;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //globals and things
    SeekBar sb_j_red;
    SeekBar sb_j_green;
    SeekBar sb_j_blue;
    TextView tv_j_hex;
    TextView tv_j_red;
    TextView tv_j_green;
    TextView tv_j_blue;
    ListView lv_j_colors;
    Button btn_j_newColor;

    private ArrayList<ColorInfo> listOfColors;

    ColorInfoAdapter clAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //connecting gui and code
        sb_j_red = findViewById(R.id.sb_v_red);
        sb_j_green = findViewById(R.id.sb_v_green);
        sb_j_blue = findViewById(R.id.sb_v_blue);
        tv_j_hex = findViewById(R.id.tv_v_hex);
        tv_j_red = findViewById(R.id.tv_v_red);
        tv_j_green = findViewById(R.id.tv_v_green);
        tv_j_blue = findViewById(R.id.tv_v_blue);
        lv_j_colors = findViewById(R.id.lv_v_colors);
        btn_j_newColor = findViewById(R.id.btn_v_newColor);

        //setting up arraylist of colors
        listOfColors = new ArrayList<ColorInfo>();
        dummyData();
        //showAllColors();
        fillListView();
        seekBarListener();
        listViewClickListener();
        buttonListener();

    }
    // functs and listeners

    public void seekBarListener()
    {
        sb_j_red.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                tv_j_red.setText(Integer.toString(sb_j_red.getProgress()));
                setHex();
                setBackround();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sb_j_green.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                tv_j_green.setText(Integer.toString(sb_j_green.getProgress()));
                setHex();
                setBackround();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sb_j_blue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                tv_j_blue.setText(Integer.toString(sb_j_blue.getProgress()));
                setHex();
                setBackround();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void listViewClickListener()
    {
        lv_j_colors.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                ColorInfo colorInfo = listOfColors.get(position);
                //Log.d("color selected: ", colorInfo.getHex());
                ColorInfo ci = new ColorInfo(colorInfo.getRed(), colorInfo.getGreen(),colorInfo.getBlue());
                setSeekBars(ci.getRed(),ci.getGreen(), ci.getBlue());
                setBackround();



            }
        });
    }

    public void buttonListener()
    {
        btn_j_newColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                listOfColors.add(addNewColor());
                fillListView();
                reset();

            }
        });
    }

    public void setHex()
    {
        int r = sb_j_red.getProgress();
        int g = sb_j_green.getProgress();
        int b = sb_j_blue.getProgress();
        tv_j_hex.setText(String.format("#%02X%02X%02X",r,g,b));
    }

    public void setSeekBars(int r, int g, int b)
    {
        sb_j_red.setProgress(r);
        sb_j_green.setProgress(g);
        sb_j_blue.setProgress(b);
    }

    public void setBackround()
    {
        getWindow().getDecorView().setBackgroundColor(Color.parseColor(tv_j_hex.getText().toString()));
    }

    public void dummyData()
    {
        ColorInfo color = new ColorInfo(15,255,145);
        listOfColors.add(color);
        color = new ColorInfo(152,5,255);
        listOfColors.add(color);
        color = new ColorInfo(0,253,0);
        listOfColors.add(color);
        color = new ColorInfo(255,255,255);
        listOfColors.add(color);
    }

//    public void showAllColors()
//    {
//        for(int i = 0; i < listOfColors.size(); i++)
//        {
//            Log.d("Color Info:", listOfColors.get(i).getHex());
//        }
//    }

    public void fillListView()
    {

        clAdapter = new ColorInfoAdapter(this, listOfColors);
        lv_j_colors.setAdapter(clAdapter);


    }

    public ColorInfo addNewColor()
    {
        ColorInfo c = new ColorInfo(sb_j_red.getProgress(),sb_j_blue.getProgress(),sb_j_green.getProgress());
        return c;

    }

    public void reset()
    {
        sb_j_red.setProgress(0);
        sb_j_blue.setProgress(0);
        sb_j_green.setProgress(0);
    }

}