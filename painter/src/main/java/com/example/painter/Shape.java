package com.example.painter;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Parcelable;

/**
 * Created by itamar.willenz on 06/02/2016.
 */
public abstract class Shape implements Parcelable {

    Paint paintStyle;
    Point startPoint, endPoint;

    public abstract void draw (Canvas canvas);


}
