package Commands

import com.charleskorn.kaml.Yaml
import kotlinx.serialization.encodeToString

class Command_show: Command() {
    override fun _do(collection: Collections.Collection, key: String) {
        for (i in collection.collection.keys){
            if (collection.collection.get(i)!=null){
                println(Yaml.default.encodeToString(collection.collection.get(i)))
                println("----------")
            }
        }
    }
}