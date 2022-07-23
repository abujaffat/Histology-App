package com.example.histologylogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;


public class MainActivity extends AppCompatActivity {

    EditText usernameTxt, passwordTxt;
    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameTxt = findViewById(R.id.username);
        passwordTxt = findViewById(R.id.password);
        loginBtn = findViewById(R.id.loginbtn);

        String correct_username = "admin";
        String correct_password = "admin";

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(usernameTxt.getText().toString()) || TextUtils.isEmpty(passwordTxt.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Invalid credentials", Toast.LENGTH_LONG).show();
                } else if(usernameTxt.getText().toString().equals(correct_username)) {
                    if(passwordTxt.getText().toString().equals(correct_password)) {
                        Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_LONG).show();
                        changeActivity();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Incorrect credentials", Toast.LENGTH_LONG).show();
                }
            }
        });


    }

    private void changeActivity() {
        Intent intent = new Intent(this,WelcomeActivity.class);
        startActivity(intent);
    }


}