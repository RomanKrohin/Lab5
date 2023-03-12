package WorkModuls

import Collections.ActionsWithCollection
import Collections.Collection
import Exceptions.ReadFileException
import StudyGroupInformation.StudyGroup
import com.charleskorn.kaml.Yaml
import kotlinx.serialization.decodeFromString
import java.io.BufferedReader
import java.io.FileReader

/**
 * Класс модуля чтения файла
 * @param path
 */
open class ReadFile(pathFile: String) : StartChooseCommand, CreateCheckModule, ActionsWithCollection {
    private var path: String = ""

    init {
        path = pathFile
    }

    /**
     * Метод чтения файла
     * @param collection
     */
    fun readFile(collection: Collection<String, StudyGroup>) {
        val bufferedReader = BufferedReader(FileReader(path))
        try {
            var line: String = ""
            while (true) {
                if (bufferedReader.ready()) {
                    line += "\n" + bufferedReader.readLine()
                } else {
                    break
                }
            }
            val list = Yaml.default.decodeFromString<Map<String, StudyGroup>>(line)
            val checkModule = createModule()
            val listOfId = mutableListOf<Long>(0)
            for (i in list) {
                if (!(listOfId.contains(i.value.getId()))) {
                    listOfId.add(i.value.getId())
                    if (checkModule.check(i.value)) executeAdd(collection, i.value, i.key)
                } else {
                    i.value.setId(listOfId.max() + 1)
                    listOfId.add(listOfId.max() + 1)
                    if (checkModule.check(i.value)) executeAdd(collection, i.value, i.key)
                }
            }
            startChooseCommand(collection, path)
        } catch (e: ReadFileException) {
            throw e
        }
    }

    override fun startChooseCommand(collection: Collection<String, StudyGroup>, path: String) {
        Reader().reader(collection, path)
    }

    override fun createModule(): CheckModule {
        return CheckModule()
    }

    override fun executeAdd(collection: Collection<String, StudyGroup>, studyGroup: StudyGroup, key: String) {
        collection.add(studyGroup, key)
    }

    override fun executeRemove(collection: Collection<String, StudyGroup>, key: String) {
        collection.remove(key)
    }
}