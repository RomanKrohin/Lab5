package Commands

import StudyGroupInformation.StudyGroup

class CommandHistory : Command() {

    //Команда, которая выводит последние 12 команд
    override fun commandDo(collection: Collections.Collection<String, StudyGroup>, key: String) {
        try {
            //Вывод массива команды, которые были вложены в массив
            println(key)
        }
        catch (e: Exception){
            println("Command exception")
            e.printStackTrace()
        }

    }

}