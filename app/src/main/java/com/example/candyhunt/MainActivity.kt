package com.example.candyhunt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    // DeclaringTextViews
    lateinit var hpTextView: TextView
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
    var hp = 5


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Finds TextViews in layout
        hpTextView = findViewById(R.id.hpTextView)
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

        hpTextView.text = getString(R.string.hp, hp.toString())

        // Sets the first location in list locations as locationNow and starts locationNow
        locationNow = GameManager.locations[0]
        startNewLocation()
    }

    // Rolls the die and puts the number in the number variable. Prints the number in
    // the numberTextView. Hides the rollDieButton.
    fun rollDie(view: View) {
        number = (1..6).random()
        numberTextView.text = getString(R.string.you_rolled, number.toString())
        rollDieButton.visibility = View.INVISIBLE
        continueButton.visibility = View.VISIBLE
    }

    // Changes the location stored in locationNow according to number rolled. Starts new location.
    fun continueButton(view: View) {
        if (hp == 0) {
            locationNow = GameManager.locations[19]
        } else {
            // Hides the continueButton when clicked, until next location is started
            continueButton.visibility = View.INVISIBLE

            // Stores the input in playerNameEditText in playerName variable
            playerName = playerNameEditText.text.toString()
            playerNameEditText.visibility = View.INVISIBLE

            /*
            resultTextView.visibility = View.INVISIBLE
            */

            // Checks if the size of locationNow's list of alternatives is 1 - if so, that option is the new locationNow
            if (locationNow.alternatives.size == 1) {
                if(locationNow.minusHp) {
                    hp -= 1
                    hpTextView.text = getString(R.string.hp, hp.toString())
                } else if (locationNow == GameManager.locations[10]) {
                    hp += 1
                    hpTextView.text = getString(R.string.hp, hp.toString())
                }
                locationNow = GameManager.locations[alternative1]

                // Checks if the size of locationNow's list of alternatives is 2 - if so, the number decides which
                // option will be the new locationNow
            } else if (locationNow.alternatives.size == 2) {
                if (number == 1 || number == 2 || number == 3) {
                    if(locationNow.minusHp) {
                        hp -= 1
                        hpTextView.text = getString(R.string.hp, hp.toString())
                    }
                    locationNow = GameManager.locations[alternative1]
                } else if (number == 4 || number == 5 || number == 6) {
                    if (locationNow == GameManager.locations[13]) {
                        hp += 1
                        hpTextView.text = getString(R.string.hp, hp.toString())
                    }
                    locationNow = GameManager.locations[alternative2]
                }

                // Checks if the size of locationNow's list of alternatives is 3 - if so, the number decides which
                // option will be the new locationNow
            } else if (locationNow.alternatives.size == 3) {
                if (number == 1 || number == 2) {
                    locationNow = GameManager.locations[alternative1]
                } else if (number == 3 || number == 4) {
                    locationNow = GameManager.locations[alternative2]
                } else if (number == 5 || number == 6) {
                    if (locationNow == GameManager.locations[12]) {
                        hp = 0
                        hpTextView.text = getString(R.string.hp, hp.toString())
                    } else if (locationNow.minusHp) {
                        hp -= 1
                        hpTextView.text = getString(R.string.hp, hp.toString())
                    }
                    locationNow = GameManager.locations[alternative3]
                }
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


        // Checks if hpTextView should be shown, according to showHp variable
        if (locationNow.showHp) {
            hpTextView.visibility = View.VISIBLE
            hpTextView.text = getString(R.string.hp, hp.toString())
        }  else {
            hpTextView.visibility = View.INVISIBLE
        }

        // Finds the alternative locations for the new location
        // If the alternative list size is 1, the rollDieButton is kept invisible, the continueButton is kept visible
        if (locationNow.alternatives.size == 1) {
            continueButton.visibility = View.VISIBLE
            rollDieButton.visibility = View.INVISIBLE
            alternative2TextView.text = ""
            alternative3TextView.text = ""

            //Checks special cases for what will be printed in alternativeTextViews
            if (locationNow == GameManager.locations[17] || locationNow == GameManager.locations[19]) {
                alternative1TextView.text = ""
            } else {
                //If not a special case, alternative1 is the only alternative for new location and is printed as "Next up.."
                alternative1 = locationNow.alternatives[0]
                alternative1TextView.text = getString(R.string.next_up, GameManager.locations[alternative1].title)
            }

        // If the list size is 2, the alternatives are stored in alternative1 and alternative2
        } else if (locationNow.alternatives.size == 2) {
            alternative1 = locationNow.alternatives[0]
            alternative2 = locationNow.alternatives[1]
            alternative3TextView.text = ""

            //Checks special cases for what will be printed in alternativeTextViews
            if (locationNow == GameManager.locations[11]) {
                alternative1TextView.text = getString(R.string.bridge_falls_apart_title)
                alternative2TextView.text = getString(R.string.cross_safely_title)
            } else if (locationNow == GameManager.locations[13]) {
                alternative1TextView.text = getString(R.string.harmful_title)
                alternative2TextView.text = getString(R.string.energizing_title)
            } else if (locationNow == GameManager.locations[14]) {
                alternative1TextView.text = getString(R.string.to_the_candy_title)
                alternative2TextView.text = getString(R.string.clueless_title)
            } else {

                // The alternatives are printed as potential coming up locations depending on what one will roll
                alternative1TextView.text = getString(R.string.roll_1_to_3, GameManager.locations[alternative1].title)
                alternative2TextView.text = getString(R.string.roll_4_to_6, GameManager.locations[alternative2].title)
            }

        // If the list size is 3, the alternatives are stored in alternative1, alternative2 and alternative3 and printed as
        // potential newLocations depending on what one will roll through RollDieButton
        } else if (locationNow.alternatives.size == 3) {
            alternative1 = locationNow.alternatives[0]
            alternative1TextView.text = getString(R.string.roll_1_to_2, GameManager.locations[alternative1].title)
            alternative2 = locationNow.alternatives[1]
            alternative2TextView.text = getString(R.string.roll_3_to_4, GameManager.locations[alternative2].title)
            alternative3 = locationNow.alternatives[2]
            alternative3TextView.text = getString(R.string.roll_5_to_6, GameManager.locations[alternative3].title)
        }
    }
}

// Skicka med playerName till noteFromTheKing och startGame location ?? Funkar om nedan funkar.
// Lägg in strings från string-xml i GameManager

// Fixa texten på Lollipop (9) - vad som händer i de olika alternativen
// Ändra texten från att få välja location i SourSnake(12)

// FIXA HIGHEST ROLL PÅ SWIM FROM START (6)
// FIXA HP PÅ SOUR SNAKE (12) ?

// Go straight to GameOver when HP = 0
// Hide view of "Next up" in kingsCastle(17)