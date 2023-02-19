
import com.charleskorn.kaml.Yaml
import kotlinx.serialization.encodeToString
import java.io.FileOutputStream
import java.io.OutputStreamWriter
import java.io.Writer

class Command_save: Command() {

    override fun _do(collection: Collection, path: String) {
        val outputStream = FileOutputStream(path)
        val writer: Writer = OutputStreamWriter(outputStream)
        writer.write(Yaml.default.encodeToString(collection.collection.toMap()))
        writer.close()
    }


}