package com.example.itamarwillenz.hw_8_calaculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

    private TextView calcView = null;
    private StringBuilder strBuilder1 = new StringBuilder();
    private Boolean mFirstAction = true;
    private Boolean mCleanText = false;

    private Double mSum = 0D;
    private Double mFirstNumber = 0D;
    private Double mSecondNumber = 0D;

    private String priviousFunctionType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_relative);

        // Text View
        calcView = (TextView) findViewById(R.id.calcTextView);
        showResult();

        // Number Buttons
        findViewById(R.id.button0).setOnClickListener(this);
        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        findViewById(R.id.button5).setOnClickListener(this);
        findViewById(R.id.button6).setOnClickListener(this);
        findViewById(R.id.button7).setOnClickListener(this);
        findViewById(R.id.button8).setOnClickListener(this);
        findViewById(R.id.button9).setOnClickListener(this);
        findViewById(R.id.buttonDot).setOnClickListener(this);

        // Function Buttons
        findViewById(R.id.buttonC).setOnClickListener(this);
        findViewById(R.id.buttonMinus).setOnClickListener(this);
        findViewById(R.id.buttonEquels).setOnClickListener(this);
        findViewById(R.id.buttonPlus).setOnClickListener(this);
        findViewById(R.id.buttonMultipule).setOnClickListener(this);
        findViewById(R.id.buttonSlesh).setOnClickListener(this);
        findViewById(R.id.buttonNex).setOnClickListener(this);
        findViewById(R.id.buttonPRE).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String tag = v.getTag().toString();

        // Number on Click Action
        if (tag.equals("Number")) {
            numberClick(v);
        }

        // Function On click action
        else if (tag.equals("Function")) {

            mCleanText = true;
            String functionType = ((Button) v).getText().toString();

            if (mFirstAction) {
                mSum = Double.valueOf(strBuilder1.toString());
                showResult();
                strBuilder1.setLength(0);
                mFirstAction = false;
                priviousFunctionType = functionType;

            } else {

                if (functionType.equals("C")) {
                    strBuilder1.setLength(0);
                    calcView.setText("0");
                    mFirstNumber = 0D;
                    mSecondNumber = 0D;
                    mSum = 0D;
                    mFirstAction = true;
                } else {

                    mFirstNumber = mSum;
                    mSecondNumber = Double.valueOf(strBuilder1.toString());

                    if (priviousFunctionType.equals("/") && mSecondNumber == 0) {
                        calcView.setText("Math Err");
                    } else {
                        Function function = new Function(mFirstNumber, mSecondNumber, priviousFunctionType);
                        mSum = function.doFunction();
                        showResult();
                        mSecondNumber = 0D;
                        priviousFunctionType = functionType;
                    }
                }
            }
        }
    }

    private void numberClick(View v) {

        if (mCleanText) {
            strBuilder1.setLength(0);
            calcView.setText(strBuilder1.toString());
        }

        strBuilder1.append(((Button) v).getText());
        calcView.setText(strBuilder1.toString());
        mCleanText = false;

    }


    private void showResult() {
        calcView.setText(Double.toString(mSum));
    }
}
