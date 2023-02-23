package Study_group_information

import Study_group_information.Color
import Study_group_information.Country
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