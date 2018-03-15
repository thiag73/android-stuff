package fr.soetz.android.tp5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView liste;
    private String[] objets = {"Table", "Chaise", "Machine à Panini", "Frigo", "Micro-Ondes", "Comptoir", "Caisse", "Évier", "Cumulus", "Panic Room", "Poubelle de tri", "Boîte à idées (ah nan en fait)"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        liste = (ListView)findViewById(R.id.liste);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, objets);
        liste.setAdapter(adapter);

        liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), objets[position],
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
