import Collections.Collection
import Exceptions.FilePathException
import StudyGroupInformation.StudyGroup
import WorkModuls.CreateCollection
import WorkModuls.ExecuteActionsWithRead
import WorkModuls.ReadFile

/**
 * Точка вхождения в программу
 * @param args
 */
fun main(args: Array<String>) {
    // Начало работы, создает экземпляр инициатора работы, использование метода,
    // который начинает чтение фала
    try {
        val executer: Executer = Executer(args[0])
    } catch (e: FilePathException) {
        throw e
    }

}

class Executer(path: String) : ExecuteActionsWithRead, CreateCollection {
    /**
     * Класс инициализатор работы
     * @param path
     */
    //Метод инициализации передачи пути к файлу и начала работы чтения файла
    init {
        val test = createReader(path)
        executeRead(test, createCollection())
    }

    //Инициализация чтения
    override fun executeRead(readFile: ReadFile, collection: Collection<String, StudyGroup>) {
        readFile.readFile(collection)
    }

    //Создание экземпляра объекта, который считывает файл
    override fun createReader(path: String): ReadFile {
        return ReadFile(path)
    }

    //Создание экземпляра коллекции
    override fun createCollection(): Collection<String, StudyGroup> {
        return Collection()
    }

}
