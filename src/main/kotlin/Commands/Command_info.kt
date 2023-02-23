package Commands

class Command_info: Command(){

    override fun _do(collection: Collections.Collection, key: String) {
        println("Collection: HashTable\n"+"Size "+collection.collection.size+"\n"+java.time.LocalTime.now())
    }

}