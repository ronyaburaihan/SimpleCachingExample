package com.techdoctorbd.simplecachingexample.di

import android.app.Application
import androidx.room.Room
import com.techdoctorbd.simplecachingexample.data.RestaurantDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application) : RestaurantDatabase =
        Room.databaseBuilder(app, RestaurantDatabase::class.java, "restaurant_database")
            .build()
}