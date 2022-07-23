package com.example.histologylogin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AortaActivity extends AppCompatActivity implements View.OnClickListener {

    public CardView crossCut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aorta);

        crossCut = (CardView) findViewById(R.id.crossCutViewCard);
        crossCut.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.crossCutViewCard:
                Intent z = new Intent(this,drawingActivity.class);
                startActivity(z);
                break;
        }

    }
}