package com.adzinka.subtracker.data

import com.adzinka.subtracker.model.Payment
import com.adzinka.subtracker.model.Subscription
import kotlinx.coroutines.flow.Flow

interface SubscriptionRepository {
    fun getAllSubscriptions(): Flow<List<Subscription>>
    fun getSubscriptionById(id: Int): Flow<Subscription>
    suspend fun insertSubscription(subscription: Subscription)
    suspend fun updateSubscription(subscription: Subscription)
    suspend fun deleteSubscription(subscription: Subscription)
    fun getPaymentsBySubscriptionId(subscriptionId: Int): Flow<List<Payment>>
    suspend fun insertPayment(payment: Payment)
}