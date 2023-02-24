package Work_moduls

import Collections.Collection
import Study_group_information.StudyGroup
import com.charleskorn.kaml.Yaml
import kotlinx.serialization.decodeFromString
import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException

open class Read_file: Create_choose_command, Create_check_module {

    var path: String = ""
    //Экспорт пути файла, передаваемого через аргумент команды
    fun export_file(path_file: String){
        path =  path_file
    }

    //Метод чтения файла
    fun read_file(collection: Collection){
        //Блок чтения строк из файла
        val bufferedReader= BufferedReader(FileReader(path))
        try {
            var line: String=""
            var count_key=0
            while (true){
                if (bufferedReader.ready()){
                    line+="\n"+bufferedReader.readLine()
                }
                else{
                    break
                }
            }
            //
            //Сериализация данных полученных из файла
            val list =Yaml.default.decodeFromString<Map<String, StudyGroup>>(line)
            //Создание экземпляра проверочного модуля
            val checkModule= create_module()
            //Генерация уникального id и добавление объектов в колекцию
            val list_of_id: MutableList<Int> = listOf<Int>().toMutableList()
                for (i in list.keys){
                    if (checkModule.check(list.get(i))){
                        if ((list.get(i)?.get_id()== 0.toLong()) or (list_of_id.contains(list.get(i)?.get_id()?.toInt()))){
                            while (true){
                                if (list_of_id.contains(++count_key)==false){
                                    list.get(i)?.set_id((count_key).toLong())
                                    break
                                }
                            }
                        }
                        list_of_id.add(list.get(i)?.get_id()?.toInt()!!)
                        collection.add(list.get(i)!!, i)
                    }
            }
            //Начало выборки команды
            create_choose_command(collection, path)
        }
        catch (e: IOException) {
            e.printStackTrace()
        }
    }
    //Интерфейс создания выборки команды
    override fun create_choose_command(collection: Collection, path: String) {
        val chooseCommand= Choose_command()
        chooseCommand.choose_coomand(collection, path)
    }
    //Интерфейс создания проверочного модуля
    override fun create_module(): Check_module {
        return Check_module()
    }
}