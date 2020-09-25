package com.example.ejerciciocompilado21sept.model.Room


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity(tableName = "listdog_table")
data class ListDog( @PrimaryKey val listDog: String)
