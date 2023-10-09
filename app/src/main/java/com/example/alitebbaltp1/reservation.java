package com.example.alitebbaltp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class reservation extends AppCompatActivity {

    int noReservation;
    String dateReservation;
    int nbPlace;
    String blocReservationDebut;
    String blocReservationFin;
    String nomPersonne;
    String telPersonne;

    public int getNoReservation() {
        return noReservation;
    }

    public void setNoReservation(int noReservation) {
        this.noReservation = noReservation;
    }

    public String getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(String dateReservation) {
        this.dateReservation = dateReservation;
    }

    public int getNbPlace() {
        return nbPlace;
    }

    public void setNbPlace(int nbPlace) {
        this.nbPlace = nbPlace;
    }

    public String getBlocReservationDebut() {
        return blocReservationDebut;
    }

    public void setBlocReservationDebut(String blocReservationDebut) {
        this.blocReservationDebut = blocReservationDebut;
    }

    public String getBlocReservationFin() {
        return blocReservationFin;
    }

    public void setBlocReservationFin(String blocReservationFin) {
        this.blocReservationFin = blocReservationFin;
    }

    public String getNomPersonne() {
        return nomPersonne;
    }

    public void setNomPersonne(String nomPersonne) {
        this.nomPersonne = nomPersonne;
    }

    public String getTelPersonne() {
        return telPersonne;
    }

    public void setTelPersonne(String telPersonne) {
        this.telPersonne = telPersonne;
    }

    public reservation(int noReservation, String dateReservation, int nbPlace, String blocReservationDebut, String blocReservationFin, String nomPersonne, String telPersonne) {
        this.noReservation = noReservation;
        this.dateReservation = dateReservation;
        this.nbPlace = nbPlace;
        this.blocReservationDebut = blocReservationDebut;
        this.blocReservationFin = blocReservationFin;
        this.nomPersonne = nomPersonne;
        this.telPersonne = telPersonne;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
    }


}