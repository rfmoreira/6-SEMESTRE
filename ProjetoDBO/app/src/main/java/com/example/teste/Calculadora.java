package com.example.teste;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Calculadora extends AppCompatActivity {
    Button bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,bt0,
            btCe,btBack,btSoma,btMult,btSub,btDiv,btPonto,btIgual;
    TextView text1,text2,text3,text4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculadora);

        getSupportActionBar().setTitle("Calculadora");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        bt0 = (Button) findViewById(R.id.bt0);
        bt1 = (Button) findViewById(R.id.bt1);
        bt2 = (Button) findViewById(R.id.bt2);
        bt3 = (Button) findViewById(R.id.bt3);
        bt4 = (Button) findViewById(R.id.bt4);
        bt5 = (Button) findViewById(R.id.bt5);
        bt6 = (Button) findViewById(R.id.bt6);
        bt7 = (Button) findViewById(R.id.bt7);
        bt8 = (Button) findViewById(R.id.bt8);
        bt9 = (Button) findViewById(R.id.bt9);
        btCe = (Button) findViewById(R.id.btCe);
        btBack = (Button) findViewById(R.id.btBack);
        btSoma = (Button) findViewById(R.id.btSoma);
        btMult = (Button) findViewById(R.id.btMult);
        btSub = (Button) findViewById(R.id.btSub);
        btDiv = (Button) findViewById(R.id.btDiv);
        btPonto = (Button) findViewById(R.id.btPonto);
        btIgual = (Button) findViewById(R.id.btIgual);
        text1 = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);
        text3 = (TextView) findViewById(R.id.text3);
        text4 = (TextView) findViewById(R.id.text4);
    }
    boolean bool = false;
    public void bt_0(View v){
        if(bool == false){
            String str = text1.getText().toString();
            text1.setText(str+"0");
        }else{
            String str = text2.getText().toString();
            text2.setText(str+"0");
        }
    }
    public void bt_1(View v){
        if(bool == false){
            String str = text1.getText().toString();
            text1.setText(str+"1");
        }else{
            String str = text2.getText().toString();
            text2.setText(str+"1");
        }

    }
    public void bt_2(View v){
        if(bool == false){
            String str = text1.getText().toString();
            text1.setText(str+"2");
        }else{
            String str = text2.getText().toString();
            text2.setText(str+"2");
        }
    }
    public void bt_3(View v){
        if(bool == false){
            String str = text1.getText().toString();
            text1.setText(str+"3");
        }else{
            String str = text2.getText().toString();
            text2.setText(str+"3");
        }
    }
    public void bt_4(View v){
        if(bool == false){
            String str = text1.getText().toString();
            text1.setText(str+"4");
        }else{
            String str = text2.getText().toString();
            text2.setText(str+"4");
        }
    }
    public void bt_5(View v){
        if(bool == false){
            String str = text1.getText().toString();
            text1.setText(str+"5");
        }else{
            String str = text2.getText().toString();
            text2.setText(str+"5");
        }
    }
    public void bt_6(View v){
        if(bool == false){
            String str = text1.getText().toString();
            text1.setText(str+"6");
        }else{
            String str = text2.getText().toString();
            text2.setText(str+"6");
        }
    }
    public void bt_7(View v){
        if(bool == false){
            String str = text1.getText().toString();
            text1.setText(str+"7");
        }else{
            String str = text2.getText().toString();
            text2.setText(str+"7");
        }

    }
    public void bt_8(View v){
        if(bool == false){
            String str = text1.getText().toString();
            text1.setText(str+"8");
        }else{
            String str = text2.getText().toString();
            text2.setText(str+"8");
        }
    }
    public void bt_9(View v){
        if(bool == false){
            String str = text1.getText().toString();
            text1.setText(str+"9");
        }else{
            String str = text2.getText().toString();
            text2.setText(str+"9");
        }
    }
    public void bt_ce(View v){
        bool = false;
        text1.setText("");
        text2.setText("");
        text3.setText("");
        text4.setText("");
    }
    public void bt_back(View v){
        if(bool == false){
            String str = text1.getText().toString();
            if(str.length()>0){
                String sub_str = str.substring(0,(str.length()-1));
                text1.setText(sub_str);
            }else{
                text1.setText("");
            }
        }else{
            String str = text2.getText().toString();
            if(str.length()>0){
               String sub_str = str.substring(0,(str.length()-1));
                 text2.setText(sub_str);
            }else{
                text2.setText("");
            }
        }
    }
    public void bt_soma(View v){
        bool = true;
        text3.setText("+");
    }
    public void bt_div(View v){
        bool = true;
        text3.setText("/");
    }
    public void bt_mult(View v){
        bool = true;
        text3.setText("x");

    }
    public void bt_sub(View v){
        bool = true;
        text3.setText("-");
    }
    public void bt_ponto(View v){
        if(bool ==false){
            String ponto = text1.getText().toString();
            if(ponto.contains(".")){

            }else{
                String str = text1.getText().toString();
                text1.setText(str+".");
            }
        }else {
            String ponto = text2.getText().toString();
            if(ponto.contains(".")){

            }else{
                String str = text2.getText().toString();
                text2.setText(str+".");
            }

        }
    }
    public void bt_igual(View v){
        String text_1 = text1.getText().toString();
        String text_2 = text2.getText().toString();
        String text_3 = text3.getText().toString();

        if(text_2.length() > 0){
            int txt1 = Integer.parseInt(text_1);
            int txt2 = Integer.parseInt(text_2);
            if(text_3.contains("x")){
                int result = txt1 * txt2;
                String str = Integer.toString(result);
                text4.setText(str);
            }else if(text_3.contains("/")){
                int result = txt1/txt2;
                String str = Integer.toString(result);
                text4.setText(str);
            }else if(text_3.contains("+")){
                int result = txt1 + txt2;
                String str = Integer.toString(result);
                text4.setText(str);
            }else if(text_3.contains("-")){
                int result = txt1 - txt2;
                String str = Integer.toString(result);
                text4.setText(str);
            }
        }
        else{

        }
    }

}
