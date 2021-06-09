package com.example.myapplication;

public class Eleve {


    protected String Nom;
    protected String Prenom;
    protected String Classe;
    protected String Specialite;
    protected String professeur;
    protected String tuteur;

    public Eleve(String Nom, String Prenom, String Classe, String Specialite, String professeur, String tuteur){
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Classe = Classe;
        this.Specialite = Specialite;
        this.professeur = professeur;
        this.tuteur = tuteur;
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

    public String getClasse() {
        return Classe;
    }

    public void setClasse(String classe) {
        Classe = classe;
    }

    public String getSpecialite() {
        return Specialite;
    }

    public void setSpecialite(String specialite) {
        Specialite = specialite;
    }

    public String getId_professeur() {
        return professeur;
    }

    public void setId_professeur(String professeur) {
        professeur = professeur;
    }

    public String getId_tuteur() {
        return tuteur;
    }

    public void setId_tuteur(String tuteur) {
        tuteur = tuteur;
    }
}
