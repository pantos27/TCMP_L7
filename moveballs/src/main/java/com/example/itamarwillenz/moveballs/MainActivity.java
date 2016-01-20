package com.example.itamarwillenz.moveballs;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    // Find the Views of the UI
    LinearLayout greenLayout;
    Button xUp;
    Button xDown;
    Button yUp;
    Button yDown;

    EditText mEditText;
    Switch mSwitch;
    TextView movingOne;
    TextView movingTwo;

    int direction;
    int moveAmount;
    TextView movingView;
    TextView staticView;

    int maxX;
    int maxY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSwitch = (Switch) findViewById(R.id.mSwitch);
        xUp = (Button) findViewById(R.id.xUp);
        yUp = (Button) findViewById(R.id.yUp);
        xDown = (Button) findViewById(R.id.xDown);
        yDown = (Button) findViewById(R.id.yDown);
        mEditText = (EditText) findViewById(R.id.editText);
        greenLayout = (LinearLayout) findViewById(R.id.green_layout);
        movingOne = (TextView) findViewById(R.id.movingOne);
        movingTwo = (TextView) findViewById(R.id.movingTwo);


        xUp.setOnClickListener(this);
        xDown.setOnClickListener(this);
        yUp.setOnClickListener(this);
        yDown.setOnClickListener(this);

//        Why Form here the maxX doesn't get a value?
//        maxX = greenLayout.getWidth();
//        maxY = greenLayout.getHeight();


    }

    @Override
    public void onClick(View v) {

        // Get the Max width and max hight of the linear Layout
        maxX = greenLayout.getWidth();
        maxY = greenLayout.getHeight();
        float distance;

        // Check if the user entered a number if not send a toast
        try {
            moveAmount = Integer.valueOf(mEditText.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Please Enter a number", Toast.LENGTH_SHORT).show();
        }

        // Set the Moving_view to be the right view acourding to switch
        direction = v.getId();
        movingView = movingTwo;
        staticView = movingOne;

        if (mSwitch.isChecked()) {
            movingView = movingOne;
            staticView = movingTwo;
        }

        //  Perform action according to the button clicked
        switch (direction) {

            case R.id.xUp:

                distance = movingView.getX() + moveAmount;
                if (distance < maxX - movingView.getWidth()) {
                    movingView.setX(distance);
                    v.requestLayout();
                } else {
                    Toast.makeText(this, "Cant move view out of bounds", Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.xDown:

                distance = movingView.getX() - moveAmount;
                if (distance > 0) {
                    movingView.setX(distance);
                    v.requestLayout();
                } else {
                    Toast.makeText(this, "Cant move view out of bounds", Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.yDown:

                distance = movingView.getY() + moveAmount;
                if (distance < maxY - movingView.getHeight()) {
                    movingView.setY(distance);
                    v.requestLayout();
                } else {
                    Toast.makeText(this, "Cant move view out of bounds", Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.yUp:

                distance = movingView.getY() - moveAmount;
                if (distance > 0) {
                    movingView.setY(distance);
                    v.requestLayout();
                } else {
                    Toast.makeText(this, "Cant move view out of bounds", Toast.LENGTH_SHORT).show();
                }

                break;


        }

    }

    void checkViewsOveride (int distance, String xy) {





    }
}
