package com.example.thiago.tp5_ex4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class ResumeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume);

        Contact contact = (Contact) getIntent().getSerializableExtra("contact");

        ((TextView)findViewById(R.id.nom_prenom_sexe)).setText(contact.getPrenom() + " " + contact.getNom() + " (" + contact.getSexe() + ")");

        DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        if(contact.getDateNaissance() != null) {
            ((TextView)findViewById(R.id.date_naissance)).setText(format.format(contact.getDateNaissance()));
        } else {
            ((TextView)findViewById(R.id.date_naissance)).setText("");
        }

        ((TextView)findViewById(R.id.tel_mail)).setText(contact.getTel() + ", " + contact.getMail());
    }
}
