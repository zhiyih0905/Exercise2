package com.example.exercise2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener{
            textViewBMI.setText("BMI :")
            imageViewProfile.setImageResource(R.drawable.empty)
            var BMI= 0.0
            val weight = editTextWeight.text.toString()
            val heightCM = editTextHeight.text.toString()
            if(heightCM.toString().equals("") || weight.toString().equals("")){
                Toast.makeText(getApplicationContext(), "Please fill in the detail to calculate.", Toast.LENGTH_SHORT).show()
                println("toasted.")
            }
            else{
                BMI = weight.toDouble()/ ((heightCM.toDouble()/100)*(heightCM.toDouble()/100))
                when(BMI){
                    in Double.MIN_VALUE..18.5 -> {
                        textViewBMI.append("Underweight")
                        imageViewProfile.setImageResource(R.drawable.under)
                    }
                    in Double.MIN_VALUE..24.9 ->{
                        textViewBMI.append("Normal")
                        imageViewProfile.setImageResource(R.drawable.normal)
                    }
                    in 25.0..Double.MAX_VALUE ->{
                        textViewBMI.append("Overweight")
                        imageViewProfile.setImageResource(R.drawable.over)
                    }
                }

            }
        }
        buttonReset.setOnClickListener {
            editTextHeight.setText("")
            editTextWeight.setText("")
            textViewBMI.setText("BMI :")
            imageViewProfile.setImageResource(R.drawable.empty)
        }
    }
}
