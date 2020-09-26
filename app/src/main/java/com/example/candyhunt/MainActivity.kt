package com.example.candyhunt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}