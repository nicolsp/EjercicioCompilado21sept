package com.example.ejerciciocompilado21sept.model.Retrofit

import com.example.ejerciciocompilado21sept.model.Room.ListDog
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiInterface {

    @GET("breeds/list")
    fun getDataFromApi() : retrofit2.Call<DataListApi>

    @GET("breed/{razas}/images")
    suspend fun getDataFromApiCorutines(@Path("razas") mRazas: String) : Response<List<DataImageApi>>


}