package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView etudiantsView;
    private DatabaseManager databaseManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button boutonRechercher = (Button) findViewById(R.id.Boutonrechercher);
        View.OnClickListener ecouteur1 = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, FicheVisite.class);
                startActivity((intent));
            }
        };

        etudiantsView = (TextView) findViewById(R.id.textView);
        databaseManager = new DatabaseManager( this);

        databaseManager.insertEtudiants("Landry");
        databaseManager.insertEtudiants("Landry");
        databaseManager.insertEtudiants("Landry");
        databaseManager.insertEtudiants("Landry");
        databaseManager.insertEtudiants("Landry");

        databaseManager.close();

        boutonRechercher.setOnClickListener(ecouteur1);
    }
}