package Commands

import Collections.Collection
import Exceptions.CommandException
import StudyGroupInformation.StudyGroup
import WorkModuls.Answer
import com.charleskorn.kaml.Yaml
import kotlinx.serialization.encodeToString
import java.io.FileOutputStream
import java.io.OutputStreamWriter
import java.io.Writer

class CommandSave(workCollection: Collections.Collection<String, StudyGroup>): Command() {
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
        val answer= Answer()
        try {
            //Экспорт пути к файлу
            val outputStream = FileOutputStream(key)
            val writer: Writer = OutputStreamWriter(outputStream)
            //Перевод в текстовый формат
            writer.write(Yaml.default.encodeToString(collection.collection.toMap()))
            writer.close()
        }
        catch (e: CommandException){
            throw e
        }
        return answer
    }

}