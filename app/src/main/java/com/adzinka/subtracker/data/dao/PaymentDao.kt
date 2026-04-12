package com.adzinka.subtracker.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.adzinka.subtracker.data.entity.PaymentEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PaymentDao {
    @Query("SELECT * FROM payments where subscriptionId = :subscriptionId")
    fun getAllPaymentsBySubscriptionId(subscriptionId: Int): Flow<List<PaymentEntity>>

    @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun insertPayment(payment: PaymentEntity)

    @Delete
    suspend fun deletePayment(payment: PaymentEntity)
}