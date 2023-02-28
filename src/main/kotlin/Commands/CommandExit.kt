package Commands

import StudyGroupInformation.StudyGroup
import kotlin.system.exitProcess

class CommandExit: Command() {

    //Команды заканчивает работу приложения
    override fun commandDo(collection: Collections.Collection<String, StudyGroup>, key: String) {
        try {
            exitProcess(0)
        }
        catch (e: Exception){
            println("Command exception")
            e.printStackTrace()
        }
    }

}