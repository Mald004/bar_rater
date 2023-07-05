package com.example.barrater;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.sql.SQLException;
import java.util.ArrayList;


import control.LoginConfirmation;
import control.SQLiteDB;
import entities.User;


public class Login extends AppCompatActivity {
    private LinearLayout parametersFieldOpret;
    private LinearLayout parametersFieldLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        parametersFieldOpret = findViewById(R.id.parameters_field);
        parametersFieldLogin = findViewById(R.id.login_field);
    }


    public void showSignup(View v){
        if (parametersFieldOpret.getVisibility() == View.VISIBLE) {
            parametersFieldOpret.setVisibility(View.GONE);
        } else {
            parametersFieldOpret.setVisibility(View.VISIBLE);
        }
    }

    public void showLogin(View v){
        if (parametersFieldLogin.getVisibility() == View.VISIBLE) {
            parametersFieldLogin.setVisibility(View.GONE);
        } else {
            parametersFieldLogin.setVisibility(View.VISIBLE);
        }
    }

    public void signup(View v) throws SQLException {
        EditText usernameText = findViewById(R.id.username_field);
        EditText passwordText = findViewById(R.id.password_field);
        EditText ageText = findViewById(R.id.age_field);

        String username = usernameText.getText().toString();
        String password = passwordText.getText().toString();
        int age = Integer.parseInt(ageText.getText().toString());

    }

    public void login(View v){
        EditText usernameText = findViewById(R.id.usernameL_field);
        EditText passwordText = findViewById(R.id.passwordL_field);

        String username = usernameText.getText().toString();
        String password = passwordText.getText().toString();


        ArrayList<User> users = new ArrayList<>();

        boolean loggedIn = LoginConfirmation.login(users,username,password);

        if(loggedIn == true){
            Intent intent = new Intent(this,MainActivity.class);

            startActivity(intent);
        }else{
            System.out.println("Wrong username or password");
        }

    }
}