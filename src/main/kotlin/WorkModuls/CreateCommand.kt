package WorkModuls

import Commands.Command

interface CreateCommand {
    fun createCommnads() : Map<String, Command>
}