package com.example.lekcja11zad4;

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

        TextView textView = findViewById(R.id.textview);

        Intent intent = getIntent();

        String name = intent.getStringExtra(MainActivity.EXTRA_NAME);
        int age = intent.getIntExtra(MainActivity.EXTRA_AGE, 0);

        textView.setText("Imię: " + name +", Wiek: " + age);

    }
}