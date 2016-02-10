package com.example.painter;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by itamar.willenz on 06/02/2016.
 */
public class Line extends Shape {




    public Line(Point start, Point end, Paint paintStyle) {
        startPoint = start;
        endPoint = end;
        this.paintStyle = paintStyle;
    }

    @Override
    public void draw(Canvas canvas) {

        canvas.drawLine(startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY(), paintStyle);

    }
}
