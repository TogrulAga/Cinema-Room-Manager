import kotlin.Exception
import kotlin.math.pow

fun calculateBrakingDistance(v1: String, a: String): Int {
    return try {
        val initialSpeed = v1.toDouble()
        val acceleration = a.toInt()

        -initialSpeed.pow(2).toInt() / (2 * acceleration)
    } catch (e: ArithmeticException) {
        println("The car does not slow down!")
        -1
    } catch (e: Exception) {
        println(e.message)
        -1
    }
}