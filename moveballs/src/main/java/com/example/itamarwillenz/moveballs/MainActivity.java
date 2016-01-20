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

        maxX = greenLayout.getWidth();
        maxY = greenLayout.getHeight();


    }

    @Override
    public void onClick(View v) {

        try {
            moveAmount = Integer.valueOf(mEditText.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Please Enter a number", Toast.LENGTH_SHORT).show();
        }

        direction = v.getId();
        movingView = movingTwo;
        float distance;

        if (mSwitch.isChecked()) {
            movingView = movingOne;
        }

        switch (direction) {

            case R.id.xUp :
                // doesn't work the aout od bound thing... lalal
                distance = movingView.getX() + moveAmount;
                if (distance < maxX - movingView.getWidth()) {
                    movingView.setX(distance); v.requestLayout();
                    break;
                }

                else {
                    Toast.makeText(this, "Cant move view out of bounds", Toast.LENGTH_SHORT).show();
                    break;
                }

            case R.id.xDown : movingView.setX(movingView.getX() - moveAmount); v.requestLayout();
                break;

            case R.id.yDown : movingView.setY(movingView.getY() + moveAmount); v.requestLayout();
                break;

            case R.id.yUp : movingView.setY(movingView.getY() - moveAmount); v.requestLayout();
                break;



        }

    }
}
