package com.example.candyhunt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    // DeclaringTextViews
    lateinit var titleTextView: TextView
    lateinit var mainTextView: TextView
    lateinit var numberTextView: TextView
    lateinit var alternative1TextView: TextView
    lateinit var alternative2TextView: TextView
    lateinit var alternative3TextView: TextView

    // Declaring EditText
    lateinit var playerNameEditText: EditText

    // Declaring Buttons
    lateinit var continueButton: Button
    lateinit var rollDieButton: Button

    // Declaring other variables
    var number = 0
    var playerName = ""
    lateinit var locationNow: Location

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Finds TextViews in layout
        mainTextView = findViewById(R.id.mainTextView)
        numberTextView = findViewById(R.id.numberTextView)
        titleTextView = findViewById(R.id.titleTextView)
        alternative1TextView = findViewById(R.id.alternative1TextView)
        alternative2TextView = findViewById(R.id.alternative2TextView)
        alternative3TextView = findViewById(R.id.alternative3TextView)

        // Finds EditText in layout
        playerNameEditText = findViewById(R.id.playerNameEditText)

        // Finds Buttons in layout
        rollDieButton = findViewById(R.id.rollDieButton)
        continueButton = findViewById(R.id.continueButton)

        locationNow = GameManager.locations[0]



    }
    // Rolls the die and puts the number in the number variable. Prints the number in
    // the numberTextView. Hides the rollDieButton.
    fun rollDie(view: View) {
        number = (1..6).random()
        numberTextView.text = number.toString()
        // rollDieButton.visibility = View.INVISIBLE
    }
    fun continueButton(view: View) {
        // Stores the input in playerNameEditText in playerName variable
        playerName= playerNameEditText.text.toString()
        playerNameEditText.visibility = View.INVISIBLE
    }


}