package com.example.candyhunt

object GameManager {
    var locations = mutableListOf<Location>()

    init {
        createLocation()
    }

    fun createLocation() {
        var immigrationForm = Location(0, "Immigration Form", "Enter Your Name:", listOf(1))
        locations.add(immigrationForm)

        var noteFromTheKing = Location(1, "Note from the King", "Dear , Good thing you are here. Someone has stolen all of our candy! Can you help us to find it? We do not have much for weapons, but you will get one die to guide you on the candy hunt.", listOf(2))
        locations.add(noteFromTheKing)

        var startGame = Location(2, "Start Game", "Thank you, . You will start with 5 HP. Game Over when HP = 0. Let the candy hunt begin. Best of luck! /The Candy King", listOf(3))
        locations.add(startGame)

        var startingPoint = Location(3, "Starting Point", "You cannot decide whether to cross the river of if to walk towards the mountain. Let the die decide.", listOf(4, 5))
        locations.add(startingPoint)

        var crossRiver = Location(4, "Cross River", "There is a boat by the river but you do not know if it is working properly. Should you take a chance and try the boat or swim across across the river?", listOf(6, 7))
        locations.add(crossRiver)

        var walkToTheMountain = Location(5, "Walk to the Mountain", "You twisted your ankle on the way to the mountain :( Roll the die to see if you have to go back and try the river instead, or if you can continue to the mountain.", listOf(3, 8))
        locations.add(walkToTheMountain)

        var swimFromStart = Location(6, "Swim from Start", "You are swimming across the river and meet a competitive fish. The fish wants to play \"Highest Roll\" and you agree. You will lose 1 HP if you roll lower than, or the same number as the fish. The fish has no hands so you will roll for him too.", listOf(9))
        locations.add(swimFromStart)

        var tryTheBoat = Location(7, "Try the Boat", "You are on the boat but it turns out you cannot steer it. The boat takes you down the stream but crashes into a rock! Luckily, you are close to the shore and can swim to safety on land.", listOf(8))
        locations.add(tryTheBoat)

        var chocolateMountain = Location(8, "Chocolate Mountain", "You have been walking up and down the mountain but found no candy. You have spotted the House of the Wicked Witch from the top and plan to go there. To get closer you have to cross the river. Should you use the Cracker Bridge or swim across? Let the die decide!", listOf(10, 11))
        locations.add(chocolateMountain)

        var lollipopForest = Location(9, "Lollipop Forest", "You are walking around in Lollipop Forest looking for candy. An angry unicorn attacks! Roll higher than 3 to avoid the attack. If you roll 3 or less, -1 HP.", listOf(13, 14))
        locations.add(lollipopForest)

        var swimFromTheMountain = Location(10, "Swim from the Mountain", "You are swimming across the river. You take a sip and it turns out that the river is made of soda - energy boost + 1 HP.", listOf(12))
        locations.add(swimFromTheMountain)

        var crossCrackerBridge = Location(11, "Cross Cracker Bridge", "You are slowly crossing the Cracker Bridge. It makes funny noises and is feeling a bit wobbly.\\n\\nThe die decides if the bridge falls apart or not. If the bridge holds, you will reach Caramel Lake. If not, you will fall into the river (-1 HP) and will have to follow the stream to the Sour Snake Pit.", listOf(12, 13))
        locations.add(crossCrackerBridge)

        var sourSnakePit = Location(12, "Sour Snake Pit", "You have reached the Sour Snake Pit. The snakes are gamblers and want to eat you. They will let your die decide if they are going to eat you or let you go. If you roll a 4, they will eat you and you will lose all of your HP - Game Over. If you roll 1, 2, 3, 5 or 6, you are free to leave and can go to Hubba Bubba Hill or Fanta Fields.", listOf(15, 16))
        locations.add(sourSnakePit)

        var caramelLake = Location(13, "Caramel Lake", "You are looking out over Caramel Lake and it looks so yummy. The Wicked Witch has put a spell on the lake, making every second sip harmful. The die decides if you take a harmful sip (-1 HP), or an energizing sip (+1 HP). If you take a harmful sip, you will wobble to the Sour Snake Pit. If the sip is energizing, you will run to Lollipop Forest.", listOf(12, 9))
        locations.add(caramelLake)

        var houseOfTheWickedWitch = Location(14, "House of the Wicked Witch", "You have arrived at the House of the Wicked Witch. You thought the candy would be here, but it is not.. The witch knows where the candy is but cannot decide whether to tell you or not. The witch lets the die decide if to send you to the candy, or let you walk away clueless.", listOf(16, 17))
        locations.add(houseOfTheWickedWitch)

        var hubbaBubbaHill = Location(15, "Hubba Bubba Hill", "You are standing at the top of Hubba Bubba Hill but no candy as far as the eye can see. From the top of the hill, you see all the way to the House of the Wicked Witch and the Fanta Fields. Let the die decide where to go next.", listOf(18, 14, 16))
        locations.add(hubbaBubbaHill)

        var fantaFields = Location(16, "Fanta Fields", "You are strolling across the Fanta Fields, just looking around and enjoying the nice and sunny weather. From a distance, you can see the Castle of the King and decide to head there to tell the King that you will stop looking for the candy. It is nowhere to be found..", listOf(17))
        locations.add(fantaFields)

        var castleOfTheKing = Location(17, "Castle of the King", "You have reached the Castle of the King. But wait.. What is this? The castle is overflowing from candy of all sorts.. Turns out that the King has been hiding the candy all along to improve the health of the residents in Candy Land. In exchange for your silence, you get all the candy that you want. Congratulations, you solved the mystery of the stolen candy!", listOf(17))
        locations.add(castleOfTheKing)

        var cottonCandyCave = Location(18, "Cotton Candy Cave", "Ouch, you fell into the Cotton Candy Cave. You are hurting from the fall but can still walk. After hours in the dark, you find your way out of the cave.. Turns out you have reached Lollipop Forest.", listOf(9))
        locations.add(cottonCandyCave)

        var gameOver = Location(19, "Game Over", "Oh no! You are out of HP. Game Over!", listOf(19))
        locations.add(gameOver)

    }
}