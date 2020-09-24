package com.example.ejerciciocompilado21sept.model.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

private const val DATA_BASE_NAME = "mars_db"

@Database(entities = [ListDog::class], version = 1)
abstract class DogDataBase:RoomDatabase() {
    abstract fun getListDogDao(): ListDogDao

    companion object {
        @Volatile
        private var INSTANCE: DogDataBase? = null
        fun getDataBase(context: Context): DogDataBase {
            val tempInstance =
                INSTANCE
            if(tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(context,
                    DogDataBase::class.java,
                    DATA_BASE_NAME
                )
                    .build()
                INSTANCE =instance
                return instance
            }
        }
    }

}