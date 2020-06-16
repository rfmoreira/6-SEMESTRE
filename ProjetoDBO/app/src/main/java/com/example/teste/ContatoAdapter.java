package com.example.teste;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ContatoAdapter extends BaseAdapter {

    private List<Contato> contatos;
    private Activity activity;

    public ContatoAdapter(Activity activity, List<Contato> contatos) {
        this.activity =activity;
        this.contatos = contatos;
    }

    @Override
    public int getCount() {
        return contatos.size();
    }

    @Override
    public Object getItem(int position) {
        return contatos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return contatos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = activity.getLayoutInflater().inflate(R.layout.list_view,parent,false);
        TextView name = v.findViewById(R.id.txtName);
        TextView tel = v.findViewById(R.id.txtTelefone);
        TextView cel = v.findViewById(R.id.txtCelular);
        Contato c = contatos.get(position);

        name.setText(c.getName());
        tel.setText(c.getTelefone());
        cel.setText(c.getCelular());
        return v;
    }
}
