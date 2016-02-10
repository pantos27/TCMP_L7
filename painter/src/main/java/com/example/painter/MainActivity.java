package com.example.painter;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity implements Spinner.OnItemSelectedListener, View.OnClickListener {

    Spinner colorSpinner;
    Spinner shapeSpinner;
    MyPaint mypaintView;

    ImageButton deletLast;
    ImageButton deletAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colorSpinner = (Spinner) findViewById(R.id.color_spinner);
        shapeSpinner = (Spinner) findViewById(R.id.shape_spinner);
        deletAll = (ImageButton) findViewById(R.id.deletAll);
        deletLast = (ImageButton) findViewById(R.id.deletLast);

        colorSpinner.setOnItemSelectedListener(this);
        shapeSpinner.setOnItemSelectedListener(this);

        deletAll.setOnClickListener(this);
        deletLast.setOnClickListener(this);

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
            String shape = tv.getText().toString();
            Log.d("Hi", shape);
            switch (shape) {
                case "Oval":
                    mypaintView.setShapeType(shape);
                    break;

                case "Rectangle":
                    mypaintView.setShapeType(shape);
                    break;

                case "Line":
                    mypaintView.setShapeType(shape);
                    break;
            }
        }

    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.deletAll) {

            mypaintView.deleteAllShapes();

        } else {

            mypaintView.deletLastShape();

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    // Implement this method
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }
}
