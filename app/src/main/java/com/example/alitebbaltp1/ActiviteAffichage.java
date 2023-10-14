package com.example.alitebbaltp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ActiviteAffichage extends AppCompatActivity {


    restaurant restau;
    reservation res;
    EditText et_date;
    EditText et_heureDepart;
    EditText et_nomRes;
    EditText et_num;
    Spinner spn_heureDebut;
    TextView tv_aff;
    ImageView iv_table;
    TextView nom;
    TextView place;
    TextView date;
    Spinner sp_date;
    String dateRecu;
    String nomRes;
    ArrayList<reservation> listReservation = new ArrayList<reservation>();
    ArrayList<String> listDate = new ArrayList<>();
    ArrayList<reservation> dateSelection = new ArrayList<>();
    private ListView ma_liste;
    private adapterReservation adaptateur;
    private int index;
    private String dateSel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activite_affichage);
        Intent retour = new Intent();
        Context contexte = getApplicationContext();
        int duree = Toast.LENGTH_SHORT;


        tv_aff = (TextView)findViewById(R.id.tv_titreAffichage);
        iv_table = (ImageView)findViewById(R.id.iv_imageListe);
        nom = (TextView)findViewById(R.id.tv_nomListe);
        place = (TextView)findViewById(R.id.tv_placeListe);
        date = (TextView)findViewById(R.id.tv_dateListe);
        et_date = (EditText)findViewById(R.id.et_date);
        et_heureDepart = (EditText)findViewById(R.id.et_heureDepart);
        et_nomRes = (EditText)findViewById(R.id.et_nom);
        et_num = (EditText)findViewById(R.id.et_Phone);
        spn_heureDebut = (Spinner)findViewById(R.id.sp_heureDebut);
        sp_date = (Spinner)findViewById(R.id.sp_dateList);
        Intent extra = getIntent();
        restau = extra.getParcelableExtra("restaurant");

        tv_aff.setText("Affichage des réservation chez " + restau.getNomRestaurant());

        ma_liste = (ListView) findViewById(R.id.lv_reservation);

        Intent intent = getIntent();
        listReservation = getIntent().getParcelableArrayListExtra("res");

        listDate.add(String.valueOf(listReservation.get(0).getDateReservation()));
        Log.i("testeur", String.valueOf(listReservation));




        sp_date.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                dateRecu = listDate.get(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        sp_date.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                dateSelection.clear();
                dateSel = (String) adapterView.getItemAtPosition(i);


                for(int y = 0; y < listReservation.size(); y++){

                    if(listReservation.get(y).getDateReservation().matches(dateSel)){
                        dateSelection.add(listReservation.get(y));
                    }


                }

                adaptateur = new adapterReservation(getApplicationContext(), listReservation);
                ma_liste.setAdapter(adaptateur);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter<String> adaptateur = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listDate);
        adaptateur.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_date.setAdapter(adaptateur);


        ma_liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(ActiviteAffichage.this, " " + listReservation.get(i).getNoReservation() + " - " +
                        listReservation.get(i).getTelPersonne(), Toast.LENGTH_LONG).show();


            }
        });

    }
}