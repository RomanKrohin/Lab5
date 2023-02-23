package Commands

abstract class Command() {
    abstract fun _do(collection: Collections.Collection, key: String)

}