package com.example.kostki;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
public class MainActivity extends AppCompatActivity {
    private EditText editTekstLiczbaKostek;
    private Button buttonLosuj, buttonRosnaco, buttonMalejaco;
    private GridLayout gridKostki;
    private TextView textViewWyniki;
    ArrayList<Integer> wyniki = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTekstLiczbaKostek = findViewById(R.id.editTekstLiczbaKostek);
        buttonLosuj = findViewById(R.id.buttonLosuj);
        buttonRosnaco = findViewById(R.id.buttonRosnaco);
        buttonMalejaco = findViewById(R.id.buttonMalejaco);
        gridKostki = findViewById(R.id.gridKostki);
        textViewWyniki = findViewById(R.id.textViewWyniki);
        buttonLosuj.setOnClickListener(v -> {
            String tekst = editTekstLiczbaKostek.getText().toString();

            if (tekst.isEmpty()) {
                Toast.makeText(this, "Podaj liczbę kostek!", Toast.LENGTH_LONG).show();
                return;
            }
            int liczba = Integer.parseInt(tekst);
            if (liczba < 1 || liczba > 100) {
                Toast.makeText(this, "Podaj liczbę od 1 do 100!", Toast.LENGTH_LONG).show();
                return;
            }
            wyniki.clear();
            Random random = new Random();
            for (int i = 0; i < liczba; i++) {
                wyniki.add(random.nextInt(6) + 1);
            }
            wyswietl();
        });
        buttonRosnaco.setOnClickListener(v -> {
            if (wyniki.isEmpty()) {
                Toast.makeText(this, "Najpierw wylosuj kostki!", Toast.LENGTH_LONG).show();
            } else {
                Collections.sort(wyniki);
                wyswietl();
            }
        });
        buttonMalejaco.setOnClickListener(v -> {
            if (wyniki.isEmpty()) {
                Toast.makeText(this, "Najpierw wylosuj kostki!", Toast.LENGTH_LONG).show();
            } else {
                Collections.sort(wyniki, Collections.reverseOrder());
                wyswietl();
            }
        });
    }

    void wyswietl() {
        gridKostki.removeAllViews();
        String tekst = "";

        for (int i = 0; i < wyniki.size(); i++) {
            TextView liczba = new TextView(this);
            liczba.setText(String.valueOf(wyniki.get(i)));
            gridKostki.addView(liczba);
            tekst = tekst + wyniki.get(i);
            if (i < wyniki.size() - 1) {
                tekst += ", ";
            }
        }
        textViewWyniki.setText(tekst);
    }
}
