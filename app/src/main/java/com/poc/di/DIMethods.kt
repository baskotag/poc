package com.poc.di
import android.app.Application
import androidx.room.Room
import com.poc.model.MovieDatabase
import com.poc.network.APIConstant
import com.poc.network.RetrofitService
import com.poc.utility.DBQuery.DATA_BASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DIMethods {
    @Provides
    @Singleton
    fun databaseProvider(app: Application): MovieDatabase =
        Room.databaseBuilder(app, MovieDatabase::class.java, DATA_BASE_NAME)
            .build()

    @Provides
    @Singleton
    fun retrofitProvider(): Retrofit =
        Retrofit.Builder()
            .baseUrl(APIConstant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun movieAPIProvide(retrofit: Retrofit): RetrofitService =
        retrofit.create(RetrofitService::class.java)

}