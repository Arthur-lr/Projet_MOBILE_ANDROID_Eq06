package com.example.myapplication;

public class Eleve {
    protected String Nom;
    protected String Prenom;

    public Eleve(String nom, String prenom) {
        Nom = nom;
        Prenom = prenom;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }
}
