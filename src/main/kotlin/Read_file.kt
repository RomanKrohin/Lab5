
import com.charleskorn.kaml.Yaml
import kotlinx.serialization.decodeFromString
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
                    line+="\n"+bufferedReader.readLine()
                }
                else{
                    break
                }
            }
            val list =Yaml.default.decodeFromString<Map<String, StudyGroup>>(line)
            val list_of_key= list.keys.toList()
            val checkModule= create_module()
            for (i in list_of_key){
                if (checkModule.check(list.get(i))){
                    list.get(i)?.set_id((++count_key).toLong())
                    collection.add(list.get(i)!!, i)
                }
            }
            val check= create_module()
            create_choose_command(collection, list_of_key)
        }
        catch (e: IOException) {
            e.printStackTrace()
        }
    }

    override fun create_choose_command(collection: Collection, list_of_keys: List<String>) {
        val chooseCommand= Choose_command()
        chooseCommand.choose_coomand(collection, list_of_keys)
    }

    override fun create_module(): Check_module {
        return Check_module()
    }
}