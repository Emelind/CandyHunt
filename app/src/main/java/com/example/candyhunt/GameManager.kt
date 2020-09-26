package com.example.candyhunt

object GameManager {
    var locations = mutableListOf<Location>()

    init {
        createLocation()
    }

    fun createLocation() {
        var immigrationForm = Location(0, "Immigration Form", "Immigration Form... text..", listOf(1))
        locations.add(immigrationForm)

        var noteFromTheKing = Location(1, "Note from the King", "Note from the King... text..", listOf(2))
        locations.add(noteFromTheKing)

        var startGame = Location(2, "Start Game", "Start Game... text..", listOf(3))
        locations.add(startGame)

        var startingPoint = Location(3, "Starting Point", "Starting Point... text..", listOf(4, 5))
        locations.add(startingPoint)

        var crossRiver = Location(4, "Cross River", "Cross River... text..", listOf(6, 7))
        locations.add(crossRiver)

        var walkToTheMountain = Location(5, "Walk to the Mountain", "Walk to the Mountain... text..", listOf(3, 8))
        locations.add(walkToTheMountain)

        var swimFromStart = Location(6, "Swim from Start", "Swim from Start... text..", listOf(9))
        locations.add(swimFromStart)

        var tryTheBoat = Location(7, "Try the Boat", "Try the Boat... text..", listOf(8))
        locations.add(tryTheBoat)

        var chocolateMountain = Location(8, "Chocolate Mountain", "Chocolate Mountain... text..", listOf(10, 11))
        locations.add(chocolateMountain)

        var lollipopForest = Location(9, "Lollipop Forest", "Lollipop Forest... text..", listOf(13, 14))
        locations.add(lollipopForest)

        var swimFromTheMountain = Location(10, "Swim from the Mountain", "Swim from the Mountain... text..", listOf(12))
        locations.add(swimFromTheMountain)

        var crossCrackerBridge = Location(11, "Cross Cracker Bridge", "Cross Cracker Bridge... text..", listOf(12, 13))
        locations.add(crossCrackerBridge)

        var sourSnakePit = Location(12, "Sour Snake Pit", "Sour Snake Pit... text..", listOf(15, 16))
        locations.add(sourSnakePit)

        var caramelLake = Location(13, "Caramel Lake", "Caramel Lake... text..", listOf(12, 9))
        locations.add(caramelLake)

        var houseOfTheWickedWitch = Location(14, "House of the Wicked Witch", "House of the Wicked Witch... text..", listOf(16, 17))
        locations.add(houseOfTheWickedWitch)

        var hubbaBubbaHill = Location(15, "Hubba Bubba Hill", "Hubba Bubba Hill... text..", listOf(18, 14, 16))
        locations.add(hubbaBubbaHill)

        var fantaFields = Location(16, "Fanta Fields", "Fanta Fields... text..", listOf(17))
        locations.add(fantaFields)

        var castleOfTheKing = Location(17, "Castle of the King", "Castle of the King... text..", listOf(19))
        locations.add(castleOfTheKing)

        var cottonCandyCave = Location(18, "Cotton Candy Cave", "Cotton Candy Cave... text..", listOf(9))
        locations.add(cottonCandyCave)

        var gameOver = Location(19, "Game Over", "Game Over... text..", listOf(19))
        locations.add(gameOver)
    }
}