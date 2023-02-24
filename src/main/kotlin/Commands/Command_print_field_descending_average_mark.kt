package Commands

class Command_print_field_descending_average_mark: Command() {

    //Команда выводит в порядке убывания значение поля average mark всех объектов
    override fun _do(collection: Collections.Collection, key: String) {
        val list: MutableList<Int> = listOf<Int>().toMutableList()
        for (i in collection.collection.keys){
            list.add(collection.collection.get(i)?.get_averageMark()!!)
        }
        println(list.toList().sorted().reversed().toString())
    }

}