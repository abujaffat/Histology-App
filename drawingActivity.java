package com.example.histologylogin;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;


public class drawingActivity extends AppCompatActivity {

    public Bitmap bitmap;


    public Canvas canvas;


    public float floatX1 = -1, floatY1 = -1,
            floatX2 = -1, floatY2 = -1;

    public ImageView imgView;

    public Paint paintBrush = new Paint();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawing);
        ActivityCompat.requestPermissions(this
                , new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE},
                PackageManager.PERMISSION_GRANTED);




    }

    private void drawPaintSketchImage() {

        if (bitmap == null) {
            bitmap = Bitmap.createBitmap(imgView.getWidth(),
                    imgView.getHeight(),
                    Bitmap.Config.ARGB_8888);
            canvas = new Canvas(bitmap);
            paintBrush.setColor(Color.RED);
            paintBrush.setAntiAlias(true);
            paintBrush.setStyle(Paint.Style.STROKE);
            paintBrush.setStrokeWidth(8);
        }
        canvas.drawLine(floatX1,
                floatY1,
                floatX2,
                floatY2,
                paintBrush);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            floatX1 = event.getX();
            floatY1 = event.getY();
        }

        if (event.getAction() == MotionEvent.ACTION_MOVE) {
            floatX2 = event.getX();
            floatY2 = event.getY();
            drawPaintSketchImage();
            floatX1 = event.getX();
            floatY1 = event.getY();
        }
        if (event.getAction() == MotionEvent.ACTION_UP) {
            floatX2 = event.getX();
            floatY2 = event.getY();
            drawPaintSketchImage();
        }
        return super.onTouchEvent(event);


    }

    public static File bitmapToFile(Bitmap bitmap, Context context, String savedName) {
        File fileName = null;
        try {
            fileName = new File(Environment.getExternalStorageDirectory() + File.separator + savedName);
            fileName.createNewFile();
            fileName.getAbsoluteFile();

            ByteArrayOutputStream array = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 0 , array);
            byte[] bmpdata = array.toByteArray();

            FileOutputStream x = new FileOutputStream(fileName);
            x.write(bmpdata);
            x.flush();
            x.close();
            return fileName;
        }
        catch (Exception e){
            e.printStackTrace();
            return fileName;
        }
    }

}