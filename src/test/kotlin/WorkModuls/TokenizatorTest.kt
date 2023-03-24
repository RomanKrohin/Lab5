package WorkModuls

import org.junit.jupiter.api.Test

class TokenizatorTest {

    @Test
    fun testTokenizateCommandUpdateId() {
        val tokenizator= Tokenizator()
        val history = listOf<String>().toMutableList()
        val buf= tokenizator.tokenizateCommand("update id 5", "wadawda", history)
        assert(buf[1].equals("5"))
    }

    @Test
    fun testTokenizateShow() {
        val tokenizator= Tokenizator()
        val history = listOf<String>().toMutableList()
        val buf= tokenizator.tokenizateCommand("show", "wadawda", history)
        assert(buf[1].equals(""))
    }

    @Test
    fun testTokenizateExecuteScript() {
        val tokenizator= Tokenizator()
        val history = listOf<String>().toMutableList()
        val buf= tokenizator.tokenizateCommand("show /home/roman/App/script1.txt", "wadawda", history)
        assert(buf[1].equals("/home/roman/App/script1.txt"))
    }
}