abstract class Command(_name: String) {
    val name=_name
    abstract fun _do(collection: Collection, count_key: Int)
    fun get_name(): String{
        return name
    }
}