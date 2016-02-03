package com.example.itamarwillenz.hw_13;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements TextWatcher {

    private EditText mName;
    private EditText mCompany;
    private EditText mMail;
    private EditText mMailEnding;

    private String mNameString;
    private String mCompanyName;
    private String mMailEndingString;

    private Pattern mailPattern = Pattern.compile(".([a-z]{2,})$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the Views
        mName = (EditText) findViewById(R.id.editText);
        mCompany = (EditText) findViewById(R.id.editText2);
        mMail = (EditText) findViewById(R.id.editText3);
        mMailEnding = (EditText) findViewById(R.id.editText4);

        mName.addTextChangedListener(this);
        mCompany.addTextChangedListener(this);
        mMailEnding.addTextChangedListener(this);

        // send to other TextWatcher
        mMail.addTextChangedListener(new MailValidator(mMail));
    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    // Can't implement the listner to the .com of the mail here, will make an recursive loop option _________ . ___ => itamar@myheritage . com
    @Override
    public void afterTextChanged(Editable s) {

        mNameString = mName.getText().toString();
        mCompanyName = mCompany.getText().toString();

        mMail.setText(mNameString + "@" + mCompanyName);

        if (mNameString.length() > 2 && mCompanyName.length() > 2) {
            mMail.setTextColor(Color.BLACK);
        } else {
            mMail.setTextColor(Color.RED);
        }

    }


    //  Create a validate mail method
    private Boolean validateMail(String mail) {

        String mailEnding = mailPattern.matcher(mail).toString();
        if (mNameString.length() > 2 && mCompanyName.length() > 2 && mailEnding.length() > 2 ) {
            return true;
        }

        return false;
    }
}