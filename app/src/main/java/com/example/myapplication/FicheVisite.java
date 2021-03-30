package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FicheVisite extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiche_visite_eleve);

        Button buttonRetour = (Button) findViewById(R.id.buttonRetour);
        View.OnClickListener ecouteur1 = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(FicheVisite.this, MainActivity.class);
                startActivity((intent));
            }
        };

        buttonRetour.setOnClickListener(ecouteur1);

    }
}
