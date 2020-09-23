package com.example.ejerciciocompilado21sept.model


import androidx.room.Entity
import com.google.gson.annotations.SerializedName
@Entity(tableName = "listdog_table")
data class ListDog(
    @SerializedName("message")
    val message: List<String>,
    @SerializedName("status")
    val status: String
)