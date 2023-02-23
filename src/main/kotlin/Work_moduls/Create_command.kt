package Work_moduls

import Commands.Command

interface Create_command {
    fun create_help(): Command
    fun create_exit(): Command
    fun create_show(): Command
    fun createe_info(): Command
    fun create_update_id(): Command
    fun create_clear(): Command
    fun create_max_by_name(): Command
    fun create_delete_by_key_max(): Command
    fun create_delete_by_key_min(): Command
    fun create_count_less_than_group_admin(): Command
    fun create_print_field_descending_average_mark(): Command
    fun create_insert(): Command
    fun create_save(): Command
    fun create_remove(): Command
    fun create_history(): Command
    fun create_execute_script(): Command
}