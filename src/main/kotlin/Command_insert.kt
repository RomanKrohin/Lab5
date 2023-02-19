import com.charleskorn.kaml.Yaml
import kotlinx.serialization.decodeFromString

class Command_insert: Command(), Actions_with_collection, Create_check_module{

    override fun _do(collection: Collection, key: String) {
        var line: String=""
        if (!(collection.collection.keys.contains(key.toUpperCase()))){
            println("Enter name")
            line+="    name: "+"\""+ readln()+"\"\n"
            println("Enter coordinate x")
            line+="    coordinates:\n"+"       x: "+ readln()+"\n"
            println("Enter coordinate y")
            line+="       y: "+ readln()+"\n"
            println("Enter student count")
            line+="    studentCount: "+ readln()+"\n"
            println("Enter should be expelled")
            line+="    shouldBeExpelled: "+ readln()+"\n"
            println("Enter average mark")
            line+="    averageMark: "+ readln()+"\n"
            println("If you want write form of education print: y")
            val answer: String= readln()
            if (answer.equals("y")){
                println("Enter form of education (DISTANCE_EDUCATION, FULL_TIME_EDUCATION, EVENING_CLASSES)")
                line+="    formOfEducation: "+ "\"" +readln()+"\""+"\n"
            }
            line+="    groupAdmin:\n"
            println("Enter name of admin")
            line+="        name: "+ "\"" +readln()+"\""+"\n"
            println("Enter weiht")
            line+="        weight: "+ readln()+"\n"
            println("Enter color (RED, BROWN, YELLOW)")
            line+="        color: "+ "\"" +readln()+"\""+"\n"
            println("Enter country (INDIA, GERMANY, SPAIN)")
            line+="        country: "+ "\"" +readln()+"\""+"\n"
            val list_of_id= listOf<Int>().toMutableList()
            var count=1
            for (i in collection.collection.keys){
                list_of_id.add(collection.collection.get(i)?.get_id()?.toInt()!!)
            }
            while (list_of_id.contains(count)){
                count++
            }
            val studyGroup= Yaml.default.decodeFromString<StudyGroup>(line)
            studyGroup.set_id(count.toLong())
            val  check= create_module()
            if (check.check(studyGroup)){
                execute_add(collection, studyGroup, key.toUpperCase())
            }
        }
    }


    override fun execute_add(collection: Collection, studyGroup: StudyGroup, key: String) {
        collection.add(studyGroup, key)
    }

    override fun execute_remove(collection: Collection, key: String) {
        collection.remove(key)
    }

    override fun create_module(): Check_module {
        return Check_module()
    }

}