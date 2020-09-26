package com.example.candyhunt

object GameManager {
    var locations = mutableListOf<Location>()

    init {
        createLocation()
    }

    fun createLocation() {
        var immigrationForm = Location("Immigration Form", "Immigration Form... text..", listOf(1))
        locations.add(immigrationForm)

        var noteFromTheKing = Location("Note from the King", "Note from the King... text..", listOf(2))
        locations.add(noteFromTheKing)

        var startGame = Location("Start Game", "Start Game... text..", listOf(3))
        locations.add(startGame)

        var startingPoint = Location("Starting Point", "Starting Point... text..", listOf(4, 5))
        locations.add(startingPoint)

        var crossRiver = Location("Cross River", "Cross River... text..", listOf(6, 7))
        locations.add(crossRiver)



    }
}