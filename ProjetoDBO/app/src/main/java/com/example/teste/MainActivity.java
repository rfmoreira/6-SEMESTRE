package com.example.teste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void bt_calc(View V){
        Intent intent = new Intent(getApplicationContext(),Calculadora.class);
        startActivity(intent);
    }
    public void bt_Nav(View v){
        Intent intent = new Intent(getApplicationContext(),Navegador.class);
        startActivity(intent);
    }
    public void bt_agenda(View v){
        Intent intent = new Intent(getApplicationContext(), Agenda.class);
        startActivity(intent);
    }
}