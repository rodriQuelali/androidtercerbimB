package com.example.myapplicationsegundob;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    private EditText txt1, txt2,txt3;
    private Button btnca;
    private TextView tv3Cal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txt1 = (EditText) findViewById(R.id.txt1Sul);
        txt2 = (EditText) findViewById(R.id.txt2Sul);
        txt3 = (EditText) findViewById(R.id.txt3Sul);
        tv3Cal = (TextView) findViewById(R.id.tv3sul);
        btnca = (Button) findViewById(R.id.btnCal);

        btnca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //condicion para la valiacion [1000 - 40000]
                if(Integer.parseInt(txt1.getText().toString()) > 1000 && Integer.parseInt(txt2.getText().toString()) > 1000 && Integer.parseInt(txt3.getText().toString()) > 1000
                    && Integer.parseInt(txt1.getText().toString()) < 40000 && Integer.parseInt(txt2.getText().toString()) < 40000 && Integer.parseInt(txt3.getText().toString()) < 40000){
                  //logica de para encontrar el sueldo de l medio de 3 sueldos
                    if(Integer.parseInt(txt1.getText().toString()) > Integer.parseInt(txt2.getText().toString()) && Integer.parseInt(txt1.getText().toString()) > Integer.parseInt(txt3.getText().toString())){
                      if(Integer.parseInt(txt2.getText().toString()) > Integer.parseInt(txt3.getText().toString())){
                          tv3Cal.setText(txt2.getText().toString());
                      }else {
                          tv3Cal.setText(txt3.getText().toString());
                      }
                  }else if(Integer.parseInt(txt2.getText().toString()) > Integer.parseInt(txt1.getText().toString()) && Integer.parseInt(txt2.getText().toString()) > Integer.parseInt(txt3.getText().toString())){
                      if(Integer.parseInt(txt1.getText().toString()) > Integer.parseInt(txt3.getText().toString())){
                          tv3Cal.setText(txt1.getText().toString());
                      }else {
                          tv3Cal.setText(txt3.getText().toString());
                      }
                  }else {
                      if(Integer.parseInt(txt1.getText().toString()) > Integer.parseInt(txt2.getText().toString())){
                          tv3Cal.setText(txt1.getText().toString());
                      }else {
                          tv3Cal.setText(txt2.getText().toString());
                      }
                  }
                }else {
                    Toast.makeText(MainActivity2.this, "Solo se aceptan valor de 1000  a 40000", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



}