package com.example.candyhunt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_show_map.*

class ShowMapActivity : AppCompatActivity() {

    lateinit var fullMapImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_map)

        val locationNowId = intent.getStringExtra(EXTRA_MESSAGE)

        fullMapImageView = findViewById(R.id.fullMapImageView)

        when(locationNowId) {
            "0" -> fullMapImageView.setImageResource(R.drawable.map_starting_point)
            "1" -> fullMapImageView.setImageResource(R.drawable.map_starting_point)
            "2" -> fullMapImageView.setImageResource(R.drawable.map_starting_point)
            "3" -> fullMapImageView.setImageResource(R.drawable.map_starting_point)
            "4" -> fullMapImageView.setImageResource(R.drawable.map_cross_river)
            "5" -> fullMapImageView.setImageResource(R.drawable.map_walk_to_mountain)
            "6" -> fullMapImageView.setImageResource(R.drawable.map_swim_from_start)
            "7" -> fullMapImageView.setImageResource(R.drawable.map_try_boat)
            "8" -> fullMapImageView.setImageResource(R.drawable.map_chocolate_mountain)
            "9" -> fullMapImageView.setImageResource(R.drawable.map_lollipop_forest)
            "10" -> fullMapImageView.setImageResource(R.drawable.map_swim_from_mountain)
            "11" -> fullMapImageView.setImageResource(R.drawable.map_cross_cracker_bridge)
            "12" -> fullMapImageView.setImageResource(R.drawable.map_sour_snake_pit)
            "13" -> fullMapImageView.setImageResource(R.drawable.map_caramel_lake)
            "14" -> fullMapImageView.setImageResource(R.drawable.map_wicked_witch)
            "15" -> fullMapImageView.setImageResource(R.drawable.map_hubba_bubba_hill)
            "16" -> fullMapImageView.setImageResource(R.drawable.map_fanta_fields)
            "17" -> fullMapImageView.setImageResource(R.drawable.map_castle_of_the_king)
            "18" -> fullMapImageView.setImageResource(R.drawable.map_cotton_candy_cave)
            "19" -> fullMapImageView.setImageResource(R.drawable.map_candy_land)
        }

        var fab: FloatingActionButton = findViewById(R.id.floatingActionButton)

        fab.setOnClickListener {
            this.finish()
        }
    }
}