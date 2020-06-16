package com.example.teste;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class ContatoDao {

    private Conexao conexao;
    private SQLiteDatabase banco;

    public ContatoDao(Context context){
       try{
           conexao = new Conexao(context);
           banco = conexao.getWritableDatabase();
           Toast.makeText(context, "Conexão", Toast.LENGTH_SHORT).show();
       }catch (SQLException ex){
           Toast.makeText(context, "Erro "+ ex.getMessage(), Toast.LENGTH_SHORT).show();
       }

    }

    public long inserir(Contato contato){
       ContentValues values = new ContentValues();
        values.put("name",contato.getName());
        values.put("telefone",contato.getTelefone());
        values.put("celular",contato.getCelular());
        return banco.insert("contato",null,values);
    }

    public List<Contato> obterTodos(){
        List<Contato> contatos = new ArrayList<>();
        Cursor cursor = banco.query("contato", new  String[]{"id","name","telefone","celular"},
                null,null,null,null,null);
        while (cursor.moveToNext()){
            Contato c = new Contato();
            c.setId(cursor.getInt(0));
            c.setName(cursor.getString(1));
            c.setTelefone(cursor.getString(2));
            c.setCelular(cursor.getString(3));
            contatos.add(c);
        }
        return contatos;
    }
    public void excluir(Contato c){
        banco.delete("contato","id = ?", new String[]{c.getId().toString()});
    }
    public void atualizar(Contato c){
        ContentValues values = new ContentValues();
        values.put("name",c.getName());
        values.put("telefone",c.getTelefone());
        values.put("celular",c.getCelular());
        banco.update("contato",values,"id = ?", new String[]{c.getId().toString()});
    }
}
