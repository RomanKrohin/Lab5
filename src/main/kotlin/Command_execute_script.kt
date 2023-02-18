import java.io.BufferedReader
import java.io.FileReader

class Command_execute_script: Command(_name = "execute_script") {
    override fun _do(collection: Collection) {
    }

    override fun _do(collection: Collection, path: String) {
        val bufferedReader= BufferedReader(FileReader(path))
    }

    override fun _do(collection: Collection, new_id: Int) {
    }
}