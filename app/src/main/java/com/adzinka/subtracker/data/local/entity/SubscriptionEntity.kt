package com.adzinka.subtracker.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.adzinka.subtracker.model.BillingPeriod
import com.adzinka.subtracker.model.SubscriptionStatus

@Entity(tableName = "subscriptions")
data class SubscriptionEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val category: String,
    @ColumnInfo(name = "next_payment_date") val nextPaymentDate: String,
    val price: Int,
    val currency: String = "CZK",
    @ColumnInfo(name = "billing_period") val billingPeriod: String = BillingPeriod.MONTHLY.name,
    @ColumnInfo(name = "reminder_days") val reminderDays: Int? = null,
    val status: String = SubscriptionStatus.ACTIVE.name,
    val notes: String? = null
)
