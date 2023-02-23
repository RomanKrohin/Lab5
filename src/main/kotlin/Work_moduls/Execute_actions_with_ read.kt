package Work_moduls

import Collections.Collection

interface `Execute_actions_with_ read` {
    public fun execute_export(readFile: Read_file, path: String)
    public fun execute_read(readFile: Read_file, collection: Collection)
    public fun create_reader(): Read_file
}