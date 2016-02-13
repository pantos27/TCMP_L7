package com.example.movingballs;

import android.util.Log;
import android.view.View;

import android.os.Handler;
import android.widget.Toast;

/**
 * Created by itamar.willenz on 13/02/2016.
 */
public class CalculateBallPosition extends Thread {

    View blue_ball;
    View red_ball;
    int maxY;
    int maxX;
    Handler handler;

    int blue_ball_new_x;
    int blue_ball_new_y;
    int red_ball_new_x;
    int red_ball_new_y;

    public CalculateBallPosition(View blue_ball, View red_ball, Handler handler, int maxX, int maxY) {
        this.blue_ball = blue_ball;
        this.red_ball = red_ball;
        this.handler = handler;
        this.maxX = 100;
        this.maxY = maxY;
    }

    @Override
    public void run() {

        for (int i = 0; i < maxX ; i++) {

            blue_ball_new_x++;
            red_ball_new_x++;

            handler.post(setBalls);



        }
        
    }

    Runnable setBalls = new Runnable() {
        @Override
        public void run() {
            blue_ball.setX(blue_ball_new_x);
            blue_ball.setY(blue_ball_new_y);
            red_ball.setX(red_ball_new_x);
            red_ball.setY(red_ball_new_y);
            red_ball.invalidate();
            blue_ball.invalidate();

            Log.d("Hi", "HI");
        }
    };

    // Todo int maxX, and int maxY are returning 0, need to see why.
}
