package Commands

import Collections.Collection
import StudyGroupInformation.StudyGroup
import WorkModuls.Answer
import WorkModuls.WorkWithAnswer
import com.charleskorn.kaml.Yaml
import kotlinx.serialization.encodeToString

class CommandShow(workCollection: Collections.Collection<String, StudyGroup>): Command(), WorkWithAnswer {
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
        try {
            val answer= createReversedAnswer()
            //Цикл проходит по коллекции
            for (i in collection.collection.values){
                if (i!=null){
                    //Вывод объектов в текстовом формате
                    answer.setterResult(answer.getAnswer()+Yaml.default.encodeToString(i)+"\n----------\n")
                }
            }
            return answer
        }
        catch (e: Exception){
            return createAnswer()
        }
    }

    override fun createAnswer(): Answer {
        return Answer(nameError = "Show")
    }

    override fun createReversedAnswer(): Answer {
        return Answer(false)
    }
}