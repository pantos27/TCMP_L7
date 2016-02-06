package com.example.painter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends Activity {

    Spinner colorSpinner;
    Spinner shapeSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_paint);

        colorSpinner = (Spinner) findViewById(R.id.color_spinner);
    }
}
