class Person(var name: String, var lastName: String, var age: Int) {

    var email: String = ""
        set(value) {
            if (value.isNotBlank() && value.contains("@")) {
                field = value
            } else {
                throw IllegalArgumentException("Correo electrónico inválido")
            }
        }
    val isAdult: Boolean
        get() = age >= 18

    fun setEmail(email: String): Boolean {
        if (email.isEmpty() || email.isBlank()) throw error("Email cannot be blank")
        this.email = email
        return true
    }

    fun getPerson(): String {
        return "Hi, I am ${this.name}, I am ${this.age} years old, my email is ${this.email}"
    }
}