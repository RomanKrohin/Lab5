import com.charleskorn.kaml.Yaml
import kotlinx.serialization.encodeToString

class Command_max_name: Command(_name = "max_by_name") {
    override fun _do(collection: Collection) {
        var max_key=""
        var max_name=""
        for (i in collection.collection.keys){
            if (max_name.hashCode()<collection.collection.get(i).hashCode()){
                max_key=i
                max_name= collection.collection.get(i)!!.get_name()
            }
        }
        println(Yaml.default.encodeToString(collection.collection.get(max_key)))
    }

    override fun _do(collection: Collection, key: String) {
    }

    override fun _do(collection: Collection, new_id: Int) {
    }
}