package com.example.thiago.tp5_ex4;

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

/**
 * Created by Thiago on 16/03/2018.
 */

public class ContactAdapter extends BaseAdapter {

    private Context mContext;
    private int layouteResourceId;
    private List<Contact> data;
    private LayoutInflater mInflater;

    public ContactAdapter(Context mContext, int layoutResourceId, List<Contact> data) {
        super();
        this.mContext = mContext;
        this.layouteResourceId = layoutResourceId;
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
        if(convertView == null) {
            layoutItem = (LinearLayout) mInflater.inflate(R.layout.list_item, parent, false);
        } else {
            layoutItem = (LinearLayout) convertView;
        }

        ImageView imageViewContact = (ImageView) layoutItem.findViewById(R.id.contact_image);
        TextView textViewContact = (TextView) layoutItem.findViewById(R.id.contact_text);

        Contact contact = data.get(position);

        imageViewContact.setImageResource(mContext.getResources().getIdentifier(contact.getAvatar(), "mipmap", "com.example.thiago.tp5_ex4"));
        textViewContact.setText(contact.getPrenom() + " " + contact.getNom());

        return layoutItem;
    }
}
