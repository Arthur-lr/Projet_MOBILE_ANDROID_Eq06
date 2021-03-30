package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.channels.ClosedByInterruptException;

public class MainActivity extends AppCompatActivity {

    private TextView etudiantsView;


    public void remplirTableEleve() {
        DAOEleve eleveBdd = new DAOEleve(this);
        Eleve Eleve1 = new Eleve("NEVEUX", "LANDRY");
        Eleve Eleve2 = new Eleve("ANTOINE", "TIGNARD");

        eleveBdd.open();

        eleveBdd.insererEleve(Eleve1);
        eleveBdd.insererEleve(Eleve2);

        Cursor c = eleveBdd.getData();
        Toast.makeText(getApplicationContext(), "il y a"  + String.valueOf(c.getCount())+ " clients", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etudiantsView = (TextView) findViewById(R.id.textViewNom)



    }
}