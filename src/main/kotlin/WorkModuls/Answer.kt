package WorkModuls

data class Answer(var checkError: Boolean=true, val nameError: String= "Command do not exist", var result: String="Command exception: ") {
    init {
        if (checkError){
            result += nameError
        }
        if (!checkError){
            result="Success\n----------\n"
        }
    }
    fun setterResult(resultCommand: String){
        result=resultCommand
    }

    fun getAnswer(): String {
        return result
    }
}