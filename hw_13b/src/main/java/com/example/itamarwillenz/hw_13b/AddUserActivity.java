package com.example.itamarwillenz.hw_13b;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by itamar.willenz on 2/1/16.
 */
public class AddUserActivity extends Activity {

    private EditText firstNameED;
    private EditText lastNameED;
    private EditText mailED;
    private EditText phoneED;
    private EditText userIdED;
    private EditText addressED;
    private EditText passwordED;
    private Button addUserButton;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        firstNameED = (EditText) findViewById(R.id.fName);
        lastNameED = (EditText) findViewById(R.id.lName);
        mailED = (EditText) findViewById(R.id.Mail);
        phoneED = (EditText) findViewById(R.id.Phone);
        userIdED = (EditText) findViewById(R.id.Userid);
        addressED = (EditText) findViewById(R.id.address);
        passwordED = (EditText) findViewById(R.id.password);
        addUserButton = (Button) findViewById(R.id.Add_user_button);

        intent = new Intent(this, UserListActivity.class);

        addUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent.putExtra("New User", addUserToUserList());
                setResult(100, intent);
                finish();

            }
        });

    }

    // Create User from the Users Input
    private User addUserToUserList() {

        User user = new User(mailED.getText().toString(),
                userIdED.getText().toString(),
                addressED.getText().toString(),
                phoneED.getText().toString(),
                firstNameED.getText().toString(),
                lastNameED.getText().toString(),
                passwordED.getText().toString());

        return user;
    }

}
