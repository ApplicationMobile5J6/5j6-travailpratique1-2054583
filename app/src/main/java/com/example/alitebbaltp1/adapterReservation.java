package com.example.alitebbaltp1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class adapterReservation extends BaseAdapter {

    private Context dContexte;
    private List<reservation> listReservation = new ArrayList<>();
    private TextView tv_nom, tv_place, tv_date;
    private ImageView iv_table;


    public adapterReservation(Context _context, ArrayList<reservation> _liste){
        this.listReservation = _liste;
        this.dContexte = _context;

    }

    @Override
    public int getCount() {

        return listReservation.size();
    }

    @Override
    public Object getItem(int i) {

        return listReservation.get(i);
    }

    @Override
    public long getItemId(int i) {

        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        return view;
    }
}
