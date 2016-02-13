package com.example.painter;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Parcel;

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

    public static final Creator<Rectangle> CREATOR = new Creator<Rectangle>() {
        @Override
        public Rectangle createFromParcel(Parcel in) {

            Paint paint = new Paint();
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(4);
            paint.setColor(in.readInt());
            return new Rectangle(new Point(in.readFloat(), in.readFloat()), new Point(in.readFloat(), in.readFloat()), paint);
        }

        @Override
        public Rectangle[] newArray(int size) {
            return new Rectangle[size];
        }
    };
}
