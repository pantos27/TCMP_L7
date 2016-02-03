package com.example.itamarwillenz.hw_13b;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by itamar.willenz on 2/1/16.
 */
public class User implements Parcelable {

    private String mEmail;
    private String mId;
    private String mAddress;
    private String mPhone;
    private String mFirstName;
    private String mLastName;
    private String mPass;

    public User(String mEmail, String mId, String mAddress, String mPhone, String mFirstName, String mLastName, String mPass) {
        this.mEmail = mEmail;
        this.mId = mId;
        this.mAddress = mAddress;
        this.mPhone = mPhone;
        this.mFirstName = mFirstName;
        this.mLastName = mLastName;
        this.mPass = mPass;
    }

    public String getmEmail() {
        return mEmail;
    }

    public String getmId() {
        return mId;
    }

    public String getmAddress() {
        return mAddress;
    }

    public String getmPhone() {
        return mPhone;
    }

    public String getmFirstName() {
        return mFirstName;
    }

    public String getmLastName() {
        return mLastName;
    }

    public String getmPass() {
        return mPass;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public void setmAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    public void setmFirstName(String mFirstName) {
        this.mFirstName = mFirstName;
    }

    public void setmLastName(String mLastName) {
        this.mLastName = mLastName;
    }

    public void setmPass(String mPass) {
        this.mPass = mPass;
    }

    // overide the equel function

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    // Parcelable functions

    protected User(Parcel in) {
        mEmail = in.readString();
        mId = in.readString();
        mAddress = in.readString();
        mPhone = in.readString();
        mFirstName = in.readString();
        mLastName = in.readString();
        mPass = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mEmail);
        dest.writeString(mId);
        dest.writeString(mAddress);
        dest.writeString(mPhone);
        dest.writeString(mFirstName);
        dest.writeString(mLastName);
        dest.writeString(mPass);
    }

    @Override
    public String toString() {
        return mFirstName + "  " + mLastName;
    }
}
