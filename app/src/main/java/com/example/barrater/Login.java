package com.example.barrater;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.sql.SQLException;

import control.ConnectionPool;
import persistence.UserFacade;

public class Login extends AppCompatActivity {
    private LinearLayout parametersField;
    ConnectionPool connectionPool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        parametersField = findViewById(R.id.parameters_field);
        String USER = "root";
        String PASSWORD = "123m";
        String URL = "jdbc:mysql://127.0.0.1:3306/bar_rater_test";

        connectionPool = new ConnectionPool(USER,PASSWORD,URL);
    }

    public void showSignup(View v){
        if (parametersField.getVisibility() == View.VISIBLE) {
            parametersField.setVisibility(View.GONE);
        } else {
            parametersField.setVisibility(View.VISIBLE);
        }
    }

    public void signup(View v) throws SQLException {
        EditText usernameText = findViewById(R.id.username_field);
        EditText passwordText = findViewById(R.id.password_field);
        EditText ageText = findViewById(R.id.age_field);

        String username = usernameText.getText().toString();
        String password = passwordText.getText().toString();
        int age = Integer.parseInt(ageText.getText().toString());

        UserFacade.insertUser(connectionPool,age,username,password);
    }
}