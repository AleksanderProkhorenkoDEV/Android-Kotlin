fun main() {
    val personOne = Person("Aleksander", "Trujillo", 21)

    personOne.setEmail("aleksanderprokhorenoko@gmail.com")

    println(personOne.getPerson())

    println("Enter your name:")
    val name: String = readln()
    println("Enter your last name:")
    val lastName: String = readln()
    println("Enter your age:")
    val age: Int = readln().toInt()

    val personeTwo = Person(name, lastName, age)

    print(personeTwo.getPerson())
    print("Are ${personeTwo.name} an adult? ${personOne.isAdult}")


}