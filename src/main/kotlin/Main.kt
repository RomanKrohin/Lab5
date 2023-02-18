fun main(args: Array<String>){
    val executer: Main= Main()
    executer.execute_work()
}
class Main : `Execute_actions_with_ read`, Create_collection{
    fun execute_work(){
        val test=create_reader()
        execute_export(test)
        execute_read(test, create_collection())
    }

    override fun execute_export(readFile: Read_file) {
        readFile.export_file()
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
