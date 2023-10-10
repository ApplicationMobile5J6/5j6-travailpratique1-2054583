package com.example.alitebbaltp1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class reservation implements Parcelable {

    int noReservation;
    String dateReservation;
    int nbPlace;
    String blocReservationDebut;
    String blocReservationFin;
    String nomPersonne;
    String telPersonne;


    protected reservation(Parcel in) {
        noReservation = in.readInt();
        dateReservation = in.readString();
        nbPlace = in.readInt();
        blocReservationDebut = in.readString();
        blocReservationFin = in.readString();
        nomPersonne = in.readString();
        telPersonne = in.readString();
    }

    public static final Creator<reservation> CREATOR = new Creator<reservation>() {
        @Override
        public reservation createFromParcel(Parcel in) {
            return new reservation(in);
        }

        @Override
        public reservation[] newArray(int size) {
            return new reservation[size];
        }
    };

    @Override
    public String toString() {
        return "reservation{" +
                "noReservation=" + noReservation +
                ", dateReservation='" + dateReservation + '\'' +
                ", nbPlace=" + nbPlace +
                ", blocReservationDebut='" + blocReservationDebut + '\'' +
                ", blocReservationFin='" + blocReservationFin + '\'' +
                ", nomPersonne='" + nomPersonne + '\'' +
                ", telPersonne='" + telPersonne + '\'' +
                '}';
    }

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
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(noReservation);
        parcel.writeString(dateReservation);
        parcel.writeInt(nbPlace);
        parcel.writeString(blocReservationDebut);
        parcel.writeString(blocReservationFin);
        parcel.writeString(nomPersonne);
        parcel.writeString(telPersonne);
    }
}