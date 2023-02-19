class Command_print_field_descending_average_mark: Command() {

    override fun _do(collection: Collection, key: String) {
        val list: MutableList<Int> = listOf<Int>().toMutableList()
        for (i in collection.collection.keys){
            list.add(collection.collection.get(i)?.get_averageMark()!!)
        }
        println(list.toList().sorted().reversed().toString())
    }

}