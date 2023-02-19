import com.charleskorn.kaml.Yaml
import kotlinx.serialization.encodeToString

class Command_count_less_than_admin: Command() {

    override fun _do(collection: Collection, key: String) {
        val groupAdminHash: Int = collection.collection.get(key.toUpperCase())?.get_admin()!!.hashCode()
        val count=0
        for (i in collection.collection.keys){
            var buf:Int= collection.collection.get(i)!!.get_admin().hashCode()
            if (buf<groupAdminHash) {
                println(Yaml.default.encodeToString(collection.collection.get(i)))
            }
        }
    }

}