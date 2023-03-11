package Commands

import Collections.Collection
import Exceptions.CommandException
import StudyGroupInformation.StudyGroup
import WorkModuls.Answer
import WorkModuls.WorkWithAnswer
import com.charleskorn.kaml.Yaml
import kotlinx.serialization.encodeToString

class CommandMaxName(workCollection: Collections.Collection<String, StudyGroup>): Command(), WorkWithAnswer {
    var collection: Collection<String, StudyGroup>
    init {
        collection=workCollection
    }
    /**
     * Класс команды, которая выводит объект, значение поля name которого наибольшее
     */
    //Команда выводит объект, значение поля name которого наибольшее
    /**
     *  Метод работы команды
     *  @param collection
     *  @param key
     */
    override fun commandDo(key: String): Answer {
        try {
            var answer= createReversedAnswer()
            var max_key=""
            var max_name=""
            //Цикл проходит по всей коллекции, сравнивает у объектов поле name с max_name и запоминает ключ объекта с наибольшим значением
            val listOfKeys= collection.collection.keys()
            for (i in listOfKeys){
                if (max_name.hashCode()<collection.collection.get(i)?.getName().hashCode()){
                    max_key=i
                    max_name= collection.collection.get(i)!!.getName()
                }
            }
            answer.setterResult(Yaml.default.encodeToString(collection.collection.get(max_key)))
            return answer
        }
        catch (e: CommandException){
            return createAnswer()
        }
    }

    override fun createAnswer(): Answer {
        return Answer(nameError = "Max_by_name")
    }

    override fun createReversedAnswer(): Answer {
        return Answer(false)
    }

}