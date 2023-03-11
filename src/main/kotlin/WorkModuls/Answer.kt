package WorkModuls

class Answer {
    var result: String= ""
    fun setterResult(resultCommand: String){
        result=resultCommand
    }

    fun getAnswer(): String{
        return result
    }
}