package com.example.itamarwillenz.moveballs;

import android.view.View;

/**
 * Created by itamar.willenz on 1/19/16.
 */
public class CalacYPosition implements View.OnClickListener {

    int direction;


    @Override
    public void onClick(View v) {

        direction = v.getId();

        if (direction == R.id.yUp) {

            // move up

        }

        else {



        }
        // move down

    }
}
