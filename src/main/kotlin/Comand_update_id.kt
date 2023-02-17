class Comand_update_id: Command(_name = "update id") {
    override fun _do(collection: Collection, list_of_keys: List<String>) {
    }

    override fun _do(collection: Collection, list_of_keys: List<String>, key: String) {
    }

    override fun _do(collection: Collection, list_of_keys: List<String>, id: Int) {
        for (i in list_of_keys){
            if (collection.collection.get(i)?.get_id()== id.toLong()){
                val studyGroup= collection.collection.get(i)
                collection.collection.remove(i)
                println("Enter new id")
                val new_id: Long= readln().toLong()
                studyGroup?.set_id(new_id)
                collection.add(studyGroup!!, i)
            }
        }
    }
}