package com.example.movingballs;

import android.util.Log;
import android.view.View;

import android.os.Handler;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by itamar.willenz on 13/02/2016.
 */


public class CalculateBallPosition extends Thread {

    View blue_ball;
    View red_ball;
    int maxY;
    int maxX;
    Handler handler;

    int directionX_blue_ball = 1;
    int directionY_blue_ball = 1;

    int directionX_red_ball = 1;
    int directionY_red_ball = 1;

    int velocity = 5;

    public CalculateBallPosition(View blue_ball, View red_ball, Handler handler, int maxX, int maxY) {
        this.blue_ball = blue_ball;
        this.red_ball = red_ball;
        this.handler = handler;
        this.maxX = maxX;
        this.maxY = maxY;

        blue_ball_new_x = random.nextInt(maxX - blue_ball.getWidth());
        blue_ball_new_y = random.nextInt(maxY - blue_ball.getWidth());
        red_ball_new_x = random.nextInt(maxX - blue_ball.getWidth());
        red_ball_new_y = random.nextInt(maxY - blue_ball.getWidth());

    }

    @Override
    public void run() {
        moveBalls(blue_ball, red_ball);
    }

    Random random = new Random();

    int blue_ball_new_x;
    int blue_ball_new_y;
    int red_ball_new_x;
    int red_ball_new_y;


    public void moveBalls(View blue_ball, View red_ball) {

        while (true) {

            // blue ball condition
            if (blue_ball_new_x > (maxX - blue_ball.getWidth())
                    || blue_ball_new_x < 0) {
                directionX_blue_ball *= -1;
            }

            if (blue_ball_new_y > (maxY - blue_ball.getHeight())
                    || blue_ball_new_y < 0) {
                directionY_blue_ball *= -1;
            }

            // red ball condition
            if (red_ball_new_x > (maxX - red_ball.getWidth())
                    || red_ball_new_x < 0) {
                directionX_red_ball *= -1;
            }

            if (red_ball_new_y > (maxY - red_ball.getHeight())
                    || red_ball_new_y < 0) {
                directionY_red_ball *= -1;
            }

            // change the cordinations of the balls
            blue_ball_new_x += directionX_blue_ball;
            blue_ball_new_y += directionY_blue_ball;

            red_ball_new_x += directionX_red_ball;
            red_ball_new_y += directionY_red_ball;

            handler.post(setBalls);
            try {
                Thread.sleep(velocity);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    Runnable setBalls = new Runnable() {
        @Override
        public void run() {
            blue_ball.setX(blue_ball_new_x);
            blue_ball.setY(blue_ball_new_y);
            red_ball.setX(red_ball_new_x);
            red_ball.setY(red_ball_new_y);
        }
    };


    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }
}
