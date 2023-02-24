package Commands

import com.charleskorn.kaml.Yaml
import kotlinx.serialization.encodeToString

class Command_count_less_than_admin: Command() {

    //Команда, которая выводит объекты значение поля group admin меньше чем у заданного

    override fun _do(collection: Collections.Collection, key: String) {
        //Цикл проходиться по всей коллекции, сравнивает поля с заданным объектом и выводит которые подходят под условие
        val groupAdminHash: Int = collection.collection.get(key.toUpperCase())?.get_admin()!!.hashCode()
        for (i in collection.collection.keys){
            val buf:Int= collection.collection.get(i)!!.get_admin().hashCode()
            if (buf<groupAdminHash) {
                println(Yaml.default.encodeToString(collection.collection.get(i)))
            }
        }
    }

}