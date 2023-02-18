abstract class Command(_name: String) {
    val name=_name
    abstract fun _do(collection: Collection)
    abstract fun _do(collection: Collection, key: String)
    abstract fun _do(collection: Collection, new_id: Int)
    fun get_name(): String{
        return name
    }
}