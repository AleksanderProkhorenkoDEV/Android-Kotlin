/*
Oftentimes, you're required to complete profiles for online websites that contain mandatory and non-mandatory fields.
For example, you can add your personal information and link to other people who referred you to sign up for the profile.

In the initial code provided in the following code snippet, write a program which prints out a person's profile details.
 */
fun main() {
    val amanda = Person("Amanda", 33, "play tennis", null)
    val atiqah = Person("Atiqah", 28, "climb", amanda)

    amanda.showProfile()
    atiqah.showProfile()
}