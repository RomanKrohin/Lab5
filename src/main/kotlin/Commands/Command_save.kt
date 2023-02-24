package Commands
import com.charleskorn.kaml.Yaml
import kotlinx.serialization.encodeToString
import java.io.FileOutputStream
import java.io.OutputStreamWriter
import java.io.Writer

class Command_save: Command() {

    //Команда очищает файл и пишет, переводит объекты, сохраненные в коллекции, в строчный формат и записывает их в файл
    override fun _do(collection: Collections.Collection, key: String) {
        //Экспорт пути к файлу
        val outputStream = FileOutputStream(key)
        val writer: Writer = OutputStreamWriter(outputStream)
        //Перевод в текстовый формат
        writer.write(Yaml.default.encodeToString(collection.collection.toMap()))
        writer.close()
    }


}