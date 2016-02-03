package com.example.itamarwillenz.hw_13b;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by itamar.willenz on 2/2/16.
 */
public class DetailsActivity extends Activity implements View.OnClickListener {

    private EditText fname, lname, mail, phone, userid, address, password;
    Button editUserButton, deleteUserButton;

    static final int USER_TO_EDIT = 200;
    static final int USER_DELETED = 201;
    static final int USER_EDITED = 202;

    Intent data;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);

        fname = (EditText) findViewById(R.id.fName);
        lname = (EditText) findViewById(R.id.lName);
        mail = (EditText) findViewById(R.id.Mail);
        phone = (EditText) findViewById(R.id.Phone);
        userid = (EditText) findViewById(R.id.Userid);
        address = (EditText) findViewById(R.id.address);
        password = (EditText) findViewById(R.id.password);

        editUserButton = (Button) findViewById(R.id.edit_user_button);
        deleteUserButton = (Button) findViewById(R.id.delete_user_button);
        editUserButton.setOnClickListener(this);
        deleteUserButton.setOnClickListener(this);

        data = getIntent();
        user = data.getParcelableExtra("user_to_edit");
        Toast.makeText(this, user.toString(), Toast.LENGTH_SHORT).show();

        populateUI(user);
    }

    private void populateUI(User user) {
        fname.setText(user.getmFirstName());
        lname.setText(user.getmLastName());
        mail.setText(user.getmEmail());
        phone.setText(user.getmPhone());
        userid.setText(user.getmId());
        address.setText(user.getmAddress());
        password.setText("*********");
    }

    void sendUserBack(int responseCode) {
        Intent intent = new Intent(this, UserListActivity.class);
        intent.putExtra("EditedUser", user);
        setResult(responseCode, intent);
        finish();
    }

    @Override
    public void onClick(View v) {

        Button vb = (Button) v;
        // if the edit user button was clicked
        if (vb.getText().toString().equals("EDIT USER")) {
            mail.setEnabled(true);
            phone.setEnabled(true);
            address.setEnabled(true);
            mail.requestFocus();
            editUserButton.setText("DONE");
        }
        else if(vb.getText().toString().equals("DONE")) {
            user.setmEmail(mail.getText().toString());
            user.setmPhone(phone.getText().toString());
            user.setmAddress(address.getText().toString());
            sendUserBack(USER_EDITED);
            }
        // if delet button clicked
        else {
            sendUserBack(USER_DELETED);
        }

    }
}
