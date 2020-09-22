package com.example.ejerciciocompilado21sept


import com.google.gson.annotations.SerializedName

data class ListDog(
    @SerializedName("message")
    val message: List<String>,
    @SerializedName("status")
    val status: String
)