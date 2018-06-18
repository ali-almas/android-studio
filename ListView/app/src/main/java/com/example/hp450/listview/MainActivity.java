package com.example.hp450.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

        ListView timeTableListView;

    public void generateTimeTable(int timesTable)
    {
        ArrayList<String> timeTableContent = new ArrayList<>();

        for(int j = 1; j <= 10; j++)
        {
            timeTableContent.add(Integer.toString(j * timesTable));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,timeTableContent);

        timeTableListView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar timeTableSeekBar = findViewById(R.id.timeTableSeekBar);
        timeTableListView = findViewById(R.id.timeTableListView);

        timeTableSeekBar.setMax(20);
        timeTableSeekBar.setProgress(10);

        timeTableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                 int min = 1;
                 int timeTable;

                 if(i < min)
                 {
                     timeTable = min;
                     timeTableSeekBar.setProgress(min);
                 }
                 else
                 {
                     timeTable = i;
                 }
                generateTimeTable(timeTable);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        generateTimeTable(10);
    }
}
