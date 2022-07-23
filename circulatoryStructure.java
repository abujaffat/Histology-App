package com.example.histologylogin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class circulatoryStructure extends AppCompatActivity implements View.OnClickListener {

    public CardView heart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circulatory_structure);

        heart = (CardView) findViewById(R.id.heartCard);
        heart.setOnClickListener(this);




    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.heartCard:
                Intent x = new Intent(this,HeartActivity.class);
                startActivity(x);
                break;
        }
    }
}