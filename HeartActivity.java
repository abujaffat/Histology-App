package com.example.histologylogin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HeartActivity extends AppCompatActivity implements View.OnClickListener {

    public CardView aorta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heart);

        aorta = (CardView) findViewById(R.id.aortaCard);
        aorta.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.aortaCard:
                Intent j = new Intent(this,AortaActivity.class);
                startActivity(j);
                break;
        }
    }
}