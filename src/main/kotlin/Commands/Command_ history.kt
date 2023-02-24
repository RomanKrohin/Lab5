package Commands

class `Command_ history` : Command() {
    //Команда, которая выводит последние 12 команд
    override fun _do(collection: Collections.Collection, key: String) {
        //Вывод массива команды, которые были вложены в массив
        println(key)
    }

}