class Person(val name: String, val age: Int, val hobby: String?, val referrer: Person?) {
    fun showProfile() {
        val isReferrer =
            if (referrer != null)
                "Has a referrer ${referrer.name}, who likes to ${referrer.hobby}"
            else
                "Doesn't have referrer"
        println("Name: $name\nAge: $age\nLikes to ${hobby ?: "no specified"}, $isReferrer")
    }
}