package com.example.painter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by itamar.willenz on 06/02/2016.
 */
public class MyPaint extends View {

    ArrayList<Shape> shapeList = new ArrayList<Shape>();
    Shape temShape;
    String shapeType;
    int shapeColor;
    Paint painStyle;

    Point startPoint;
    Point endPoint;


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


    public void setShapeList(ArrayList<Shape> shapeList) {
        this.shapeList = shapeList;
    }

    public ArrayList<Shape> getShapeList() {
        return shapeList;
    }

    public String getShapeType() {
        return shapeType;
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

    public Shape getTemShape() {
        return temShape;
    }

    public void setTemShape(Shape temShape) {
        this.temShape = temShape;
    }


    void intiatePaint() {
        painStyle = new Paint();
        painStyle.setColor(shapeColor);
        painStyle.setStyle(Paint.Style.STROKE);
        painStyle.setStrokeWidth(4);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        for (Shape s : shapeList) {
            s.draw(canvas);
        }
        if (temShape != null) {

            temShape.draw(canvas);
            Log.d("Action", "drawing");
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_DOWN) {

            intiatePaint();
            startPoint = new Point();
            startPoint.setX(event.getX());
            startPoint.setY(event.getY());

            endPoint = new Point();
            endPoint.setX(event.getX());
            endPoint.setY(event.getY());

            switch (shapeType) {
                case "Oval":
                    temShape = new Oval(startPoint, endPoint, painStyle);
                    break;

                case "Line":
                    temShape = new Line(startPoint, endPoint, painStyle);
                    break;
//
              case "Rectangle":
                    temShape = new Rectangle(startPoint, endPoint, painStyle);
            }


        }

        if (event.getAction() == MotionEvent.ACTION_MOVE) {

            endPoint.setX(event.getX());
            endPoint.setY(event.getY());

            invalidate();

        }

        if (event.getAction() == MotionEvent.ACTION_UP) {

            // add the shape to the list and restart all the parameters
            shapeList.add(temShape);
            temShape = null;
            startPoint = null;
            endPoint = null;

        }

        return true;
    }


    void deletLastShape () {

        if (shapeList.size() > 0) {
            shapeList.remove(shapeList.size() - 1);
            invalidate();
        } else {
            Log.d("hi", "The List is empty");
        }

    }

    void deleteAllShapes () {

        if (shapeList.size() > 0) {
            shapeList.clear();
            invalidate();
        } else {
            Log.d("hi", "The List is empty");
        }
    }
}

