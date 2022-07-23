package com.example.histologylogin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {

    public CardView circulatoryCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        circulatoryCard = (CardView) findViewById(R.id.circulatorySystemCard);

        circulatoryCard.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {


        switch (view.getId()) {
            case R.id.circulatorySystemCard:
                Intent intent = new Intent(this,circulatoryStructure.class);
                startActivity(intent);
                break;
        }

    }
}