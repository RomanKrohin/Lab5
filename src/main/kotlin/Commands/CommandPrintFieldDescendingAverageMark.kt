package Commands

import StudyGroupInformation.StudyGroup

class CommandPrintFieldDescendingAverageMark: Command() {

    //Команда выводит в порядке убывания значение поля average mark всех объектов
    override fun commandDo(collection: Collections.Collection<String, StudyGroup>, key: String) {
        try {
            val list: MutableList<Int> = listOf<Int>().toMutableList()
            for (i in collection.collection.values){
                list.add(i.getAverageMark())
            }
            println(list.toList().sorted().reversed().toString())
        }
        catch (e: Exception){
            println("Command exception")
            e.printStackTrace()
        }
    }

}