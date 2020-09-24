package com.example.ejerciciocompilado21sept.model.Room

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "Images_table")
data class ImageDog(@PrimaryKey val imageUrl: String)


