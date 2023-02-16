import kotlinx.serialization.Serializable

@Serializable
class Person(val name: String, val weight: Int, val _ocation: Location? = null) {
    fun get_name(): String{
        return name
    }
    fun get_weight(): Int{
        return weight
    }
    fun get_location():Location?{
        return _ocation
    }
}