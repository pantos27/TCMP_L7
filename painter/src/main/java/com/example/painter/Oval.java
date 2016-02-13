package com.example.painter;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Parcel;

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

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeFloat(startPoint.getX());
        dest.writeFloat(startPoint.getY());
        dest.writeFloat(endPoint.getX());
        dest.writeFloat(endPoint.getY());
        dest.writeInt(paintStyle.getColor());

    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Oval> CREATOR = new Creator<Oval>() {
        @Override
        public Oval createFromParcel(Parcel in) {

            Paint paint = new Paint();
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(4);
            paint.setColor(in.readInt());
            return new Oval(new Point(in.readFloat(), in.readFloat()), new Point(in.readFloat(), in.readFloat()), paint);
        }

        @Override
        public Oval[] newArray(int size) {
            return new Oval[size];
        }
    };
}
