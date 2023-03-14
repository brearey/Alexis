package ru.oktemsec.sashapopov

data class Question(
    val questionText: String,

    val painORVI: Int,
    val painMeningit: Int,
    val painORZ: Int,
    val painNevralgia: Int,

    val highTemp: Boolean
)
