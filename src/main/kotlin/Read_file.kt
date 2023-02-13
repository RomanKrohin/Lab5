import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException

open class Read_file: Create_choose_command {

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
                    line=bufferedReader.readLine()
                    if ((line!="[") and (line!="]") ){
                        if (line[line.length-1]==','){
                            line= line.subSequence(0, line.length-1).toString()
                        }
                        val studyGroup= Json.decodeFromString<StudyGroup>(line)
                        count_key++
                        studyGroup.set_id(count_key)
                        collection.add(studyGroup, count_key)
                    }
                }
                else{
                    break
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
}