package com.example.itamarwillenz.hw_8_calaculator;

/**
 * Created by itamar.willenz on 1/15/16.
 */
public class Function {

    private Double mFirstNumber;
    private Double mSeoncdNumber;
    private Double mSum;
    private String mFunction;

    public Function(Double mFirstNumber, Double mSeoncdNumber, String mFunction) {
        this.mSeoncdNumber = mSeoncdNumber;
        this.mFirstNumber = mFirstNumber;
        this.mFunction = mFunction;
    }

    public Double getmFirstNumber() {
        return mFirstNumber;
    }

    public void setmFirstNumber(Double mFirstNumber) {
        this.mFirstNumber = mFirstNumber;
    }

    public Double getmSeoncdNumber() {
        return mSeoncdNumber;
    }

    public void setmSeoncdNumber(Double mSeoncdNumber) {
        this.mSeoncdNumber = mSeoncdNumber;
    }

    public Double getmSum() {
        return mSum;
    }

    public void setmSum(Double mSum) {
        this.mSum = mSum;
    }

    public Double doFunction() {

        switch (mFunction) {

            case "-" : mSum = mFirstNumber - mSeoncdNumber;
                break;

            case "+" : mSum = mFirstNumber + mSeoncdNumber;
                break;

            case "*" : mSum = mFirstNumber * mSeoncdNumber;
                break;

            case "/" : mSum = mFirstNumber / mSeoncdNumber;
                break;

            // Need To implement this methods
            case "NEX" : mSum = mFirstNumber + mSeoncdNumber;
                break;

            case "PRE" : mSum = mFirstNumber + mSeoncdNumber;
                break;

            case "=" : mSum = mFirstNumber + mSeoncdNumber;
                break;

        }

        return mSum;


    }
}
