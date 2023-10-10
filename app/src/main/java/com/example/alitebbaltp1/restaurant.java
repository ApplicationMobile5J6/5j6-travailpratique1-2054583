package com.example.alitebbaltp1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class restaurant implements Parcelable {

    int noRestaurant;
    String nomRestaurant;
    int nbPlacesMax;
    int nbPlacesRestantes;

    @Override
    public String toString() {
        return nomRestaurant;
    }
    public String toString2(){
        return         "restaurant{" +
                "noRestaurant=" + noRestaurant +
                ", nomRestaurant='" + nomRestaurant + '\'' +
                ", nbPlacesMax=" + nbPlacesMax +
                ", nbPlacesRestantes=" + nbPlacesRestantes +
                '}';

    }

    public restaurant(int noRestaurant, String nomRestaurant, int nbPlacesMax, int nbPlacesRestantes) {
        this.noRestaurant = noRestaurant;
        this.nomRestaurant = nomRestaurant;
        this.nbPlacesMax = nbPlacesMax;
        this.nbPlacesRestantes = nbPlacesRestantes;
    }

    protected restaurant(Parcel in) {
        noRestaurant = in.readInt();
        nomRestaurant = in.readString();
        nbPlacesMax = in.readInt();
        nbPlacesRestantes = in.readInt();
    }

    public static final Parcelable.Creator<restaurant> CREATOR = new Parcelable.Creator<restaurant>() {
        @Override
        public restaurant createFromParcel(Parcel in) {
            return new restaurant(in);
        }

        @Override
        public restaurant[] newArray(int size) {
            return new restaurant[size];
        }
    };


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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(noRestaurant);
        parcel.writeString(nomRestaurant);
        parcel.writeInt(nbPlacesMax);
        parcel.writeInt(nbPlacesRestantes);
    }
}