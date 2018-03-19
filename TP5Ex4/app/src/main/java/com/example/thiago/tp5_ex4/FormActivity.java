package com.example.thiago.tp5_ex4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class FormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulaire);

        Button boutonEnregistrer = (Button) findViewById(R.id.enreg);
        boutonEnregistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String prenom = ((EditText)findViewById(R.id.prenom)).getText().toString().equals("") ? null : ((EditText)findViewById(R.id.prenom)).getText().toString();
                String nom = ((EditText)findViewById(R.id.nom)).getText().toString().equals("") ? null : ((EditText)findViewById(R.id.nom)).getText().toString();
                String tel = ((EditText)findViewById(R.id.tel)).getText().toString().equals("") ? null : ((EditText)findViewById(R.id.tel)).getText().toString();
                String mail = ((EditText)findViewById(R.id.mail)).getText().toString().equals("") ? null : ((EditText)findViewById(R.id.mail)).getText().toString();
                String dateNaissance = ((EditText)findViewById(R.id.datenaissance)).getText().toString().equals("") ? null : ((EditText)findViewById(R.id.datenaissance)).getText().toString();

                char sexe = 'U';

                if(((RadioButton) findViewById(R.id.radioButtonH)).isChecked()) {
                    sexe = 'M';
                } else if(((RadioButton) findViewById(R.id.radioButtonF)).isChecked()) {
                    sexe = 'F';
                }

                Date date = null;
                if(dateNaissance != null){
                    try {
                        DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                        date = format.parse(dateNaissance);
                    }
                    catch(ParseException pe) {

                    }
                }

                Contact contact = new Contact(nom, prenom, sexe, date, tel, mail, "");

                Intent monIntent = new Intent();
                monIntent.putExtra("contact", contact);
                setResult(RESULT_OK, monIntent);
                finish();
            }
        });
    }

}
