package com.example.chetan.timestables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView timesTablesView;

    public void generateTimesTable(int timesTableNumber){

        ArrayList<String> timesTableContent = new ArrayList<>();

        for(int j = 1; j <= 10; j++){
            timesTableContent.add(Integer.toString(j * timesTableNumber));
        }

        timesTablesView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, timesTableContent));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //-----------------------------------------------------------------------//
        timesTablesView = findViewById(R.id.timesTablesView);
        SeekBar seekBar = findViewById(R.id.seekBar);

        int max = 20;
        int startingPosition = 10;
        seekBar.setMax(max);
        seekBar.setProgress(startingPosition);
        generateTimesTable(startingPosition);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                //minimum number that the table can be set to
                int min = 1;
                int timesTableNumber;
                if(i < min){
                    timesTableNumber = min;
                    seekBar.setProgress(min);
                }else{
                    timesTableNumber = i;
                }
                Log.i("SeekBar value", Integer.toString(timesTableNumber));

                generateTimesTable(timesTableNumber);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}