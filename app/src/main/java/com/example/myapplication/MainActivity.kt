package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val Spinner: Spinner= findViewById(R.id.spinnerCar)
        ArrayAdapter.createFromResource(
            this,
            R.array.CarTypes,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
            Spinner.adapter = adapter
        }
        var button1 = findViewById<Button>(R.id.button)
        button1.setOnClickListener{

            val   OdoRead: EditText = findViewById(R.id.OdoReading)
            val  Fuelamt: EditText = findViewById(R.id.FuelAmt)
            val Age: EditText = findViewById(R.id.Age)

                val Num1 = OdoRead.text.toString()
            val Num2 = Fuelamt.text.toString()
            val AgeVal = Age.text.toString()
            val Cartype = Spinner.selectedItem as String
            val intent1 = Intent(this, Activity2::class.java). also {
                it.putExtra("Num1",Num1)
                it.putExtra("Num2",Num2)
                it.putExtra("Cartype",Cartype)
                it.putExtra("AgeVal", AgeVal)
            }

            startActivity(intent1)
        }    }
}