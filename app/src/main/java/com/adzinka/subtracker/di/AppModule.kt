package com.adzinka.subtracker.di

import android.content.Context
import com.adzinka.subtracker.data.local.SubTrackerDatabase
import com.adzinka.subtracker.data.local.dao.PaymentDao
import com.adzinka.subtracker.data.local.dao.SubscriptionDao
import com.adzinka.subtracker.data.repository.OfflineSubscriptionRepository
import com.adzinka.subtracker.data.repository.SubscriptionRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): SubTrackerDatabase =
        SubTrackerDatabase.getDatabase(context)

    @Provides
    @Singleton
    fun provideSubscriptionDao(database: SubTrackerDatabase): SubscriptionDao =
        database.subscriptionDao()

    @Provides
    @Singleton
    fun providePaymentDao(database: SubTrackerDatabase): PaymentDao =
        database.paymentDao()

    @Provides
    @Singleton
    fun provideSubscriptionRepository(
        subscriptionDao: SubscriptionDao,
        paymentDao: PaymentDao
    ): SubscriptionRepository =
        OfflineSubscriptionRepository(subscriptionDao, paymentDao)

}