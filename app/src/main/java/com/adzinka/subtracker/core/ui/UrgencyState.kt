package com.adzinka.subtracker.core.ui

sealed interface UrgencyState {
    data object Today : UrgencyState
    data object Tomorrow : UrgencyState
    data class Days(val count: Int) : UrgencyState
    data object Paused : UrgencyState
}