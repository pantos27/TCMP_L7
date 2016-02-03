package com.example.itamarwillenz.hw_13;

import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by itamar.willenz on 1/31/16.
 */
public class MailValidator implements TextWatcher {

    private EditText ed;
    private final Pattern mailPattern = Pattern.compile(".([a-z]{2,})$");

    public MailValidator(EditText ed) {
        this.ed = ed;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {


        Matcher mailEnding = mailPattern.matcher(s.toString());

        if (mailEnding.toString().length() > 3) {
            ed.setTextColor(Color.BLUE);
        } else {
            ed.setTextColor(Color.RED);
        }

    }
}
