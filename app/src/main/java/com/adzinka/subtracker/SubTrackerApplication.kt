package com.adzinka.subtracker

import android.app.Application
import com.adzinka.subtracker.data.repository.OfflineSubscriptionRepository
import com.adzinka.subtracker.data.local.SubTrackerDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SubTrackerApplication : Application()