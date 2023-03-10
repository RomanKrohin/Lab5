package Commands

import Exceptions.CommandException
import StudyGroupInformation.StudyGroup
import com.charleskorn.kaml.Yaml
import kotlinx.serialization.encodeToString

class CommandShow: Command() {
    /**
     * Класс команды, которая выводит объекты, сохраненные в коллекции, в текстовом формате
     */

    //Команда выводит объекты, сохраненные в коллекции, в текстовом формате
    /**
     *  Метод работы команды
     *  @param collection
     *  @param key
     */
    override fun commandDo(collection: Collections.Collection<String, StudyGroup>, key: String) {
        try {
            //Цикл проходит по коллекции
            for (i in collection.collection.values){
                if (i!=null){
                    //Вывод объектов в текстовом формате
                    println(Yaml.default.encodeToString(i))
                    println("----------")
                }
            }
        }
        catch (e: CommandException){
            throw e
        }
    }
}