package com.adzinka.subtracker.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.adzinka.subtracker.data.local.dao.PaymentDao
import com.adzinka.subtracker.data.local.dao.SubscriptionDao
import com.adzinka.subtracker.data.local.entity.PaymentEntity
import com.adzinka.subtracker.data.local.entity.SubscriptionEntity

@Database(entities = [SubscriptionEntity::class, PaymentEntity::class], version = 2, exportSchema = false)
@TypeConverters(DateConverters::class)
abstract class SubTrackerDatabase : RoomDatabase() {
    abstract fun subscriptionDao(): SubscriptionDao
    abstract fun paymentDao(): PaymentDao
}