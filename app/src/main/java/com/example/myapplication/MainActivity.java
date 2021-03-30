package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView etudiantsView;
    private DatabaseManager databaseManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etudiantsView = (TextView) findViewById(R.id.textView);
        databaseManager = new DatabaseManager( this);

        databaseManager.insertEtudiants("Landry");
        databaseManager.insertEtudiants("Landry");
        databaseManager.insertEtudiants("Landry");
        databaseManager.insertEtudiants("Landry");
        databaseManager.insertEtudiants("Landry");

        databaseManager.close();
    }
}