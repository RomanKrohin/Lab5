class Command_print_field_descending_average_mark: Command(_name = "print_field_descending_average_mark") {
    override fun _do(collection: Collection) {
        val list: MutableList<Int> = listOf<Int>().toMutableList()
        for (i in collection.collection.keys){
            list.add(collection.collection.get(i)?.get_averageMark()!!)
        }
        println(list.toList().sorted().reversed().toString())
    }

    override fun _do(collection: Collection, key: String) {
    }

    override fun _do(collection: Collection, new_id: Int) {
    }
}