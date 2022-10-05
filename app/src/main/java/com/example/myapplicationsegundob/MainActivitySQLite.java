package com.example.myapplicationsegundob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivitySQLite extends AppCompatActivity {

    private EditText txtC, txtD, txtP;
    private Button btnR, btnCoCdi, btnCDes, btnEli, btnM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sqlite);


        txtC = (EditText) findViewById(R.id.txtCodigoSqlite);
        txtD = (EditText) findViewById(R.id.txtDesSqlite);
        txtP = (EditText) findViewById(R.id.txtPreSqlite);

        btnR = (Button) findViewById(R.id.btnGusqli);
        btnCoCdi = (Button) findViewById(R.id.btnconsqlicod);
        btnCDes = (Button) findViewById(R.id.btnconsusqlides);
        btnEli = (Button) findViewById(R.id.btnBajasqli);
        btnM = (Button) findViewById(R.id.btnEditarSqlit);

        //Guardar datos
        btnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(MainActivitySQLite.this, "administracion", null, 1);
                SQLiteDatabase bd = admin.getWritableDatabase();
                ContentValues registro = new ContentValues();
                registro.put("codigo", txtC.getText().toString());
                registro.put("descripcion", txtD.getText().toString());
                registro.put("precio", txtP.getText().toString());
                bd.insert("articulos", null, registro);
                bd.close();
                txtP.setText("");
                txtC.setText("");
                txtD.setText("");
                Toast.makeText(MainActivitySQLite.this, "Se registro Correctamente....", Toast.LENGTH_SHORT).show();
            }
        });

        //Consulta por codigo
        btnCoCdi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(MainActivitySQLite.this, "administracion", null, 1);
                SQLiteDatabase bd = admin.getWritableDatabase();
                Cursor fila = bd.rawQuery("select * from articulos where codigo =" + txtC.getText().toString(), null);
                if(fila.moveToFirst()){
                    txtD.setText(fila.getString(0));
                    txtD.setText(fila.getString(1));
                }else {
                    Toast.makeText(MainActivitySQLite.this, "NO se encontro Registro con el Codigo", Toast.LENGTH_SHORT).show();
                }
                bd.close();
            }
        });
        //Consultapor precio
        btnCDes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(MainActivitySQLite.this, "administracion", null, 1);
                SQLiteDatabase bd = admin.getWritableDatabase();
                Cursor fila = bd.rawQuery("select * from articulos where descripcion ='" + txtD.getText().toString() + "'", null);
                if(fila.moveToFirst()){
                    txtC.setText(fila.getString(0));
                    txtP.setText(fila.getString(2));
                }else {
                    Toast.makeText(MainActivitySQLite.this, "NO se encontro Registro con el Codigo", Toast.LENGTH_SHORT).show();
                }
                bd.close();
            }
        });

        //Delete - eliminar
        btnEli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(MainActivitySQLite.this, "administracion", null, 1);
                SQLiteDatabase bd = admin.getWritableDatabase();
                int cat = bd.delete("articulos", "codigo=" + txtC.getText().toString(), null);
                bd.close();
                txtC.setText("");
                txtD.setText("");
                txtP.setText("");
                if(cat == 1){
                    Toast.makeText(MainActivitySQLite.this, "El articulo fue eliminado correctamente", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivitySQLite.this, "No existe dicho articulo en el registro", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //modificar o update
        btnM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(MainActivitySQLite.this, "administracion", null, 1);
                SQLiteDatabase bd = admin.getWritableDatabase();
                ContentValues registro = new ContentValues();
                registro.put("codigo", txtC.getText().toString());
                registro.put("descripcion", txtD.getText().toString());
                registro.put("precio", txtP.getText().toString());
                int cant = bd.update("articulos", registro, "codigo=" + txtC.getText().toString(), null);
                bd.close();
                if(cant == 1){
                    Toast.makeText(MainActivitySQLite.this, "Se edito correctamente", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivitySQLite.this, "Error, no se puedo editar los datos con dicho codigo!!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}