package com.example.movingballs;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;

import android.os.Handler;
import android.widget.Toast;

import java.util.Random;


/**
 * Created by itamar.willenz on 13/02/2016.
 */


public class CalculateBallPosition extends Thread {

    private static final String TAG = "moving balls";
    View blue_ball;
    View red_ball;
    int maxY;
    int maxX;
    Handler handler;

    double directionX_blue_ball = 1;
    double directionY_blue_ball = 1;

    double directionX_red_ball = 1;
    double directionY_red_ball = 1;

    Rect rectBlue=new Rect();
    Rect rectRed=new Rect();


    public CalculateBallPosition(View blue_ball, View red_ball, Handler handler, int maxX, int maxY) {
        this.blue_ball = blue_ball;
        this.red_ball = red_ball;
        this.handler = handler;
        this.maxX = maxX;
        this.maxY = maxY;
        //should create this object here so it would clear it from memory after ctor is finished
        Random random = new Random();

        blue_ball_new_x = random.nextInt(maxX - blue_ball.getWidth());
        blue_ball_new_y = random.nextInt(maxY - blue_ball.getWidth());
        red_ball_new_x = random.nextInt(maxX - blue_ball.getWidth());
        red_ball_new_y = random.nextInt(maxY - blue_ball.getWidth());
        //get dimentions of ball objects
        blue_ball.getDrawingRect(rectBlue);
        red_ball.getDrawingRect(rectRed);
    }

    @Override
    public void run() {
        moveBalls(blue_ball, red_ball);
    }

    double blue_ball_new_x;
    double blue_ball_new_y;
    double red_ball_new_x;
    double red_ball_new_y;


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

            checkCollision();

            // change the cordinations of the balls
            blue_ball_new_x += directionX_blue_ball;
            blue_ball_new_y += directionY_blue_ball;

            red_ball_new_x += directionX_red_ball;
            red_ball_new_y += directionY_red_ball;

            handler.post(setBalls);
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void checkCollision() {
        //update rect object to new location
        rectBlue.offsetTo((int) blue_ball_new_x,(int) blue_ball_new_y);
        rectRed.offsetTo((int)red_ball_new_x,(int)red_ball_new_y);
        //if intersect, change direction
        if (Rect.intersects(rectRed,rectBlue)){
            directionY_red_ball *= -1;
            directionX_red_ball *= -1;
            directionX_blue_ball *= -1;
            directionY_blue_ball *= -1;
        }
    }


    Runnable setBalls = new Runnable() {
        @Override
        public void run() {
            blue_ball.setX((float) blue_ball_new_x);
            blue_ball.setY((float) blue_ball_new_y);
            red_ball.setX((float) red_ball_new_x);
            red_ball.setY((float) red_ball_new_y);
        }
    };


    public void setRedVelocity(double velocity) {
        directionY_red_ball *= velocity;
        directionX_red_ball *= velocity;
    }

    public void setBlueVelocity(double velocity) {
        directionY_blue_ball *= velocity;
        directionX_blue_ball *= velocity;
    }

}


