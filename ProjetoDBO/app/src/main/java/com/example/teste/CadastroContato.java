package com.example.teste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroContato extends AppCompatActivity {

    EditText textName, textTel, textCel;
    Button btSalvar;
    ContatoDao contatoDao;
    Contato contato = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_contato);

        getSupportActionBar().setTitle("Cadastro Contato");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        textName = (EditText) findViewById(R.id.textName);
        textTel = (EditText) findViewById(R.id.textTel);
        textCel = (EditText) findViewById(R.id.textCel);
        btSalvar = (Button) findViewById(R.id.bt_salvarCont);
        contatoDao = new ContatoDao(this);

        Intent it = getIntent();
        if(it.hasExtra("contato")){
            contato = (Contato) it.getSerializableExtra("contato");
            textName.setText(contato.getName());
            textCel.setText(contato.getCelular());
            textTel.setText(contato.getTelefone());
        }
    }

    public void btSave(View v){
        if(contato == null){
            contato = new Contato();
            contato.setName(textName.getText().toString());
            contato.setTelefone(textTel.getText().toString());
            contato.setCelular(textCel.getText().toString());
            long id = contatoDao.inserir(contato);
            Toast.makeText(this, "Contato inserido com id: " + id, Toast.LENGTH_SHORT).show();
        }else{
            contato.setName(textName.getText().toString());
            contato.setTelefone(textTel.getText().toString());
            contato.setCelular(textCel.getText().toString());
            contatoDao.atualizar(contato);
            Toast.makeText(this, "Contato Atualizado", Toast.LENGTH_SHORT).show();
        }
    }
}