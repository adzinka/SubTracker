package com.adzinka.subtracker.core.ui

sealed interface UrgencyState {
    data object Tomorrow : UrgencyState
    data object Soon : UrgencyState
    data class Days(val count: Int) : UrgencyState
    data object Paused : UrgencyState
}