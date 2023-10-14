package com.example.alitebbaltp1;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class ActiviteReservation extends AppCompatActivity {
    TextView tv_place;
    TextView tv_titre;
    EditText et_date;
    EditText et_heureDepart;
    EditText et_nom;
    EditText et_num;
    TextView tv_progression;
    Button btn_reserver;
    Spinner spn_heureDebut;
    restaurant restau;
    reservation res;
    SeekBar sb_placeReserver;

    ArrayList<reservation> listReservation = new ArrayList<reservation>();

    private SimpleDateFormat dateFormater, heureFormater;
    private static int VALEUR = 5;
    String heureArrivee;
    String heureDepart;
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);

        Resources resources = getResources();
        String toastSauvegarder = "Reservation sauvegarder";
        String toastInvalide = "Un champ est invalide";

        tv_titre = (TextView) findViewById(R.id.tv_titre);
        tv_place = (TextView) findViewById(R.id.tv_placesRestante);
        et_date = (EditText)findViewById(R.id.et_date);
        sb_placeReserver = (SeekBar)findViewById(R.id.pb_placeReserve);
        tv_progression = (TextView)findViewById(R.id.tv_progression);
        spn_heureDebut = (Spinner)findViewById(R.id.sp_heureDebut);
        et_heureDepart = (EditText)findViewById(R.id.et_heureDepart);
        btn_reserver = (Button)findViewById(R.id.btn_reserverDeux);
        et_nom = (EditText)findViewById(R.id.et_nom);
        et_num = (EditText)findViewById(R.id.et_Phone);
        String[] listeDebut = new String[] {"16:00", "17:30", "19:00", "20:30", "22:00"};
        String[] listeFin = new String[] {"17:29", "18:59", "20:29", "21:59", "23:59"};


        btn_reserver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent retour = new Intent();
                Context contexte = getApplicationContext();
                String texte = "Un des champs est invalide";
                String regexStr = "^\\d{3}-\\d{3}-\\d{4}$";
                int duree = Toast.LENGTH_SHORT;

                String numero = et_num.getText().toString();

                if(sb_placeReserver.getProgress() < 1 || et_nom.getText().toString().matches("") || et_date.getText().toString().matches("")
                        || numero.matches("") || !numero.matches(regexStr)){
                    Toast msg_Toast = Toast.makeText(contexte, toastInvalide, duree);
                    msg_Toast.setGravity(Gravity.TOP|Gravity.LEFT, 0, 0);
                    msg_Toast.show();

                }else{

                     res = new reservation(1, " " + et_date.getText(), sb_placeReserver.getProgress(),
                             " " + spn_heureDebut.getSelectedItem(),
                             " " + et_heureDepart.getText(), " " + et_nom.getText(), " " + et_num.getText());

                     listReservation.add(res);


                     Bundle b_rep = new Bundle();
                     b_rep.putParcelableArrayList("res", listReservation);
                     retour.putExtras(b_rep);
                     setResult(RESULT_OK, retour);

                    Toast msg_Toast2 = Toast.makeText(getApplicationContext(), toastSauvegarder, Toast.LENGTH_SHORT);
                    msg_Toast2.setGravity(Gravity.TOP|Gravity.LEFT, 0, 0);
                    msg_Toast2.show();
                }



            }
        });

        ArrayAdapter<String> adaptateur = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listeDebut);
        adaptateur.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn_heureDebut.setAdapter(adaptateur);

        spn_heureDebut.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                heureArrivee = listeDebut[i];
                heureDepart = listeFin[i];


                et_heureDepart.setText(heureDepart);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        sb_placeReserver.setMax(10);
        sb_placeReserver.setProgress(1);

        Intent extra = getIntent();
        restau = extra.getParcelableExtra("restaurant");

        tv_titre.setText("Réservation de places au restaurant " + restau.getNomRestaurant());
        tv_place.setText(restau.getNbPlacesRestantes() + " places restantes");
        sb_placeReserver.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progression = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progression = i;
                tv_progression.setText(i + " places reservées.");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



        et_date.setInputType(InputType.TYPE_NULL);
        dateFormater = new SimpleDateFormat("yyyy-MM-dd", Locale.CANADA_FRENCH);

        et_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();

                DatePickerDialog calendrier = new DatePickerDialog(ActiviteReservation.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        Calendar nouvelleDate = Calendar.getInstance();
                        nouvelleDate.set(year, month, dayOfMonth);
                        et_date.setText(dateFormater.format(nouvelleDate.getTime()));
                    }
                }, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));
                calendrier.show();
            }
        });

    }
}