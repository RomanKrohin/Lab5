package Commands

import com.charleskorn.kaml.Yaml
import kotlinx.serialization.encodeToString

class Command_max_name: Command() {

    //Команда выводит объект, значение поля name которого наибольшее
    override fun _do(collection: Collections.Collection, key: String) {
        var max_key=""
        var max_name=""
        //Цикл проходит по всей коллекции, сравнивает у объектов поле name с max_name и запоминает ключ объекта с наибольшим значением
        for (i in collection.collection.keys){
            if (max_name.hashCode()<collection.collection.get(i).hashCode()){
                max_key=i
                max_name= collection.collection.get(i)!!.get_name()
            }
        }
        println(Yaml.default.encodeToString(collection.collection.get(max_key)))
    }

}