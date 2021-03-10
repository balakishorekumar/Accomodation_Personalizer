import kotlin.math.PI
import kotlin.math.sqrt

fun main() {
    val squareCabin = SquareCabin(3, 50.0)
    val roundHut = RoundHut(4, 10.0)
    val roundTower = RoundTower(6, 15.5)

    with(squareCabin) {
        println("\n Square Cabin \n==========")
        println("Capacity: $capacity")
        println("Material: $buildingMaterial")
        println("Has room? ${hasRoom()}")
        println("Floor Area = ${floorArea()}")
        println(getRoom())
    }
    with(roundHut) {
        println("\n Round Hut \n==========")
        println("Capacity: $capacity")
        println("Material: $buildingMaterial")
        println("Has room? ${hasRoom()}")
        println("Floor Area = ${floorArea()}")
        println(getRoom())
        println("Carpet Size = ${calculateMaxCarpetSize()}")

    }

    with(roundTower) {
        println("\n Round Tower \n==========")
        println("Capacity: $capacity")
        println("Material: $buildingMaterial")
        println("Has room? ${hasRoom()}")
        println("Floor Area = ${floorArea()}")
        println(getRoom())
        println("Carpet Size = ${calculateMaxCarpetSize()}")
    }

}

abstract class Dwelling(private var residents: Int) {
    abstract val buildingMaterial: String
    abstract val capacity: Int
    abstract fun floorArea(): Double

    fun hasRoom(): Boolean {
        return residents < capacity
    }

    fun getRoom() {
        if (capacity > residents) {
            residents++
            println("You have got a room \n Total residents are $residents")
        } else println("Sorry, at capacity and no rooms are left")
    }
}

class SquareCabin(residents: Int, private var length: Double) : Dwelling(residents) {
    override val buildingMaterial = "wood"
    override val capacity = 6
    override fun floorArea(): Double {
        return length * length
    }

}

open class RoundHut(residents: Int, private var radius: Double) : Dwelling(residents) {
    override val buildingMaterial = "Straw"
    override val capacity = 4
    override fun floorArea(): Double {
        return radius * radius * PI
    }

    open fun calculateMaxCarpetSize(): Double {
        val diameter = 2 * radius
        return sqrt(diameter * diameter / 2)
    }
}

class RoundTower(residents: Int, radius: Double, private var floors: Int = 2) : RoundHut(residents, radius) {
    override val buildingMaterial = "Stone"
    override val capacity = 4 * floors
    override fun floorArea(): Double {
        return super.floorArea() * floors
    }

    override fun calculateMaxCarpetSize(): Double {
        return super.calculateMaxCarpetSize() * floors
    }


}