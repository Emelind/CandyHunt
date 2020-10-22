package com.example.candyhunt

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

const val EXTRA_MESSAGE = "com.example.candyhunt.MESSAGE"

class MainActivity : AppCompatActivity() {

    // DeclaringTextViews
    private lateinit var hpTextView: TextView
    private lateinit var titleTextView: TextView
    private lateinit var mainTextView: TextView
    private lateinit var alternative1TextView: TextView
    private lateinit var alternative2TextView: TextView
    private lateinit var alternative3TextView: TextView
    private lateinit var playerNameTextView: TextView

    // Declaring EditText
    private lateinit var playerNameEditText: EditText

    // Declaring ImageView
    private lateinit var imageView: ImageView
    private lateinit var rollDieImageView: ImageView
    private lateinit var dieImageView: ImageView

    // Declaring Buttons
    private lateinit var continueButton: Button

    // Declaring other variables
    private var number = 0
    private var playerName = ""
    private lateinit var locationNow: Location
    private lateinit var gameOverLocation: Location
    private var alternative1: Int = -1
    private var alternative2: Int = -1
    private var alternative3: Int = -1
    private var hp = 5

    private lateinit var gameManager: GameManager
    private lateinit var animation: Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gameManager = GameManager(this)

        animation = AnimationUtils.loadAnimation(this, R.anim.shake_anim)

        // Finds the gameOverLocation based on var gameOverLocation in Location
        for(location in gameManager.locations) {
            if(location.gameOverLocation) {
                gameOverLocation = location
            }
        }

        // Finds TextViews in layout
        hpTextView = findViewById(R.id.hpTextView)
        mainTextView = findViewById(R.id.mainTextView)
        titleTextView = findViewById(R.id.titleTextView)
        alternative1TextView = findViewById(R.id.alternative1TextView)
        alternative2TextView = findViewById(R.id.alternative2TextView)
        alternative3TextView = findViewById(R.id.alternative3TextView)
        playerNameTextView = findViewById(R.id.playerNameTextView)

        // Finds EditText in layout
        playerNameEditText = findViewById(R.id.playerNameEditText)

        // Finds ImageView in layout
        imageView = findViewById(R.id.imageView)
        rollDieImageView = findViewById(R.id.rollDieImageView)
        dieImageView = findViewById(R.id.dieImageView)

        // Finds Buttons in layout
        continueButton = findViewById(R.id.continueButton)

        hpTextView.text = getString(R.string.hp, hp.toString())

        // Sets the first location in list locations as locationNow and starts locationNow
        locationNow = gameManager.locations[0]
        startNewLocation()
    }

    // Rolls the die and puts the number in the number variable. Starts animation fun.
    fun rollDie(view: View) {
        number = (1..6).random()
        animation()
    }

    private fun animation() {
        rollDieImageView.startAnimation(animation)

        animation.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationRepeat(animation: Animation?) {
            }

            override fun onAnimationEnd(animation: Animation?) {

                when(number) {
                    1 -> dieImageView.setImageResource(R.drawable.one_die)
                    2 -> dieImageView.setImageResource(R.drawable.two_die)
                    3 -> dieImageView.setImageResource(R.drawable.three_die)
                    4 -> dieImageView.setImageResource(R.drawable.four_die)
                    5 -> dieImageView.setImageResource(R.drawable.five_die)
                    6 -> dieImageView.setImageResource(R.drawable.six_die)
                }
                rollDieImageView.visibility = View.INVISIBLE
                dieImageView.visibility = View.VISIBLE
                continueButton.visibility = View.VISIBLE
                frameNextLocation()
            }

            override fun onAnimationStart(animation: Animation?) {
            }
        })
    }

    // Changes the location stored in locationNow according to number rolled. Starts new location.
    fun continueButton(view: View) {
        //If the location is an endLocation, the function of the continueButton starts over the MainActivity
        if(locationNow.endLocation) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        } else {
            if (hp == 0) {
                locationNow = gameOverLocation
            } else {
                // Hides the continueButton when clicked, until next location is started
                continueButton.visibility = View.INVISIBLE

                // Stores the input in playerNameEditText in playerName variable
                playerName = playerNameEditText.text.toString()
                playerNameEditText.visibility = View.INVISIBLE

                // Checks if the size of locationNow's list of alternatives is 1 - if so, that option is the new locationNow
                if (locationNow.alternatives.size == 1) {
                    if (locationNow.minusHp) {
                        hp -= 1
                        hpTextView.text = getString(R.string.hp, hp.toString())
                    } else if (locationNow.plusHp) {
                        hp += 1
                        hpTextView.text = getString(R.string.hp, hp.toString())
                    }
                    if (hp == 0) {
                        locationNow = gameOverLocation
                    } else {
                        locationNow = gameManager.locations[alternative1]
                    }

                    // Checks if the size of locationNow's list of alternatives is 2 - if so, the number decides which
                    // option will be the new locationNow
                } else if (locationNow.alternatives.size == 2) {

                    if (number == 1 || number == 2 || number == 3) {
                        if (locationNow.minusHp) {
                            hp -= 1
                            hpTextView.text = getString(R.string.hp, hp.toString())
                        }
                        if (hp == 0) {
                            locationNow = gameOverLocation
                        } else {
                            locationNow = gameManager.locations[alternative1]
                        }
                    } else if (number == 4 || number == 5 || number == 6) {
                        if (locationNow.plusHp) {
                            hp += 1
                            hpTextView.text = getString(R.string.hp, hp.toString())
                        }
                        locationNow = gameManager.locations[alternative2]
                    }

                    // Checks if the size of locationNow's list of alternatives is 3 - if so, the number decides which
                    // option will be the new locationNow
                } else if (locationNow.alternatives.size == 3) {

                    if (number == 1 || number == 2) {
                        locationNow = gameManager.locations[alternative1]
                    } else if (number == 3 || number == 4) {
                        locationNow = gameManager.locations[alternative2]
                    } else if (number == 5 || number == 6) {
                        if (locationNow.zeroHp) {
                            hp = 0
                            hpTextView.text = getString(R.string.hp, hp.toString())
                        } else if (locationNow.minusHp) {
                            hp -= 1
                            hpTextView.text = getString(R.string.hp, hp.toString())
                        }
                        if (hp == 0) {
                            locationNow = gameOverLocation
                        } else {
                            locationNow = gameManager.locations[alternative3]
                        }
                    }
                }
            }
            // Starts the new location
            startNewLocation()
        }
    }

    // Starts the new location
    @SuppressLint("SetTextI18n")
    private fun startNewLocation() {

        // Changes the visibility of the rollDieButton and clears the numberTextView
        rollDieImageView.visibility = View.VISIBLE
        dieImageView.visibility = View.INVISIBLE

        // Prints the location text and title according to the new location
        mainTextView.text = locationNow.text
        titleTextView.text = locationNow.title

        // Prints the playerName in playerNameTextView + greeting if showNameTextView in location == true
        if(locationNow.showNameTextView){
            playerNameTextView.visibility = View.VISIBLE
            playerNameTextView.text = locationNow.nameText + playerName + ","
        } else {
            playerNameTextView.visibility = View.INVISIBLE
        }

        // Set the image from locationNow in imageView
        imageView.setImageDrawable(locationNow.image)
        imageView.setOnClickListener {
            val intent = Intent(this, ShowMapActivity::class.java).apply {
                putExtra(EXTRA_MESSAGE, locationNow.id.toString())
            }
            startActivity(intent)
        }

        // Checks if hpTextView should be shown, according to showHp variable in locationNow
        if (locationNow.showHp) {
            hpTextView.visibility = View.VISIBLE
            hpTextView.text = getString(R.string.hp, hp.toString())
            setHpTextColor()
        }  else {
            hpTextView.visibility = View.INVISIBLE
        }

        // Changes text of continueButton if the location is endLocation == true
        if(locationNow.endLocation) {
            continueButton.text = getString(R.string.try_again_button)
        }

        // Removes frames around alternativeTextViews
        alternative1TextView.setBackground(null)
        alternative2TextView.setBackground(null)
        alternative3TextView.setBackground(null)

        // Finds the alternative locations for the new location
        // If the alternative list size is 1, the rollDieButton is kept invisible, the continueButton is kept visible
        if (locationNow.alternatives.size == 1) {
            continueButton.visibility = View.VISIBLE
            rollDieImageView.visibility = View.INVISIBLE
            alternative2TextView.text = ""
            alternative3TextView.text = ""

            //Checks special cases for what will be printed in alternativeTextViews
            if (locationNow.alternativeAlternativeTexts) {
                alternative1TextView.text = locationNow.alternativeAlternative1
            } else {
                //If not a special case, alternative1 is the only alternative for new location and is printed as "Next up.."
                alternative1 = locationNow.alternatives[0]
                alternative1TextView.text = getString(R.string.next_up, gameManager.locations[alternative1].title)
            }

        // If the list size is 2, the alternatives are stored in alternative1 and alternative2
        } else if (locationNow.alternatives.size == 2) {
            alternative1 = locationNow.alternatives[0]
            alternative2 = locationNow.alternatives[1]
            alternative3TextView.text = ""

            //Checks special cases for what will be printed in alternativeTextViews
            if(locationNow.alternativeAlternativeTexts) {
                alternative1TextView.text = locationNow.alternativeAlternative1
                alternative2TextView.text = locationNow.alternativeAlternative2
            }  else {
                // The alternatives are printed as potential coming up locations depending on what one will roll
                alternative1TextView.text = getString(R.string.roll_1_to_3, gameManager.locations[alternative1].title)
                alternative2TextView.text = getString(R.string.roll_4_to_6, gameManager.locations[alternative2].title)
            }

        // If the list size is 3, the alternatives are stored in alternative1, alternative2 and alternative3 and printed as
        // potential newLocations depending on what one will roll through RollDieButton
        } else if (locationNow.alternatives.size == 3) {
            alternative1 = locationNow.alternatives[0]
            alternative1TextView.text = getString(R.string.roll_1_to_2, gameManager.locations[alternative1].title)
            alternative2 = locationNow.alternatives[1]
            alternative2TextView.text = getString(R.string.roll_3_to_4, gameManager.locations[alternative2].title)
            alternative3 = locationNow.alternatives[2]
            alternative3TextView.text = getString(R.string.roll_5_to_6, gameManager.locations[alternative3].title)
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun frameNextLocation() {
        if(locationNow.alternatives.size == 1) {
            alternative1TextView.setBackground(getDrawable(R.drawable.frame_layout))

        } else if(locationNow.alternatives.size == 2) {

            if(number == 1 || number == 2 || number == 3) {
                alternative1TextView.setBackground(getDrawable(R.drawable.frame_layout))
            } else if(number == 4 || number == 5 || number == 6) {
                alternative2TextView.setBackground(getDrawable(R.drawable.frame_layout))
            }

        } else if(locationNow.alternatives.size == 3) {

            if(number == 1 || number == 2) {
                alternative1TextView.setBackground(getDrawable(R.drawable.frame_layout))
            } else if(number == 3 || number == 4) {
                alternative2TextView.setBackground(getDrawable(R.drawable.frame_layout))
            } else if(number == 5 || number == 6) {
                alternative3TextView.setBackground(getDrawable(R.drawable.frame_layout))
            }
        }
    }
    private fun setHpTextColor() {
        if (hp < 3) {
            hpTextView.setTextColor(Color.parseColor("#DF0404"))
        } else {
            hpTextView.setTextColor(Color.parseColor("#000000"))
            //hpTextView.setTextColor(Color.parseColor("#519657"))
        }
    }
}