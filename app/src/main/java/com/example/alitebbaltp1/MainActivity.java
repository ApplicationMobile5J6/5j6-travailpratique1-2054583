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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    restaurant Restaurant1;
    restaurant Restaurant2;

    restaurant restau;
    ArrayList<restaurant> listRestau = new ArrayList<restaurant>();

    ArrayList<reservation> listReservation = new ArrayList<reservation>();

    Button btnAfficher;
    Button btnReserver;

    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {

                    if(result.getResultCode() == Activity.RESULT_OK){
                        Bundle bundle = result.getData().getExtras();

                        listReservation = bundle.getParcelableArrayList("res");
                        Log.i("Test", String.valueOf(listReservation.get(0)));
                    }



                }
            }
    );


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

        Restaurant1 = new restaurant(1, "chezCarlo", 30, 30);
        Restaurant2 = new restaurant(2, "zanzibar", 16, 16);

        listRestau.add(0, Restaurant1);
        listRestau.add(1, Restaurant2);

        btnReserver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_afficherRestau = new Intent(MainActivity.this, ActiviteReservation.class);
                intent_afficherRestau.putExtra("restaurant", restau);
                activityResultLauncher.launch(intent_afficherRestau);
            }
        });
        btnAfficher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent_afficher = new Intent(MainActivity.this, ActiviteAffichage.class);
                intent_afficher.putExtra("res", listReservation);
                intent_afficher.putExtra("restaurant", restau);
                startActivity(intent_afficher);
                Log.i("Test4", String.valueOf(listReservation));

            }
        });

        ArrayAdapter<restaurant> adaptateur = new ArrayAdapter<restaurant>(this, android.R.layout.simple_spinner_dropdown_item, listRestau);
        spn_liste.setAdapter(adaptateur);

        spn_liste.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if ((listRestau.get((i)).nbPlacesRestantes) > 5) {
                    tv_placerestante.setText(listRestau.get((i)).nbPlacesRestantes + " places restantes");
                    tv_placerestante.setTextColor(getResources().getColor(R.color.jaune));

                    restau = listRestau.get(i);
                } else {
                    tv_placerestante.setText(listRestau.get((i)).nbPlacesRestantes + " places restantes");
                    tv_placerestante.setTextColor(getResources().getColor(R.color.red));

                    restau = listRestau.get(i);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }



}


