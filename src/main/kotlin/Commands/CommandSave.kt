package Commands

import StudyGroupInformation.StudyGroup
import com.charleskorn.kaml.Yaml
import kotlinx.serialization.encodeToString
import java.io.FileOutputStream
import java.io.OutputStreamWriter
import java.io.Writer

class CommandSave: Command() {

    //Команда очищает файл и пишет, переводит объекты, сохраненные в коллекции, в строчный формат и записывает их в файл
    override fun commandDo(collection: Collections.Collection<String, StudyGroup>, key: String) {
        try {
            //Экспорт пути к файлу
            val outputStream = FileOutputStream(key)
            val writer: Writer = OutputStreamWriter(outputStream)
            //Перевод в текстовый формат
            writer.write(Yaml.default.encodeToString(collection.collection.toMap()))
            writer.close()
        }
        catch (e: Exception){
            println("Command exception")
            e.printStackTrace()
        }
    }

}