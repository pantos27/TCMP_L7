package com.example.itamarwillenz.hw_13b;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by itamar.willenz on 2/1/16.
 */
public class UserListActivity extends Activity {

    ArrayList<User> userLiset = new ArrayList<User>();
    User[] userArray;
    User userToEdit;
    User editedUser;
    int editedUserIndex = 100;
    ListView listview;
    ArrayAdapter<User> adapter;
    Button addUserButton;

    // From add user Screen
    public static final int RESULT_OK = 100;
    public static final int ADD_USER = 101;

    // From edit user activity
    static final int EDIT_USER = 200;
    static final int USER_DELETED = 201;
    static final int USER_EDITED = 202;
    static final String USER_LIST = "user list";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        listview = (ListView) findViewById(R.id.userList);
        adapter = new ArrayAdapter<User>(this, android.R.layout.simple_list_item_1, userLiset);

        // For the Restore of the list on the screen when the activity is destroid.
        try {
            userArray = (User[]) savedInstanceState.getParcelableArray(USER_LIST);
            if (userArray.length > 0) {
                for (int i = 0; i < userArray.length; i++) {
                    userLiset.add(userArray[i]);
                }
            }

            listview.setAdapter(adapter);
        } catch (Exception e) {

        }
        // restore the User to edit index
        try {
            editedUserIndex = savedInstanceState.getInt("userEditedIndex");
        } catch (Exception e) {

        }

        addUserButton = (Button) findViewById(R.id.from_userList_addUser);
        addUserButton.setOnClickListener(new View.OnClickListener() {

                                             @Override
                                             public void onClick(View v) {
                                                 Intent intent = new Intent(UserListActivity.this, AddUserActivity.class);
                                                 startActivityForResult(intent, ADD_USER);
                                             }
                                         }

        );

        // Set a listner for the list view items - send the user selected to the edit user activity
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(UserListActivity.this, DetailsActivity.class);
                userToEdit = userLiset.get(position);
                // In order to know which user should be replaced from the list of users.
                editedUserIndex = position;
                intent.putExtra("user_to_edit", userToEdit);
                startActivityForResult(intent, EDIT_USER);
            }
        });
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        // The user returned from the Add user Activity
        if (requestCode == ADD_USER) {
            if (resultCode == RESULT_OK) {
                User userToAdd = data.getParcelableExtra("New User");
                userLiset.add(userToAdd);
                Toast.makeText(this, userToAdd.toString() + " Added to List", Toast.LENGTH_SHORT).show();
                listview.setAdapter(adapter);
            }
        }

        // The user returned from the Edit User Activity
        else if (requestCode == EDIT_USER) {
            // The user returned should be deleted
            if (resultCode == USER_EDITED) {
                editedUser = data.getParcelableExtra("EditedUser");
                userLiset.set(editedUserIndex, editedUser);
                Toast.makeText(this, editedUser.toString()+" was edited", Toast.LENGTH_SHORT).show();
            }
            else if (resultCode == USER_DELETED) {
                editedUser = data.getParcelableExtra("EditedUser");
                userLiset.remove(editedUserIndex);
                Toast.makeText(this, editedUser.toString()+" was deleted", Toast.LENGTH_SHORT).show();
                listview.setAdapter(adapter);
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        userArray = convertUserListToArray(userLiset);
        outState.putParcelableArray(USER_LIST, userArray);
        outState.putInt("userEditedIndex", editedUserIndex);
        super.onSaveInstanceState(outState);

    }


    User[] convertUserListToArray(ArrayList<User> userList) {

        int arraySize = userList.size();
        User[] userArray = new User[arraySize];

        for (int i = 0; i < arraySize; i++) {
            userArray[i] = userList.get(i);
        }

        return userArray;
    }
}
