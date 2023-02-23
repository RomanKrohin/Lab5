package Commands

interface Change_line {
    fun return_command_components(command: String, path: String): MutableList<String>
}