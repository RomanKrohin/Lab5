import kotlinx.serialization.Serializable

@Serializable
class Location (private val x: Double, private val y: Double, private val z:Double,private val name:String? = null){
    fun get_x(): Double{
        return x
    }
    fun get_y(): Double{
        return y
    }
    fun get_z(): Double{
        return z
    }
    fun get_name(): String?{
        return name
    }
}