package com.example.lekcja11zad5;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);

        TextView textView = findViewById(R.id.textview);

        Intent intent = getIntent();

        boolean sprawdz = intent.getBooleanExtra(MainActivity.EXTRA_SPRAWDZ, false);

        if (sprawdz) {
            textView.setText("Ustawienia premium: Włączone");
        } else {
            textView.setText("Ustawienie premium: Wyłączone");
        }

    }
}