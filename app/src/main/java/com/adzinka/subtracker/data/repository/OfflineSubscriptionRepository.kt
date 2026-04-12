package com.adzinka.subtracker.data.repository

import com.adzinka.subtracker.data.local.dao.PaymentDao
import com.adzinka.subtracker.data.local.dao.SubscriptionDao
import com.adzinka.subtracker.data.local.entity.PaymentEntity
import com.adzinka.subtracker.data.local.entity.SubscriptionEntity
import com.adzinka.subtracker.data.mapper.toDomainModel
import com.adzinka.subtracker.data.mapper.toEntityModel
import com.adzinka.subtracker.model.Payment
import com.adzinka.subtracker.model.Subscription
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class OfflineSubscriptionRepository(
    private val subscriptionDao: SubscriptionDao,
    private val paymentDao: PaymentDao
) : SubscriptionRepository {
    override fun getAllSubscriptions(): Flow<List<Subscription>> {
        return subscriptionDao.getAllSubscriptions().map { it.map(SubscriptionEntity::toDomainModel) }
    }

    override fun getSubscriptionById(id: Int): Flow<Subscription> {
        return subscriptionDao.getSubscriptionById(id).map { it.toDomainModel() }
    }

    override suspend fun insertSubscription(subscription: Subscription) {
        subscriptionDao.insertSubscription(subscription.toEntityModel())
    }

    override suspend fun updateSubscription(subscription: Subscription) {
        subscriptionDao.updateSubscription(subscription.toEntityModel())
    }

    override suspend fun deleteSubscription(subscription: Subscription) {
        subscriptionDao.deleteSubscription(subscription.toEntityModel())
    }

    override fun getPaymentsBySubscriptionId(subscriptionId: Int): Flow<List<Payment>> {
        return paymentDao.getAllPaymentsBySubscriptionId(subscriptionId).map { it.map(PaymentEntity::toDomainModel) }
    }

    override suspend fun insertPayment(payment: Payment) {
        paymentDao.insertPayment(payment.toEntityModel())
    }

}