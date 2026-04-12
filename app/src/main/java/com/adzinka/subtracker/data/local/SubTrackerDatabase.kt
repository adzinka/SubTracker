package com.adzinka.subtracker.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.adzinka.subtracker.data.local.dao.PaymentDao
import com.adzinka.subtracker.data.local.dao.SubscriptionDao
import com.adzinka.subtracker.data.local.entity.PaymentEntity
import com.adzinka.subtracker.data.local.entity.SubscriptionEntity
import com.adzinka.subtracker.data.mapper.toEntityModel
import com.adzinka.subtracker.fake.mockSubscriptions
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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
                )
                    .addCallback(object : Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            INSTANCE?.let { database ->
                                CoroutineScope(Dispatchers.IO).launch {
                                    populateDatabase(database.subscriptionDao())
                                }
                            }
                        }
                    })
                    .build().also { INSTANCE = it }
            }
        }

        private suspend fun populateDatabase(dao: SubscriptionDao) {
            mockSubscriptions.forEach { subscription ->
                dao.insertSubscription(subscription.toEntityModel())
            }
        }
    }
}