package com.example.movingballs;

import android.app.Activity;
import android.content.Context;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import android.os.Handler;
import android.widget.Toast;


public class MainActivity extends Activity implements View.OnClickListener {

    View blue_ball;
    View red_ball;
    int max_hight;
    int max_width;

    LinearLayout ballView;

    ImageButton blueUp;
    ImageButton blueDown;
    ImageButton redUp;
    ImageButton redDown;

    CalculateBallPosition ballThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        blue_ball = findViewById(R.id.blue_ball);
        red_ball = findViewById(R.id.red_ball);


        // Here we get the max width and hight of the Linear Layout
        ballView = (LinearLayout) findViewById(R.id.ball_view);

        ballView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {

                max_hight = ballView.getHeight();
                max_width = ballView.getWidth();

                ballView.getViewTreeObserver().removeOnGlobalLayoutListener(this);

                ballThread = new CalculateBallPosition(blue_ball, red_ball, new Handler(), max_width, max_hight);

                ballThread.start();
            }
        });

        blueUp = (ImageButton) findViewById(R.id.blue_up);
        blueDown = (ImageButton) findViewById(R.id.blue_down);
        redUp = (ImageButton) findViewById(R.id.red_up);
        redDown = (ImageButton) findViewById(R.id.red_down);

        blueUp.setOnClickListener(this);
        blueDown.setOnClickListener(this);
        redUp.setOnClickListener(this);
        redDown.setOnClickListener(this);
    }

    // implement the speed change of the balls
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.blue_up: ballThread.setBlueVelocity(2);
                break;

            case R.id.blue_down: ballThread.setBlueVelocity(0.5);
                break;

            case R.id.red_up: ballThread.setRedVelocity(2);
                break;

            case R.id.red_down: ballThread.setRedVelocity(0.5);
                break;
        }
    }
}
