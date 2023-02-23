import Collections.Collection
import Work_moduls.Create_collection
import Work_moduls.`Execute_actions_with_ read`
import Work_moduls.Read_file
import java.io.IOException

fun main(args: Array<String>){
    val executer: Executer = Executer()
    try {
        executer.execute_work(args[0])
    }
    catch (e: IOException){
        println("Wrong path")
    }

}
class Executer : `Execute_actions_with_ read`, Create_collection {
    fun execute_work(path: String){
        val test=create_reader()
        execute_export(test, path)
        execute_read(test, create_collection())
    }

    override fun execute_export(readFile: Read_file, path: String) {
        readFile.export_file(path)
    }

    override fun execute_read(readFile: Read_file, collection: Collection) {
        readFile.read_file(collection)
    }

    override fun create_reader(): Read_file {
        return Read_file()
    }

    override fun create_collection(): Collection {
        return Collection()
    }

}
