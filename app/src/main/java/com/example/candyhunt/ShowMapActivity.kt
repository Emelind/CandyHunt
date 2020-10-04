package com.example.candyhunt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_show_map.*

class ShowMapActivity : AppCompatActivity() {

    lateinit var fullMapImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_map)

        fullMapImageView = findViewById(R.id.fullMapImageView)
        var fab: FloatingActionButton = findViewById(R.id.floatingActionButton)

        fab.setOnClickListener {
            this.finish()
        }
    }
}