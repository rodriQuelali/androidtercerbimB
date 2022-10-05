package com.example.myapplicationsegundob

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSuma = findViewById<Button>(R.id.btnSuma)
        val btnAbriSu = findViewById<Button>(R.id.btnAbriCalSu)
        val et1 = findViewById<EditText>(R.id.et1tk)
        val et2 = findViewById<EditText>(R.id.et2Kt)
        val tv3 = findViewById<TextView>(R.id.tv3Tk)

        btnSuma.setOnClickListener {
            /*val n1 = et1.text.toString().toInt();
            val n2 = et2.text.toString().toInt();
            val res = n1+n2;*/
            tv3.setText((et1.text.toString().toInt() + et2.text.toString().toInt()).toString());
        }

        btnAbriSu.setOnClickListener {
            val i = Intent(this, MainActivity2::class.java)
            startActivity(i)
        }

        val btn = findViewById<Button>(R.id.button)
        btn.setOnClickListener {
            val i = Intent(this, MainActivity2java::class.java)
            startActivity(i)
            //Toast.makeText(this, "onCreate - kotlyn", Toast.LENGTH_SHORT).show()
        }

    }
    /*
    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "onStart - kotlyn", Toast.LENGTH_SHORT).show()

    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this, "onRestart - kotlyn", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "onResume - kotlyn", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "onPause - kotlyn", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this, "onStop - kotlyn", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "onDestroy - kotlyn", Toast.LENGTH_SHORT).show()
    }*/
}