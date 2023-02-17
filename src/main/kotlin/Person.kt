import kotlinx.serialization.Serializable

@Serializable
class Person(val name: String, val weight: Int, val color: Color, val country: Country) {
    fun get_name(): String{
        return name
    }
    fun get_weight(): Int{
        return weight
    }

}