package WorkModuls

import Collections.Collection
import StudyGroupInformation.StudyGroup

class Reader: WorkWithAsker, WorkWithPrinter, WorkWithTokenizator, WorkWithChooseCommand {
    fun reader(collection: Collection<String, StudyGroup>, path: String){
        val asker= createAsker()
        val tokens= createTokenizator()
        val chooseCommand= createChooseCommand(collection)
        val printer= createPrinter()
        while (true) {
            val command = asker.askCommand()
            val commandComponents = tokens.returnCommandComponents(command, path)
            val answer = chooseCommand.chooseCoomand(commandComponents)
            printer.print(answer)
        }
    }

    override fun createAsker(): Asker {
        return Asker()
    }

    override fun createPrinter(): Printer {
        return Printer()
    }

    override fun createTokenizator(): Tokenizator {
        return Tokenizator()
    }

    override fun createChooseCommand(collection: Collection<String, StudyGroup>): ChooseCommand {
        return  ChooseCommand(collection)
    }
}