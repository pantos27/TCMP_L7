package com.example.painter;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by itamar.willenz on 06/02/2016.
 */
public abstract class Shape {

    Paint paint;
    Point startPoint, endPoint;

    public abstract void draw (Canvas canvas);


}
