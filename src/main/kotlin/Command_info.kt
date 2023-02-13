class Command_info: Command(_name = "info"){
    override fun _do(collection: Collection, count_key: Int) {
        println("Collection: HashMap\n"+"Size "+collection.collection.size+"\n"+java.time.LocalTime.now())
    }
}