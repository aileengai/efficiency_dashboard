package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.myapplication.R.*
//import java.util.Random
import kotlin.random.Random


class Activity2 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_2)
val Num1 = intent.getStringExtra("Num1")
val Num2 = intent.getStringExtra("Num2")
val Car = intent.getStringExtra("Cartype")
val Agestr = intent.getStringExtra("AgeVal")
val Val1 = Num1?.toInt()

val Vehicle = Car.toString()
val random = Random.Default
val PrevOdo = random.nextInt((Val1?.minus(100)!!),(Val1?.minus(80)!!))
        val Val2 = random.nextInt(5,20)
val OdoDiff =Val1-PrevOdo
val Answer: Float? = Val2.toFloat()?.let { OdoDiff?.div(it) }

    var efficiency:TextView = findViewById(id.Efficiency)
     efficiency.text = "$Answer Km/L"

      var kotse:TextView = findViewById(id.textView8)
        val reco = CheckEfficiency(Car.toString())
        val recoVal: Float? = reco?.toFloat()
        val PerCent : Float? = (recoVal?.let{ Answer?.div(it)})?.times(100)
        kotse.text = "Vehicle: $Car Efficiency $PerCent % "

        val Rating = Rater(PerCent)
   var recommendation: TextView = findViewById(id.textView6)
        recommendation.text = " For a $Agestr year old car, your car is in $Rating condition"
    }

}





fun CheckEfficiency(car: String):String{
   val standard =  when(car){
        "Ford Ranger" ->  "10"
        "Kia Stonic" -> "18.8"
        "Mitsubishi Xpander" -> "21"
        "Nissan Navara" -> "12.1"
        "Sarao 24 Seater" -> "5.5"
        "Toyota Vios" -> "20"
       else -> "Invalid Data"
    }
    return standard
}
fun Rater(PerCent: Float?): String{
    var rated:String = ""
    if (PerCent != null) {
        if (PerCent >= 90) {
            rated = "Great"
        } else if (PerCent in 50.0..89.0) {
            rated = "Okay"
        } else if (PerCent in 0.0..49.0) {
            rated = "Okay"
        }
    }
    return rated
}