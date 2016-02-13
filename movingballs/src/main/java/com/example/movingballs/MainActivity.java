package com.example.movingballs;

import android.app.Activity;
import android.content.Context;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import android.os.Handler;
import android.widget.Toast;


public class MainActivity extends Activity {

    View blue_ball;
    View red_ball;
    int max_hight;
    int max_width;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        blue_ball = findViewById(R.id.blue_ball);
        red_ball = findViewById(R.id.red_ball);

        max_hight = ((LinearLayout) blue_ball.getParent()).getHeight();
        max_width = ((LinearLayout) blue_ball.getParent()).getWidth();

        new CalculateBallPosition(blue_ball, red_ball, new Handler() {
            @Override
            public void handleMessage(Message msg) {
                Toast.makeText(getApplicationContext(), "hi", Toast.LENGTH_SHORT).show();
            }
        }, max_width, max_hight).start();

    }

}