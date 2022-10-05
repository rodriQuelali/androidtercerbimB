package com.example.myapplicationsegundob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

public class MainActivityListaAgenda extends AppCompatActivity {

    private ListView lv;
    private ArrayList<String> listaAgenda;
    private ArrayList<String> listaAgendaEspe;
    private TextView tvView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lista_agenda);

        lv = (ListView) findViewById(R.id.lvList);
        tvView = (TextView) findViewById(R.id.tvVista);
        listaAgenda = new ArrayList<String>();
        listaAgendaEspe = new ArrayList<String>();
        SharedPreferences shar = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        Map<String, ?> list = shar.getAll();
        for (Map.Entry<String,?> ele:list.entrySet()){
            listaAgenda.add(ele.getKey());
            listaAgendaEspe.add(ele.getValue().toString());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaAgenda);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                tvView.setText("Su numero de Telefono de " + lv.getItemAtPosition(i) + "es : " + listaAgendaEspe.get(i));
            }
        });
    }
}