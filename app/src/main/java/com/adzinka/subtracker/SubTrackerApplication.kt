package com.adzinka.subtracker

import android.app.Application
import com.adzinka.subtracker.data.OfflineSubscriptionRepository
import com.adzinka.subtracker.data.SubTrackerDatabase

class SubTrackerApplication : Application() {
    val database by lazy { SubTrackerDatabase.getDatabase(this) }
    val repository by lazy {
        OfflineSubscriptionRepository(
            database.subscriptionDao(),
            database.paymentDao()
        )
    }
}