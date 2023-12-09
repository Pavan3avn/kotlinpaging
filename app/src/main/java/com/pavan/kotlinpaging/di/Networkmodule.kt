package com.pavan.kotlinpaging.di

import com.pavan.kotlinpaging.retrofit.QuoteApi
import com.pavan.kotlinpaging.utils.Constants.BASE_URl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class Networkmodule() {

    @Singleton
    @Provides
    fun getRetrofit():Retrofit{
            return Retrofit.Builder().baseUrl(BASE_URl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
    @Singleton
    @Provides
    fun getQuoteApi(retrofit: Retrofit): QuoteApi{
        return retrofit.create(QuoteApi::class.java)
    }


}