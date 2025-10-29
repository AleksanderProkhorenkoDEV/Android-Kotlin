/*
Typically, a phone screen turns on and off when the power button is pressed. In contrast, if a foldable phone is folded, the main inner screen on a foldable phone doesn't turn on when the power button is pressed.

In the initial code provided in the following code snippet, write a FoldablePhone class that inherits from the Phone class. It should contain the following:

A property that indicates whether the phone is folded.
A different switchOn() function behavior than the Phone class so that it only turns the screen on when the phone isn't folded.
Methods to change the folding state.
 */

fun main() {
    val foldedPhone = FoldedPhone()
    foldedPhone.switchFolded() // fold or unfold the fond, in this case unfold
    println(foldedPhone.getFolded())
    foldedPhone.checkPhoneScreenLight() // the light is off
    foldedPhone.switchOn() // turn on the light
    foldedPhone.checkPhoneScreenLight()
}