package com.eslirodrigues.foodpics.di

import com.eslirodrigues.foodpics.data.retrofit.FoodApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FoodModule {

    @Singleton
    @Provides
    fun provideMoshi(): Moshi = Moshi
        .Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    @Singleton
    @Provides
    fun provideRetrofit(moshi: Moshi): FoodApi {
        return Retrofit.Builder()
            .run {
                baseUrl("https://foodish-api.herokuapp.com/")
                addConverterFactory(MoshiConverterFactory.create(moshi))
                build()
            }.create(FoodApi::class.java)
    }

}