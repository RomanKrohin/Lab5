import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException

open class Read_file: Create_choose_command, Create_check_module {

    var path: String = ""

    fun export_file(){
        path =  readln()
    }

    fun read_file(collection: Collection){
        val bufferedReader= BufferedReader(FileReader(path))
        try {
            var line: String=""
            var count_key=0
            while (line!=null){
                if (bufferedReader.ready()){
                    line+=bufferedReader.readLine()
                }
                else{
                    break
                }
            }
            val list =Json.decodeFromString<List<StudyGroup>>(line)
            val check= create_module()
            for (i in 0..list.size-1){
                if (check.check(list[i])){
                    list[i].set_id(++count_key)
                    collection.collection.put(count_key, list[i])
                }
            }
            create_choose_command(collection, count_key)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    override fun create_choose_command(collection: Collection, count_key: Int) {
        val chooseCommand= Choose_command()
        chooseCommand.choose_coomand(collection, count_key)
    }

    override fun create_module(): Check_module {
        return Check_module()
    }
}