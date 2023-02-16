import kotlinx.serialization.Serializable

@Serializable
class Coordinates (private val x: Int, private val y:Int)  {
    fun get_x(): Int{
        return x
    }
    fun get_y(): Int{
        return y
    }
}