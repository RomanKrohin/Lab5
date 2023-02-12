import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException

open class Read_file {

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
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}