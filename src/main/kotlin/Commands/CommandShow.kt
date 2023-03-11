package Commands

import Collections.Collection
import Exceptions.CommandException
import StudyGroupInformation.StudyGroup
import WorkModuls.Answer
import com.charleskorn.kaml.Yaml
import kotlinx.serialization.encodeToString

class CommandShow(workCollection: Collections.Collection<String, StudyGroup>): Command() {
    var collection: Collection<String, StudyGroup>
    init {
        collection=workCollection
    }
    /**
     * Класс команды, которая выводит объекты, сохраненные в коллекции, в текстовом формате
     */

    //Команда выводит объекты, сохраненные в коллекции, в текстовом формате
    /**
     *  Метод работы команды
     *  @param collection
     *  @param key
     */
    override fun commandDo(key: String): Answer {
        val answer= Answer()
        try {
            //Цикл проходит по коллекции
            for (i in collection.collection.values){
                if (i!=null){
                    //Вывод объектов в текстовом формате
                    answer.setterResult(answer.getAnswer()+Yaml.default.encodeToString(i)+"\n"+"----------")
                    println(Yaml.default.encodeToString(i))
                }
            }
        }
        catch (e: CommandException){
            throw e
        }
        return answer
    }
}