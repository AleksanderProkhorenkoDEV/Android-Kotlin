class Song(val title: String, val artist: String, val yearPublished: String, val playCount: Int = 0) {

    val isPopular: Boolean
        get() {
            return playCount >= 1000
        }

    val popularity: String
        get() = if (isPopular) "popular" else "unpopular"

    override fun toString(): String {
        return "$title, perfomed by $artist, was released in $yearPublished"
    }
}