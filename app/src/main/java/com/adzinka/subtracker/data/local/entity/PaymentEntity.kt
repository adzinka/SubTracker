package com.adzinka.subtracker.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(
    tableName = "payments",
    foreignKeys = [
        ForeignKey(
            entity = SubscriptionEntity::class,
            parentColumns = ["id"],
            childColumns = ["subscriptionId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("subscriptionId")]
)
data class PaymentEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val subscriptionId: Int,
    val date: LocalDate,
    val amount: Int,
    val currency: String = "CZK",
    val status: String
)
