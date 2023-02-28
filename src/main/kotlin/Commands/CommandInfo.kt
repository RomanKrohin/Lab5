package Commands

import StudyGroupInformation.StudyGroup

class CommandInfo: Command(){

    //Команда выводит информацию и коллекции
    override fun commandDo(collection: Collections.Collection<String, StudyGroup>, key: String) {
        try {
            println("Collection: HashTable\n"+"Size "+collection.collection.size+"\n"+java.time.LocalTime.now())
        }
        catch (e: Exception){
            println("Command exception")
            e.printStackTrace()
        }
    }

}