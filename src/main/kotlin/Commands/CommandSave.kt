package Commands

import Collections.Collection
import StudyGroupInformation.StudyGroup
import WorkModuls.Answer
import WorkModuls.WorkWithAnswer
import com.charleskorn.kaml.Yaml
import kotlinx.serialization.encodeToString
import java.io.FileOutputStream
import java.io.OutputStreamWriter
import java.io.Writer

class CommandSave(workCollection: Collections.Collection<String, StudyGroup>): Command(), WorkWithAnswer {
    var collection: Collection<String, StudyGroup>
    init {
        collection=workCollection
    }
    /**
     * Класс команды, которая очищает файл и пишет, переводит объекты, сохраненные в коллекции, в строчный формат и записывает их в файл
     */
    //Команда очищает файл и пишет, переводит объекты, сохраненные в коллекции, в строчный формат и записывает их в файл
    /**
     *  Метод работы команды
     *  @param collection
     *  @param key
     */
    override fun commandDo(key: String): Answer {
        try {
            val answer= createReversedAnswer()
            //Экспорт пути к файлу
            val outputStream = FileOutputStream(key)
            val writer: Writer = OutputStreamWriter(outputStream)
            //Перевод в текстовый формат
            writer.write(Yaml.default.encodeToString(collection.collection.toMap()))
            writer.close()
            return answer
        }
        catch (e: Exception){
            return createAnswer()
        }
    }

    override fun createAnswer(): Answer {
        return Answer(nameError = "Save")
    }

    override fun createReversedAnswer(): Answer {
        return Answer(false)
    }

}