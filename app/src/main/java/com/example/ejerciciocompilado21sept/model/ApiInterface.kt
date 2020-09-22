package com.example.ejerciciocompilado21sept.model

import android.telecom.Call
import com.example.ejerciciocompilado21sept.ListDog
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET("breeds/list")
    fun getDataFromApi() : Call<List<ListDog>>

    @GET("breed/{razas}/images")
    suspend fun getDataFromApiCorutines(@Path("razas") mRazas: String) : Response<List<ListDog>>


}