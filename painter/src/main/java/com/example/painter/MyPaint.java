package com.example.painter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by itamar.willenz on 06/02/2016.
 */
public class MyPaint extends View {

    ArrayList<Shape> shapeList;
    private Shape shape;



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



    public ArrayList<Shape> getShapeList() {
        return shapeList;
    }

    public void setShapeList(ArrayList<Shape> shapeList) {
        this.shapeList = shapeList;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }
}
