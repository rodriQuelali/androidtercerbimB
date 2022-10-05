package com.example.myapplicationsegundob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivityAgenda extends AppCompatActivity {

    private EditText txtN, txtD;
    private Button btnR, btnG, btnL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_agenda);

        txtN = (EditText) findViewById(R.id.txtNomAge);
        txtD = (EditText) findViewById(R.id.txtDateAge);
        btnG = (Button) findViewById(R.id.btnGra);
        btnR = (Button) findViewById(R.id.btnRecu);
        btnL = (Button) findViewById(R.id.btnList);

        btnG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences shared = getSharedPreferences("agenda", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = shared.edit();
                editor.putString(txtN.getText().toString(), txtD.getText().toString());
                editor.commit();
                Toast.makeText(MainActivityAgenda.this, "Datos guardado correctamente...", Toast.LENGTH_SHORT).show();
            }
        });

        btnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences shared = getSharedPreferences("agenda", Context.MODE_PRIVATE);
                String d = shared.getString(txtN.getText().toString(), "");
                if(d.length() == 0){
                    Toast.makeText(MainActivityAgenda.this, "No ay datos..", Toast.LENGTH_SHORT).show();
                }else {
                    txtD.setText(d);
                }
            }
        });

        btnL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivityAgenda.this, MainActivityListaAgenda.class);
                startActivity(i);
            }
        });

    }
}