package com.example.alitebbaltp1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    restaurant Restaurant1;
    restaurant Restaurant2;

    ArrayList<restaurant> listRestau = new ArrayList<restaurant>();

    ArrayList<reservation> listReservation = new ArrayList<reservation>();

    Button btnAfficher;
    Button btnReserver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout linearLayout = findViewById(R.id.linearLayout);
        linearLayout.setBackgroundColor(getResources().getColor(R.color.grey));
        btnReserver = findViewById(R.id.btn_reserver);
        btnAfficher = findViewById(R.id.btn_afficherRes);
        Spinner spn_liste = (Spinner) findViewById(R.id.spn_restos);
        TextView tv_placerestante = (TextView) findViewById(R.id.tv_placesRestantes);
        btnReserver.setBackgroundColor(getResources().getColor(R.color.brun));
        btnAfficher.setBackgroundColor(getResources().getColor(R.color.brun));

        Restaurant1 = new restaurant(1,"chezCarlo",30,30);
        Restaurant2 = new restaurant(2,"zanzibar",16,16);

        btnReserver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });







    }


}