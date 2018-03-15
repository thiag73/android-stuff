package fr.soetz.android.tp5_ex2;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private ListView listViewPerso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewPerso = (ListView) findViewById(R.id.listviewperso);

        ArrayList<HashMap<String, String>> listItem = new ArrayList<HashMap<String, String>>();

        HashMap<String, String> map;

        map = new HashMap<String, String>();
        map.put("nom", "BDE Info");
        map.put("description", "BDE du département informatique");
        map.put("img", String.valueOf(R.mipmap.bde_info));

        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("nom", "BDE Bio");
        map.put("description", "BDE du département biologie");
        map.put("img", String.valueOf(R.mipmap.bde_bio));

        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("nom", "BDE GC");
        map.put("description", "BDE du département génie civil");
        map.put("img", String.valueOf(R.mipmap.bde_gc));

        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("nom", "BDE GCGP");
        map.put("description", "BDE du département génie chimique - génie des procédés");
        map.put("img", String.valueOf(R.mipmap.bde_gcgp));

        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("nom", "BDE Chimie");
        map.put("description", "BDE du département chimie");
        map.put("img", String.valueOf(R.mipmap.bde_chimie));

        listItem.add(map);

        SimpleAdapter mSchedule = new SimpleAdapter(this.getBaseContext(), listItem, R.layout.affichageitem,
                new String[]{"img", "nom", "description"}, new int[]{R.id.img, R.id.nom, R.id.description});

        listViewPerso.setAdapter(mSchedule);

        listViewPerso.setOnItemClickListener(new OnItemClickListener() {
            @Override
            @SuppressWarnings("unchecked")
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                HashMap<String, String> map = (HashMap<String, String>) listViewPerso.getItemAtPosition(position);
                AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
                adb.setTitle("Sélection Item");
                adb.setMessage("Votre choix : " + map.get("nom"));
                adb.setPositiveButton("Ok", null);
                adb.show();
            }
        });
    }
}
