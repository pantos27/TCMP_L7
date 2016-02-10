package com.example.painter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by itamar.willenz on 06/02/2016.
 */
public class MyPaint extends View {

    ArrayList<Shape> shapeList = new ArrayList<Shape>();
    Shape shape;
    String shapeType;
    int shapeColor;
    Paint painStyle;

    Point startPoint = new Point();
    Point endPoint = new Point();



    public MyPaint(Context context) {
        super(context);

    }

    public MyPaint(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public MyPaint(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    public MyPaint(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

    }

    void intiatePaint (){
        painStyle = new Paint();
        painStyle.setColor(shapeColor);
        painStyle.setStyle(Paint.Style.STROKE);
        painStyle.setStrokeWidth(4);
    }


    public void setShapeType(String shapeType) {
        this.shapeType = shapeType;
    }

    public int getShapeColor() {
        return shapeColor;
    }

    public void setShapeColor(int shapeColor) {
        this.shapeColor = shapeColor;
    }

    public Paint getPainStyle() {
        return painStyle;
    }

    public void setPainStyle(Paint painStyle) {
        this.painStyle = painStyle;
    }


    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        for (Shape s : shapeList) {
            s.draw(canvas);
        }
        Log.d("Action", "drawing");
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

         if(event.getAction() == MotionEvent.ACTION_DOWN) {

             intiatePaint();
             startPoint.setX(event.getX());
             startPoint.setY(event.getY());

             switch (shapeType) {
                 case "Oval" :
                     shape = new Oval
             }


         }

        if(event.getAction() == MotionEvent.ACTION_MOVE) {

            endPoint.setX(event.getX());
            endPoint.setY(event.getY());


        }

        if(event.getAction() == MotionEvent.ACTION_UP) {

            shapeList.add(shape);
            shape = null;
            startPoint = null;
            endPoint = null;

        }

        return true;
    }
}

