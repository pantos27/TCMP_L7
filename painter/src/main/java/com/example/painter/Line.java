package com.example.painter;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Parcel;

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

    public static final Creator<Line> CREATOR = new Creator<Line>() {
        @Override
        public Line createFromParcel(Parcel in) {

            Paint paint = new Paint();
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(4);
            paint.setColor(in.readInt());
            return new Line(new Point(in.readFloat(), in.readFloat()), new Point(in.readFloat(), in.readFloat()), paint);
        }

        @Override
        public Line[] newArray(int size) {
            return new Line[size];
        }
    };

}
