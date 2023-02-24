package Commands

abstract class Command() {
    //Абстрактный класс от которого наследуются все другие команды
    abstract fun _do(collection: Collections.Collection, key: String)

}