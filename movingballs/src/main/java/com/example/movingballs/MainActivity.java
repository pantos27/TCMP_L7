package com.example.movingballs;

import android.app.Activity;
import android.content.Context;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;

import android.os.Handler;
import android.widget.Toast;


public class MainActivity extends Activity implements View.OnClickListener{

    View blue_ball;
    View red_ball;
    int max_hight;
    int max_width;

    LinearLayout ballView;

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

//                 this is where i should implement the random positioning of the balls
//                blue_ball.setX(180);
//                blue_ball.setY(180);

                ballView.getViewTreeObserver().removeOnGlobalLayoutListener(this);

                new CalculateBallPosition(blue_ball, red_ball, new Handler() {
                    @Override
                    public void handleMessage(Message msg) {
                        Toast.makeText(getApplicationContext(), "hi", Toast.LENGTH_SHORT).show();
                    }
                }, max_width, max_hight).start();
            }
        });



        // This happens before i get the Max width and Max hight

//        new CalculateBallPosition(blue_ball, red_ball, new Handler() {
//            @Override
//            public void handleMessage(Message msg) {
//                Toast.makeText(getApplicationContext(), "hi", Toast.LENGTH_SHORT).show();
//            }
//        }, max_width, max_hight).start();
//
    }


    // implement the speed change of the balls
    @Override
    public void onClick(View v) {



    }
}