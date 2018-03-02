package fr.soetz.android.tp5_ex2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private ListView listViewPerso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewPerso = (ListView)findViewById(R.id.listviewperso);

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


    }
}
