//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    //1 Type and variable
    val name: String = "Aleksander"
    val age: Int = 21
    var learning: Boolean = true
    var height: Double = 1.78


}

// 2 Null safety
fun lengthOfString(word: String?): Int {
    if (word == null) return 0
    return word.length
}

//3 Elvis operator
fun refactorLenghtOfString(word: String?): Int {
    return word?.length ?: 0
}