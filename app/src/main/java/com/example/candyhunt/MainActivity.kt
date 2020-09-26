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
    var alternative1: Int = -1
    var alternative2: Int = -1
    var alternative3: Int = -1

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
        startNewLocation()

    }

    // Rolls the die and puts the number in the number variable. Prints the number in
    // the numberTextView. Hides the rollDieButton.
    fun rollDie(view: View) {
        number = (1..6).random()
        numberTextView.text = number.toString()
        rollDieButton.visibility = View.INVISIBLE
    }

    // Changes the location stored in locationNow according to number rolled. Starts new location.
    fun continueButton(view: View) {
        // Stores the input in playerNameEditText in playerName variable
        playerName= playerNameEditText.text.toString()
        playerNameEditText.visibility = View.INVISIBLE

        alternative1TextView.text = ""
        alternative2TextView.text = ""
        alternative3TextView.text = ""

        if(locationNow.alternatives.size == 1) {
            locationNow = GameManager.locations[alternative1]
        } else if(locationNow.alternatives.size == 2) {
            if (number == 1 || number == 2 || number == 3) {
                locationNow = GameManager.locations[alternative1]
            } else if (number == 4 || number == 5 || number == 6) {
                locationNow = GameManager.locations[alternative2]
            }
        } else if(locationNow.alternatives.size == 3) {
            if (number == 1 || number == 2) {
                locationNow = GameManager.locations[alternative1]
            } else if (number == 3 || number == 4) {
                locationNow = GameManager.locations[alternative2]
            } else if(number == 5 || number == 6) {
                locationNow = GameManager.locations[alternative3]
            }
        }
        startNewLocation()

    }
    fun startNewLocation() {
        // Changes the visibility of the rollDieButton and clears the numberTextView
        rollDieButton.visibility = View.VISIBLE
        numberTextView.text = ""

        // Prints the location text and title according to the new location
        mainTextView.text = locationNow.text
        titleTextView.text = locationNow.title

        // Finds the alternative locations for the new location
        if(locationNow.alternatives.size == 1) {
            rollDieButton.visibility = View.INVISIBLE
            alternative1 = locationNow.alternatives[0]
            alternative1TextView.text = getString(R.string.next_up, GameManager.locations[alternative1].title)

        } else if(locationNow.alternatives.size == 2) {
            alternative1 = locationNow.alternatives[0]
            alternative1TextView.text = getString(R.string.roll_1_to_3, GameManager.locations[alternative1].title)
            alternative2 = locationNow.alternatives[1]
            alternative2TextView.text = getString(R.string.roll_4_to_6, GameManager.locations[alternative2].title)

        } else if(locationNow.alternatives.size == 3) {
            alternative1 = locationNow.alternatives[0]
            // LÄGG IN SOM OVAN
            alternative2 = locationNow.alternatives[1]
            // LÄGG IN SOM OVAN
            alternative3 = locationNow.alternatives[2]
            // LÄGG IN SOM OVAN
        }
    }
    // EVENTUELLT - lägg till en number = 0 som kan styra om det går att trycka på continue-button eller inte
    // eventuellt lägg till en toaster som ger felmeddelande.
}