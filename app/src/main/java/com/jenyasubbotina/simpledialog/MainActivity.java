package com.jenyasubbotina.simpledialog;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new SimpleDialog.Maker(MainActivity.this)
                .setColorHeader(Color.YELLOW)
                .setColorPositive(Color.RED)
                .setColorNegative(R.color.black)
                .setMessage("Hi, its my lib!")
                .setTextPositive("HI")
                .setTextNegative("BYE")
                .setTitle("MEOW").build();
    }
}