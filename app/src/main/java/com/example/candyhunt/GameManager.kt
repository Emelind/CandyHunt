package com.example.candyhunt

import android.content.Context

class GameManager(val context: Context) {
    var locations = mutableListOf<Location>()

    init {
        createLocation()
    }

    fun createLocation() {
        var immigrationForm = Location(0, context.getString(R.string.immigration_form_title), context.getString(R.string.immigration_form_text),  false, false,  false,false, false, "" ,"", listOf(1))
        locations.add(immigrationForm)

        var noteFromTheKing = Location(1, context.getString(R.string.note_from_the_king_title), context.getString(R.string.note_from_the_king_text), false, false, false, false, false, "", "", listOf(2))
        locations.add(noteFromTheKing)

        var startGame = Location(2, context.getString(R.string.start_game_title), context.getString(R.string.start_game_text), false, false, false, false, false, "", "", listOf(3))
        locations.add(startGame)

        var startingPoint = Location(3, context.getString(R.string.starting_point_title), context.getString(R.string.starting_point_text), false, false, false, true, false, "", "", listOf(4, 5))
        locations.add(startingPoint)

        var crossRiver = Location(4, context.getString(R.string.cross_river_title), context.getString(R.string.cross_river_text), false, false, false, true, false, "", "", listOf(6, 7))
        locations.add(crossRiver)

        var walkToTheMountain = Location(5, context.getString(R.string.walk_to_the_mountain_title), context.getString(R.string.walk_to_the_mountain_text), true, false, false, true, false, "", "", listOf(4, 8))
        locations.add(walkToTheMountain)

        var swimFromStart = Location(6, context.getString(R.string.swim_from_start_title), context.getString(R.string.swim_from_start_text), false, false, false,true, false, "", "",listOf(9))
        locations.add(swimFromStart)

        var tryTheBoat = Location(7, context.getString(R.string.try_the_boat_title), context.getString(R.string.try_the_boat_text), true, false, false,true, false, "", "", listOf(8))
        locations.add(tryTheBoat)

        var chocolateMountain = Location(8, context.getString(R.string.chocolate_mountain_title), context.getString(R.string.chocolate_mountain_text), true, false, false,true, false, "", "", listOf(10, 11))
        locations.add(chocolateMountain)

        var lollipopForest = Location(9, context.getString(R.string.lollipop_forest_title), context.getString(R.string.lollipop_forest_text), true, false, false,true, false, "", "", listOf(13, 14))
        locations.add(lollipopForest)

        var swimFromTheMountain = Location(10, context.getString(R.string.swim_from_the_mountain_title), context.getString(R.string.swim_from_the_mountain_text), false, true, false,true, false, "", "", listOf(12))
        locations.add(swimFromTheMountain)

        var crossCrackerBridge = Location(11, context.getString(R.string.cross_cracker_bridge_title), context.getString(R.string.cross_cracker_bridge_text), true, false, false,true, true, context.getString(R.string.bridge_falls_apart_title), context.getString(R.string.cross_safely_title), listOf(12, 13))
        locations.add(crossCrackerBridge)

        var sourSnakePit = Location(12, context.getString(R.string.sour_snake_pit_title), context.getString(R.string.sour_snake_pit_text), false, false, true,true, false, "", "", listOf(15, 15, 19))
        locations.add(sourSnakePit)

        var caramelLake = Location(13, context.getString(R.string.caramel_lake_title), context.getString(R.string.caramel_lake_text), true, true, false,true, true, context.getString(R.string.harmful_title), context.getString(R.string.energizing_title), listOf(12, 9))
        locations.add(caramelLake)

        var houseOfTheWickedWitch = Location(14, context.getString(R.string.house_of_the_wicked_witch_title), context.getString(R.string.house_of_the_wicked_witch_text), false, false, false,true, true, context.getString(R.string.to_the_candy_title), context.getString(R.string.clueless_title), listOf(17, 12))
        locations.add(houseOfTheWickedWitch)

        var hubbaBubbaHill = Location(15, context.getString(R.string.hubba_bubba_hill_title), context.getString(R.string.hubba_bubba_hill_text), true, false, false,true, false, "", "", listOf(16, 14, 18))
        locations.add(hubbaBubbaHill)

        var fantaFields = Location(16, context.getString(R.string.fanta_fields_title), context.getString(R.string.fanta_fields_text), false, false, false,true, false, "", "", listOf(17))
        locations.add(fantaFields)

        var castleOfTheKing = Location(17, context.getString(R.string.castle_of_the_king_title), context.getString(R.string.castle_of_the_king_text), false, false, false,false, false, "", "", listOf(17))
        locations.add(castleOfTheKing)

        var cottonCandyCave = Location(18, context.getString(R.string.cotton_candy_cave_title), context.getString(R.string.cotton_candy_cave_text), false, false, false,true, false, "", "", listOf(9))
        locations.add(cottonCandyCave)

        var gameOver = Location(19, context.getString(R.string.game_over_title), context.getString(R.string.game_over_text), false, false, false,false, false, "", "", listOf(19))
        locations.add(gameOver)

    }
}