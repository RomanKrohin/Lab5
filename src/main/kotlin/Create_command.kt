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
}