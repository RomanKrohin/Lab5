package Commands

import Collections.Actions_with_collection
import Study_group_information.StudyGroup

class Comand_update_id: Command(), Actions_with_collection {
    //Команда обновления id у объекта
    override fun _do(collection: Collections.Collection, key: String) {
        //Метод находит объект по его ключу и если id, которые хотят установить уникален в рамках данной коллекции,
        //то он меняет id на переданный команде
        for (i in collection.collection.keys){
            if (collection.collection.get(i)?.get_id()== key.toLong()){
                val studyGroup= collection.collection.get(i)
                execute_remove(collection, i)
                println("Enter new id")
                //Ввод нового id
                val new_id: Long= readln().toLong()
                studyGroup?.set_id(new_id)
                execute_add(collection, studyGroup!!, i)
            }
        }
    }
    //Интерфейсы для работы с коллекцией
    override fun execute_add(collection: Collections.Collection, studyGroup: StudyGroup, key: String) {
        collection.add(studyGroup, key)
    }

    override fun execute_remove(collection: Collections.Collection, key: String) {
        collection.remove(key)
    }
    //
}