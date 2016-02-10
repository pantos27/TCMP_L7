package com.example.painter;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by itamar.willenz on 06/02/2016.
 */
public class Line extends Shape {

    Point start;
    Point end;
    Paint paintStyle;

    public Line() {
    }

    public Line(Point start, Point end, Paint paintStyle) {
        this.start = start;
        this.end = end;
        this.paintStyle = paintStyle;
    }

    @Override
    public void draw(Canvas canvas) {

        canvas.drawLine(start.getX(), start.getY(), end.getX(), end.getY(), paintStyle);

    }
}
