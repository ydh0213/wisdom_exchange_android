package com.makeus.wisdomexchange.src

import android.app.Application
import android.content.SharedPreferences
import com.makeus.wisdomexchange.config.XAccessTokenInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApplicationClass : Application() {
    companion object {
        private const val TEST_BASE_URL = ""
        private const val BASE_URL = ""
        const val X_ACCESS_TOKEN = "X-ACCESS-TOKEN"
        const val TAG = "WISDOM_EXCHANGE_APP"

        private lateinit var retrofit: Retrofit
        var sharedPreferences: SharedPreferences? = null

        fun getRetrofit(): Retrofit? {
            if (!::retrofit.isInitialized) {
                val client = OkHttpClient.Builder()
                    .readTimeout(5000, TimeUnit.MILLISECONDS)
                    .connectTimeout(5000, TimeUnit.MILLISECONDS)
                    .addNetworkInterceptor(XAccessTokenInterceptor()) // JWT 자동 헤더 전송
                    .build()

                retrofit = Retrofit.Builder()
                    .baseUrl(TEST_BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }

            return retrofit
        }
    }

    override fun onCreate() {
        super.onCreate()
        if (sharedPreferences == null)
            sharedPreferences = applicationContext.getSharedPreferences(TAG, MODE_PRIVATE)
    }
}