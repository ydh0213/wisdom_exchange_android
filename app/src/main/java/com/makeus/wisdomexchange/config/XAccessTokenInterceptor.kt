package com.makeus.wisdomexchange.config

import com.makeus.wisdomexchange.src.ApplicationClass.Companion.X_ACCESS_TOKEN
import com.makeus.wisdomexchange.src.ApplicationClass.Companion.sharedPreferences
import okhttp3.Interceptor
import okhttp3.Response

class XAccessTokenInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        val jwtToken = sharedPreferences?.getString(X_ACCESS_TOKEN, null)
        if (jwtToken != null)
            builder.addHeader("X-ACCESS-TOKEN", jwtToken)

        return chain.proceed(builder.build())
    }
}