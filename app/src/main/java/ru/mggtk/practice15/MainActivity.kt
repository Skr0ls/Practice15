package ru.mggtk.practice15

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun sendData(view: View) {
        val raceText: EditText = findViewById(R.id.editTextText)
        val ageText: EditText = findViewById(R.id.editTextDate)
        if(raceText.text.toString() == ""){
            Toast.makeText(this,"Введите породу!",Toast.LENGTH_SHORT).show()
            raceText.requestFocus()
        }

        else if(ageText.text.toString() == ""){
            Toast.makeText(this,"Введите дату рождения вашего питомца!",Toast.LENGTH_SHORT).show()
            ageText.requestFocus()
        }

        else{
            val race = raceText.text.toString()
            val age: List<String> = ageText.text.toString().split(".")

            val month = age[1]
            val year = age[2]

            val animal: Animal = Animal(race, month, year)

            val intent: Intent = Intent(this@MainActivity,secondActivity::class.java)
            intent.putExtra(animal.javaClass.simpleName, animal)
            startActivity(intent)
        }






        /*val print: TextView = findViewById(R.id.textView5)

        print.text = age[0] + "." + age[1]*/


    }
}