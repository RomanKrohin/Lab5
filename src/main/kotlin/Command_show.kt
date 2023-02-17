import com.charleskorn.kaml.Yaml
import kotlinx.serialization.encodeToString

class Command_show: Command(_name = "show") {
    override fun _do(collection: Collection, list_of_keys: List<String>) {
        for (i in list_of_keys){
            if (collection.collection.get(i)!=null){
                println(Yaml.default.encodeToString(collection.collection.get(i)))
            }
        }
    }

    override fun _do(collection: Collection, list_of_keys: List<String>, key: String) {
    }

    override fun _do(collection: Collection, list_of_keys: List<String>, new_id: Int) {
    }
}