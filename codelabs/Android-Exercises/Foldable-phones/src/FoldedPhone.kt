class FoldedPhone(private var folded: Boolean = true) : Phone() {

    fun getFolded() = folded

    override fun switchOn() {
        if (!folded) {
            isScreenLightOn = true
        }
    }

    fun switchFolded() {
        folded = !folded
    }
}