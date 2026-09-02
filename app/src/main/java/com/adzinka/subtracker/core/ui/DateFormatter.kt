package com.adzinka.subtracker.core.ui

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

private val czechLocale = Locale.forLanguageTag("cs")
private val fullFormatter = DateTimeFormatter.ofPattern("d. MMMM yyyy", czechLocale)
private val shortFormatter = DateTimeFormatter.ofPattern("d. M.", czechLocale)

fun LocalDate.formatFull(): String = format(fullFormatter)
fun LocalDate.formatShort(): String = format(shortFormatter)