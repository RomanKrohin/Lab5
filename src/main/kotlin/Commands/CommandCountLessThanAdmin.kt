package Commands

import Collections.Collection
import Exceptions.CommandException
import StudyGroupInformation.StudyGroup
import WorkModuls.Answer
import WorkModuls.WorkWithAnswer
import com.charleskorn.kaml.Yaml
import kotlinx.serialization.encodeToString
import java.util.*

class CommandCountLessThanAdmin(workCollection: Collection<String, StudyGroup>): Command(), WorkWithAnswer {
    var collection: Collection<String, StudyGroup>
    init {
        collection=workCollection
    }
    /**
     * Класс команды, которая выводит объекты значение поля group admin меньше чем у заданного
     */

    //Команда, которая выводит объекты значение поля group admin меньше чем у заданного
    /**
     *  Метод работы команды
     *  @param collection
     *  @param key
     */
    override fun commandDo(key: String): Answer {
        try{
            val answer= createReversedAnswer()
            //Цикл проходиться по всей коллекции, сравнивает поля с заданным объектом и выводит которые подходят под условие
            val groupAdminHash: Int = collection.collection.get(key.uppercase(Locale.getDefault()))?.getAdmin()!!.hashCode()
            for (i in collection.collection.values){
                val buf:Int= i.getAdmin().hashCode()
                if (buf<groupAdminHash) {
                    answer.setterResult(answer.getAnswer()+Yaml.default.encodeToString(i))
                }
            }
            return answer
        }
        catch (e: CommandException){
            return createAnswer()
        }
    }

    override fun createAnswer(): Answer {
        return Answer(nameError = "Count less then admin")
    }

    override fun createReversedAnswer(): Answer {
        return Answer(false)
    }

}