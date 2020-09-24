package com.example.ejerciciocompilado21sept.model.Room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface ImageDogDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllImageDao(mImageDogDao: List<ImageDog>)

    @Query("SELECT * FROM listImage_table")
    fun getAllImageDogFromDB(): LiveData<List<ImageDog>>

    @Query("SELECT * FROM listImage_table WHERE id1 =: id")
    fun getImageDogByID(id: String): LiveData<ImageDog>



}