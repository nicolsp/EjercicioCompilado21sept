package com.example.ejerciciocompilado21sept.model.Retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object {
        private const val URL_BASE = "https://dog.ceo/api"

        fun getRetrofitCliente() : ApiInterface {
            var mRetrofit = Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return mRetrofit.create(ApiInterface::class.java)


        }



    }




}