import com.charleskorn.kaml.Yaml
import kotlinx.serialization.encodeToString

class Command_show: Command(_name = "show") {
    override fun _do(collection: Collection) {
        for (i in collection.collection.keys){
            if (collection.collection.get(i)!=null){
                println(Yaml.default.encodeToString(collection.collection.get(i)))
                println("----------")
            }
        }
    }

    override fun _do(collection: Collection, key: String) {
    }

    override fun _do(collection: Collection, new_id: Int) {
    }
}