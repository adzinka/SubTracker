package com.adzinka.subtracker.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.adzinka.subtracker.data.entity.PaymentEntity
import com.adzinka.subtracker.data.entity.SubscriptionEntity

@Database(entities = [SubscriptionEntity::class, PaymentEntity::class], version = 1, exportSchema = false)
abstract class SubTrackerDatabase : RoomDatabase() {
    abstract fun subscriptionDao(): SubscriptionDao
    abstract fun paymentDao(): PaymentDao

    companion object {
        @Volatile
        private var INSTANCE: SubTrackerDatabase? = null

        fun getDatabase(context: Context): SubTrackerDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    SubTrackerDatabase::class.java,
                    "subtracker_database"
                ).build().also { INSTANCE = it }
            }
        }
    }
}
