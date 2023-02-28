package WorkModuls

import Collections.Collection
import StudyGroupInformation.StudyGroup
import com.charleskorn.kaml.Yaml
import kotlinx.serialization.decodeFromString
import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException

open class ReadFile(pathFile: String): StartChooseCommand, CreateCheckModule {
    var path: String = ""

    //Экспорт пути файла, передаваемого через аргумент команды
    init {
        path =pathFile
    }

    //Метод чтения файла
    fun readFile(collection: Collection<String, StudyGroup>){
        //Блок чтения строк из файла
        val bufferedReader= BufferedReader(FileReader(path))
        try {
            var line: String=""
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
            val checkModule= createModule()
            //Генерация уникального id и добавление объектов в колекцию
            val listOfId = mutableListOf<Long>(0)
            for (i in list){
                if (!(listOfId.contains(i.value.getId()))){
                    listOfId.add(i.value.getId())
                }
                else{
                    i.value.setId(listOfId.max()+1)
                    listOfId.add(listOfId.max()+1)
                }
            }
            //Начало выборки команды
            startChooseCommand(collection, path)
        }
        catch (e: IOException) {
            e.printStackTrace()
        }
    }
    //Интерфейс создания выборки команды
    override fun startChooseCommand(collection: Collection<String, StudyGroup>, path: String) {
        val chooseCommand= ChooseCommand()
        chooseCommand.chooseCoomand(collection, path)
    }
    //Интерфейс создания проверочного модуля
    override fun createModule(): CheckModule {
        return CheckModule()
    }
}