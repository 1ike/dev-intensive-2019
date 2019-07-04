package ru.skillbranch.devintensive.extensions

import java.lang.IllegalStateException
import java.text.SimpleDateFormat
import java.util.*

const val SECOND = 1000L
const val MINUTES = 60 * SECOND
const val HOUR = 60 * MINUTES
const val DAYS = 24 * HOUR


fun Date.format(pattern:String="HH:mm:ss dd.MM.yy"): String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))

    return dateFormat.format(this)
}

fun Date.add(value: Int, units: TimeUnits = TimeUnits.SECOND): Date {
    val time = this.time + when (units) {
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTES -> value * MINUTES
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAYS -> value * DAYS
        else -> throw IllegalStateException("invalid unit")
    }

    return Date(time)
}

enum class TimeUnits {
    SECOND,
    MINUTES,
    HOUR,
    DAYS
}