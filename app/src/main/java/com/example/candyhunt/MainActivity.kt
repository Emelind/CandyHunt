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

        // Makes the TextViews with alternatives empty for next location, as the number of alternatives differ
        alternative1TextView.text = ""
        alternative2TextView.text = ""
        alternative3TextView.text = ""

        // Checks if the size of locationNow's list of alternatives is 1 - if so, that option is the new locationNow
        if(locationNow.alternatives.size == 1) {
            locationNow = GameManager.locations[alternative1]

        // Checks if the size of locationNow's list of alternatives is 2 - if so, the number decides which
        // option will be the new locationNow
        } else if(locationNow.alternatives.size == 2) {
            if (number == 1 || number == 2 || number == 3) {
                locationNow = GameManager.locations[alternative1]
            } else if (number == 4 || number == 5 || number == 6) {
                locationNow = GameManager.locations[alternative2]
            }

        // Checks if the size of locationNow's list of alternatives is 3 - if so, the number decides which
        // option will be the new locationNow
        } else if(locationNow.alternatives.size == 3) {
            if (number == 1 || number == 2) {
                locationNow = GameManager.locations[alternative1]
            } else if (number == 3 || number == 4) {
                locationNow = GameManager.locations[alternative2]
            } else if(number == 5 || number == 6) {
                locationNow = GameManager.locations[alternative3]
            }
        }

        // Starts the new location
        startNewLocation()

    }

    // Starts the new location
    fun startNewLocation() {

        // Changes the visibility of the rollDieButton and clears the numberTextView
        rollDieButton.visibility = View.VISIBLE
        numberTextView.text = ""

        // Prints the location text and title according to the new location
        mainTextView.text = locationNow.text
        titleTextView.text = locationNow.title

        // Finds the alternative locations for the new location
        // If the alternative list size is 1, the rollDieButton is kept invisible, alternative1 is the
        // only alternative for new location and is printed as "Next up.."
        if(locationNow.alternatives.size == 1) {
            rollDieButton.visibility = View.INVISIBLE
            alternative1 = locationNow.alternatives[0]
            alternative1TextView.text = getString(R.string.next_up, GameManager.locations[alternative1].title)

        // If the list size is 2, the alternatives are stored in alternative1 and alternative2 and printed as
        // potential newLocations depending on what one will roll through RollDieButton
        } else if(locationNow.alternatives.size == 2) {
            alternative1 = locationNow.alternatives[0]
            alternative1TextView.text = getString(R.string.roll_1_to_3, GameManager.locations[alternative1].title)
            alternative2 = locationNow.alternatives[1]
            alternative2TextView.text = getString(R.string.roll_4_to_6, GameManager.locations[alternative2].title)

        // If the list size is 3, the alternatives are stored in alternative1, alternative2 and alternative3 and printed as
        // potential newLocations depending on what one will roll through RollDieButton
        } else if(locationNow.alternatives.size == 3) {
            alternative1 = locationNow.alternatives[0]
            alternative1TextView.text = getString(R.string.roll_1_to_2, GameManager.locations[alternative1].title)
            alternative2 = locationNow.alternatives[1]
            alternative2TextView.text = getString(R.string.roll_3_to_4, GameManager.locations[alternative2].title)
            alternative3 = locationNow.alternatives[2]
            alternative3TextView.text = getString(R.string.roll_5_to_6, GameManager.locations[alternative3].title)
        }
    }

    // EVENTUELLT - lägg till en number = 0 som kan styra om det går att trycka på continue-button eller inte
    // eventuellt lägg till en toaster som ger felmeddelande.
    // Lägg till HP ?
    // Lägg till möjlighet att spela highest roll ?
}