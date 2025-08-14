object ResistorColorDuo {
    fun value(vararg colors: Color) = colors[0].ordinal * 10 + colors[1].ordinal
}
