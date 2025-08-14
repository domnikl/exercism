class Year(private val year: Int) {
    val isLeap = year % 4 == 0
        && (year % 100 != 0 || year % 400 == 0)
}
