package com.example.lekcja11zad2.;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.TextView;
public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);

        TextView textView = findViewById(R.id.textView);

        Intent intent = getIntent();

        int a = intent.getIntExtra(MainActivity.EXTRA_NUMBER1, 0);
        int b = intent.getIntExtra(MainActivity.EXTRA_NUMBER2, 0);
        int wynik = a + b;

        textView.setText("Wynik: " + wynik);
    }
}