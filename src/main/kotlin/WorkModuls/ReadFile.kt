package WorkModuls

import Collections.ActionsWithCollection
import Collections.Collection
import Exceptions.ReadFileException
import StudyGroupInformation.StudyGroup
import com.charleskorn.kaml.Yaml
import kotlinx.serialization.decodeFromString
import java.io.BufferedReader
import java.io.FileReader

open class ReadFile(pathFile: String): StartChooseCommand, CreateCheckModule, ActionsWithCollection {
    /**
     * Класс модуля чтения файла
     * @param path
     */
    var path: String = ""

    //Экспорт пути файла, передаваемого через аргумент команды
    init {
        path =pathFile
    }

    /**
     * Метод чтения файла
     * @param collection
     */
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
                    if (checkModule.check(i.value)) executeAdd(collection, i.value, i.key)
                }
                else{
                    i.value.setId(listOfId.max()+1)
                    listOfId.add(listOfId.max()+1)
                    if (checkModule.check(i.value)) executeAdd(collection, i.value, i.key)
                }
            }
            //Начало выборки команды
            startChooseCommand(collection, path)
        }
        catch (e: ReadFileException) {
            throw e
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
    //Интерфейсы для работы с коллекцией
    override fun executeAdd(collection: Collection<String, StudyGroup>, studyGroup: StudyGroup, key: String) {
        collection.add(studyGroup, key)
    }

    override fun executeRemove(collection: Collection<String, StudyGroup>, key: String) {
        collection.remove(key)
    }
    //
}