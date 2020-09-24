package com.example.ejerciciocompilado21sept.model.Retrofit


import com.google.gson.annotations.SerializedName

data class DataImageApi(
    @SerializedName("message")
    val message: List<String>,
    @SerializedName("status")
    val status: String
)