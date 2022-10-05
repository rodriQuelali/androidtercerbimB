package com.example.myapplicationsegundob;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2java extends AppCompatActivity {

    private EditText et1, et2;
    private TextView tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2java);

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        tv3 = (TextView) findViewById(R.id.tv3);

        //Toast.makeText(this, "onCreate - java", Toast.LENGTH_SHORT).show();

    }

    public void suma (View view){
        /*String valor1 = et1.getText().toString();
        String valor2 = et2.getText().toString();
        int nro1 = Integer.parseInt(et1.getText().toString());
        int nro2 = Integer.parseInt(et2.getText().toString());
        int suma = nro1 + nro2;*/
        //String resu = String.valueOf(Integer.parseInt(et1.getText().toString())+Integer.parseInt(et2.getText().toString()));
        tv3.setText(String.valueOf(Integer.parseInt(et1.getText().toString()) + Integer.parseInt(et2.getText().toString())));
    }


    //Toast --> es alerta de mensaje.
    //javascript --->console.log()-->alert()
    /*@Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart - java", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop - java", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy - java", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause - java", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume - java", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "onRestart - java", Toast.LENGTH_SHORT).show();

    }*/

}


