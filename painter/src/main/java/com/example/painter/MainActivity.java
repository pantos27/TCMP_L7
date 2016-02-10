package com.example.painter;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity implements Spinner.OnItemSelectedListener {

    Spinner colorSpinner;
    Spinner shapeSpinner;
    Shape shapeToDraw;
    MyPaint mypaintView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colorSpinner = (Spinner) findViewById(R.id.color_spinner);
        shapeSpinner = (Spinner) findViewById(R.id.shape_spinner);

        colorSpinner.setOnItemSelectedListener(this);
        shapeSpinner.setOnItemSelectedListener(this);

        mypaintView = (MyPaint) findViewById(R.id.my_paint1);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        TextView tv = (TextView) view;

        if (parent.getId() == R.id.color_spinner) {
            Log.d("HI", "Color");
            String color = tv.getText().toString();

            switch (color) {
                case "Red":
                    mypaintView.setShapeColor(Color.RED);
                    tv.setTextColor(Color.RED);
                    Log.d("Color Selected", "RED");
                    break;

                case "Blue":
                    mypaintView.setShapeColor(Color.BLUE);
                    tv.setTextColor(Color.BLUE);
                    Log.d("Color Selected", "BLUE");
                    break;

                case "Green":
                    mypaintView.setShapeColor(Color.GREEN);
                    tv.setTextColor(Color.GREEN);
                    Log.d("Color Selected", "green");
                    break;
            }
        } else {
            Log.d("Hi", "Shape");
            String shape = tv.getText().toString();

            switch (shape) {
                case "Oval":
                    mypaintView.setShapeType("Oval");
                    break;

                case "Rectangle":
                    mypaintView.setShapeType("Rectangle");
                    break;

                case "Squer":
                    mypaintView.setShapeType("Squer");
                    break;

                case "Line":
                    mypaintView.setShapeType("Line");
                    break;
            }
        }

    }



    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
