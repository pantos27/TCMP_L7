package com.example.painter;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by itamar.willenz on 06/02/2016.
 */
public class Rectangle extends Shape {

    float top;
    float bottom;
    float left;
    float right;

    public Rectangle(Point start, Point end, Paint paintStyle) {

        startPoint = start;
        endPoint = end;
        this.paintStyle = paintStyle;

    }

    @Override
    public void draw(Canvas canvas) {

        if (startPoint.getY() > endPoint.getY()) {
            bottom = startPoint.getY();
            top = endPoint.getY();
        } else {
            bottom = endPoint.getY();
            top = startPoint.getY();
        }

        if (startPoint.getX() < endPoint.getX()) {
            left = startPoint.getX();
            right = endPoint.getX();
        }

        else {
            left = endPoint.getX();
            right = startPoint.getX();
        }



        canvas.drawRect(left, top, right, bottom, paintStyle );

    }
}
