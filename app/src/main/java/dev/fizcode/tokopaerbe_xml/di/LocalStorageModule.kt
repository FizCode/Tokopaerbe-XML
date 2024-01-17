package dev.fizcode.tokopaerbe_xml.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.fizcode.tokopaerbe_xml.datastore.SharedPrefDatastore
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalStorageModule {

    @Singleton
    @Provides
    fun provideOnboardingDataStoreManager(@ApplicationContext context: Context)
    : SharedPrefDatastore {
        return SharedPrefDatastore(context = context)
    }
}