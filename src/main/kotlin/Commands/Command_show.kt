package Commands

import com.charleskorn.kaml.Yaml
import kotlinx.serialization.encodeToString

class Command_show: Command() {

    //Команда выводит объекты, сохраненные в коллекции, в текстовом формате
    override fun _do(collection: Collections.Collection, key: String) {
        //Цикл проходит по коллекции
        for (i in collection.collection.keys){
            if (collection.collection.get(i)!=null){
                //Вывод объектов в текстовом формате
                println(Yaml.default.encodeToString(collection.collection.get(i)))
                println("----------")
            }
        }
    }
}