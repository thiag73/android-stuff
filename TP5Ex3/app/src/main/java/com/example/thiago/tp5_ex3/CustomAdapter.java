package com.example.thiago.tp5_ex3;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Thiago on 16/03/2018.
 */

public class CustomAdapter extends BaseAdapter {

    private Context mContext;
    private int layoutResourceId;
    private List<HashMap<String, String>> data;
    private LayoutInflater mInflater;

    public CustomAdapter(Context mContext, int layoutResourceId, ArrayList<HashMap<String, String>> data) {
        super();
        this.mContext = mContext;
        this.layoutResourceId = layoutResourceId;
        this.data = data;
        this.mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout layoutItem;
        if(convertView==null){
            layoutItem = (LinearLayout) mInflater.inflate(R.layout.affichageitem, parent, false);
        } else {
            layoutItem = (LinearLayout) convertView;
        }

        // get the elements in the layout
        ImageView imageViewLogo = (ImageView) layoutItem.findViewById(R.id.img);
        TextView textViewNom = (TextView) layoutItem.findViewById(R.id.nom);
        TextView textViewDescription = (TextView) layoutItem.findViewById(R.id.description);


        // Set the data for the list item. You can also set tags here if you want.

        Map<String, String> item = data.get(position);

        imageViewLogo.setImageResource(mContext.getResources().getIdentifier(item.get("img"),"mipmap","com.example.thiago.tp5_ex3"));
        textViewNom.setText(item.get("nom"));
        textViewDescription.setText(item.get("description"));

        return layoutItem;
    }
}
