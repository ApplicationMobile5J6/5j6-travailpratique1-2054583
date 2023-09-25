package com.example.alitebbaltp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout linearLayout = findViewById(R.id.linearLayout);
        linearLayout.setBackgroundColor(getResources().getColor(R.color.grey));
        Button btnReserver = findViewById(R.id.btn_reserver);
        Button btnAfficher = findViewById(R.id.btn_afficherRes);
        btnReserver.setBackgroundColor(getResources().getColor(R.color.brun));
        btnAfficher.setBackgroundColor(getResources().getColor(R.color.brun));

    }


}