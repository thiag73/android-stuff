package com.example.thiago.tp5_ex4;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static int RQC = (int)(Math.random()*5000);
    private List<Contact> listItems = load();
    private ContactAdapter adapter;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        context = getApplicationContext();

        adapter = new ContactAdapter(this.getBaseContext(), R.layout.list_item, listItems);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent monIntent = new Intent(MainActivity.this, FormActivity.class);
                startActivityForResult(monIntent, RQC);
            }
        });

        //TODO ajouter les contacts déjà enregistrés dans la liste
        final ListView listViewPerso = (ListView) findViewById(R.id.listviewperso);
        listViewPerso.setAdapter(adapter);

        listViewPerso.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent monIntent = new Intent(MainActivity.this, ResumeActivity.class);
                monIntent.putExtra("contact", listItems.get(position));
                startActivity(monIntent);
            }
        });

        listViewPerso.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                listItems.remove(position);
                changed();
                return(false);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == RQC && resultCode == RESULT_OK) {
            Contact con = (Contact) data.getSerializableExtra("contact");

            listItems.add(con);
            changed();
        }
    }

    private void changed() {
        Log.d("app", "saving");
        adapter.notifyDataSetChanged();
        try {
            FileOutputStream fos = context.openFileOutput("save", Context.MODE_PRIVATE);
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(listItems);
            os.close();
            fos.close();
        } catch(Exception e) {
            Log.d("app", "bug save - " + e.getMessage());
        }
    }

    private ArrayList<Contact> load(){
        Log.d("app", "loading");
        ArrayList<Contact> liste = new ArrayList<Contact>();
        try {
            FileInputStream fis = context.openFileInput("save");
            ObjectInputStream is = new ObjectInputStream(fis);
            liste = (ArrayList<Contact>) is.readObject();
            is.close();
            fis.close();
        } catch(Exception e) {
            Log.d("app", "bug load - " + e.getMessage());
        }

        return(liste);
    }
}
