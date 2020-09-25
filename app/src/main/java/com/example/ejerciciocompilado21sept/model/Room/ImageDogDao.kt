package com.example.ejerciciocompilado21sept.model.Room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.ejerciciocompilado21sept.model.Retrofit.DataImageApi


@Dao
interface ImageDogDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllImageDao(mImageDogDao: List<ImageDog>)

    @Query("SELECT * FROM Images_table")
    fun getAllImageDogFromDB(): LiveData<List<ImageDog>>

   @Query("SELECT * FROM Images_table WHERE imageUrl =:imageUrl")
   fun getImageDogByID(imageUrl: String): LiveData<ImageDog>



}