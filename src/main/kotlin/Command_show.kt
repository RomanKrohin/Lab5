import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class Command_show: Command(_name = "show") {
    override fun _do(collection: Collection, count_key: Int) {
        for (i in 1..count_key){
            println(Json.encodeToString(collection.collection.get(i)))
        }
    }
}