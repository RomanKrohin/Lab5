abstract class Command(_name: String) {
    val name=_name
    abstract fun _do(collection: Collection, list_of_keys: List<String>)
    abstract fun _do(collection: Collection, list_of_keys: List<String>, key: String)
    abstract fun _do(collection: Collection, list_of_keys: List<String>, new_id: Int)
    fun get_name(): String{
        return name
    }
}