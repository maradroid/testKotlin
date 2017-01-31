package com.maradroid.testkotlin.base

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.serjltt.moshi.adapters.WrappedJsonAdapter
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

/**
 * Created by mara on 1/24/17.
 */
@Singleton
@Module
class AppModule {

    @Singleton
    @Provides
    fun provideMoshi(): Moshi = Moshi.Builder().add(WrappedJsonAdapter.FACTORY).build()

    @Singleton
    @Provides
    fun provideHttpCient(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val httpClientBuilder = OkHttpClient.Builder()
        httpClientBuilder.addInterceptor(logging)

        return httpClientBuilder.build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(moshi: Moshi, httpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl("https://www.reddit.com")
                .client(httpClient)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    @Singleton
    @Provides
    fun provideRestInterface(retrofit: Retrofit): RestInterface = retrofit.create(RestInterface::class.java)
}