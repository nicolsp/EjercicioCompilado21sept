package com.example.ejerciciocompilado21sept.model.Room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.ejerciciocompilado21sept.model.Retrofit.DataListApi

@Dao
interface ListDogDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllListDog(mListDog: List<ListDog>)

    @Query("SELECT*FROM listdog_table")
    fun getAllListDogFromDB(): LiveData<List<ListDog>>

    @Query("SELECT * FROM listdog_table WHERE listdog =:listdog")
    fun getListDogByID(listdog: String): LiveData<ListDog>

}