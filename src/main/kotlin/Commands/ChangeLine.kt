package Commands

interface ChangeLine {
    fun returnCommandComponents(command: String, path: String): MutableList<String>
}