package dev.fizcode.tokopaerbe_xml.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.fizcode.tokopaerbe_xml.datastore.SharedPrefDatastore
import dev.fizcode.tokopaerbe_xml.repository.OnboardingRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideOnboardingRepository(
        sharedPrefDatastore: SharedPrefDatastore
    ): OnboardingRepository {
        return OnboardingRepository(
            sharedPrefDatastore = sharedPrefDatastore
        )
    }
}