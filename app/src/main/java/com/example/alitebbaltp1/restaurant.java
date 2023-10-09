package com.example.alitebbaltp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class restaurant extends AppCompatActivity {

    int noRestaurant;
    String nomRestaurant;
    int nbPlacesMax;
    int nbPlacesRestantes;

    public int getNoRestaurant() {
        return noRestaurant;
    }

    public void setNoRestaurant(int noRestaurant) {
        this.noRestaurant = noRestaurant;
    }

    public String getNomRestaurant() {
        return nomRestaurant;
    }

    public void setNomRestaurant(String nomRestaurant) {
        this.nomRestaurant = nomRestaurant;
    }

    public int getNbPlacesMax() {
        return nbPlacesMax;
    }

    public void setNbPlacesMax(int nbPlacesMax) {
        this.nbPlacesMax = nbPlacesMax;
    }

    public int getNbPlacesRestantes() {
        return nbPlacesRestantes;
    }

    public void setNbPlacesRestantes(int nbPlacesRestantes) {
        this.nbPlacesRestantes = nbPlacesRestantes;
    }

    public restaurant(int noRestaurant, String nomRestaurant, int nbPlacesMax, int nbPlacesRestantes) {
        this.noRestaurant = noRestaurant;
        this.nomRestaurant = nomRestaurant;
        this.nbPlacesMax = nbPlacesMax;
        this.nbPlacesRestantes = nbPlacesRestantes;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
    }

}