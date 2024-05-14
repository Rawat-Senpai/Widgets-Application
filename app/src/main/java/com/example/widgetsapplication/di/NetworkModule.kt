package com.example.widgetsapplication.di

import android.content.Context
import com.example.widgetsapplication.api.AnimeApi
import com.example.widgetsapplication.utils.Constants
import com.example.widgetsapplication.viewModel.AnimeViewModel
import com.example.widgetsapplication.widgetPackage.StackRemoteViewsFactory
import dagger.Module
import dagger.Provides
import dagger.assisted.Assisted
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    private var client = OkHttpClient().newBuilder()
        .connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .writeTimeout(60, TimeUnit.SECONDS)
        .build()


    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit.Builder{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .client(client)
    }

    @Singleton
    @Provides
    fun provideUserApi(retrofitBuilder: Retrofit.Builder):AnimeApi{
        return retrofitBuilder.client(client).build().create(AnimeApi::class.java)
    }
//
//    @Module
//    @InstallIn(SingletonComponent::class)
//    object AssistedInjectModule{
//        @Provides
//        fun provideStackRemoteViewsFactory(
//            @ApplicationContext context:Context,
//            animeViewModel:AnimeViewModel,
//            @Assisted appWidgetId:Int
//        ):StackRemoteViewsFactory{
//            return  StackRemoteViewsFactory(context, appWidgetId,animeViewModel)
//        }
//    }

}