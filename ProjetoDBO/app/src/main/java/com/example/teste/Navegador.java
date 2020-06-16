package com.example.teste;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class Navegador extends AppCompatActivity {

     Button bt_ir;
     EditText textURL;
     WebView nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navegador);

        getSupportActionBar().setTitle("Navegador");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        bt_ir = (Button) findViewById(R.id.bt_ir);
        textURL = (EditText) findViewById(R.id.textURL);
        nav = (WebView) findViewById(R.id.nav);

        nav.getSettings().setJavaScriptEnabled(true);
        nav.setWebViewClient(new WebViewClient());
        nav.loadUrl("http://www.google.com");

    }
    public void bt_ir(View v){

        String txt = textURL.getText().toString();
        nav.loadUrl(txt);

    }

}