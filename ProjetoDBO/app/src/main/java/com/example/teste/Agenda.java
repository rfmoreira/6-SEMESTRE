package com.example.teste;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class Agenda extends AppCompatActivity {


    ListView listView;
    ContatoDao dao;
    List<Contato> contatos;
    List<Contato> contatosFiltrados = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);

        getSupportActionBar().setTitle("Agenda");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listView = (ListView) findViewById(R.id.lista_contatos);
        dao = new ContatoDao(this);
        contatos = dao.obterTodos();
        contatosFiltrados.addAll(contatos);
        //ArrayAdapter<Contato> adptador = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,contatosFiltrados);
        ContatoAdapter adaptador = new ContatoAdapter(this,contatosFiltrados);
        listView.setAdapter(adaptador);

        registerForContextMenu(listView);

    }

    public void excluir(MenuItem item){
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        final Contato cExcluir = contatosFiltrados.get(menuInfo.position);
        AlertDialog dialog = new AlertDialog.Builder(this).setTitle("Atenção").setMessage("Excluir Contato ?")
                .setNegativeButton("NÃO",null).setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                contatosFiltrados.remove(cExcluir);
                                contatos.remove(cExcluir);
                                dao.excluir(cExcluir);
                                listView.invalidateViews();
                            }
                        }).create();
                dialog.show();
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.menu_agenda,menu);

        SearchView sv = (SearchView) menu.findItem(R.id.app_bar_search).getActionView();
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchContato(newText);
                return false;
            }
        });
        return true;
    }
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu,v,menuInfo);
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.menu_contato,menu);
    }

    public void searchContato(String name){
        contatosFiltrados.clear();;
        for( Contato c: contatos){
            if(c.getName().toLowerCase().contains(name.toLowerCase())){
                contatosFiltrados.add(c);
        }
        listView.invalidateViews();
    }}

    public void cadastrar (MenuItem intem){
        Intent it = new Intent(this, CadastroContato.class);
        startActivity(it);
    }

    public void editar(MenuItem item){
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        final Contato cEditar = contatosFiltrados.get(menuInfo.position);

        Intent it = new Intent(this, CadastroContato.class);
        it.putExtra("contato",cEditar);
        startActivity(it);

    }

    public void onResume(){
        super.onResume();
        contatos = dao.obterTodos();
        contatosFiltrados.clear();
        contatosFiltrados.addAll(contatos);
        listView.invalidateViews();
    }

}