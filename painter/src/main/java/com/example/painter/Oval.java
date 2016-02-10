package com.example.painter;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by itamar.willenz on 06/02/2016.
 */
public class Oval extends Shape {

    float radios;

    public Oval(Point start, Point end, Paint paint) {

        startPoint = start;
        endPoint = end;
        paintStyle = paint;

    }

    @Override
    public void draw(Canvas canvas) {

        float xRadios = Math.abs(endPoint.getX() - startPoint.getX());
        float yRadios = Math.abs(endPoint.getY() - startPoint.getY());

        if (xRadios > yRadios) {
            radios = xRadios;

        } else {
            radios = yRadios;
        }

        canvas.drawCircle(startPoint.getX(), startPoint.getY(), radios, paintStyle);

    }
}
