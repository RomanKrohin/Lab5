package Exceptions

class FilePathException : Exception() {
    /**
     * Исключение пути к файлу
     */
    fun FilePathException() {
        println("Path of file is wrong")
    }
}