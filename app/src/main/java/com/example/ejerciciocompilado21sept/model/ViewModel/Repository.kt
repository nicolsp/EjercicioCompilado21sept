package com.example.ejerciciocompilado21sept.model.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.ejerciciocompilado21sept.model.Retrofit.DataListApi
import com.example.ejerciciocompilado21sept.model.Retrofit.RetrofitClient
import com.example.ejerciciocompilado21sept.model.Room.ImageDogDao
import com.example.ejerciciocompilado21sept.model.Room.ListDog
import com.example.ejerciciocompilado21sept.model.Room.ListDogDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.reflect.Array.get

class Repository(private val listDogDao: ListDogDao,
                    private val imageDogDao: ImageDogDao){
    private val service = RetrofitClient.getRetrofitCliente()
    val mLiveDataListDog = listDogDao.getAllListDogFromDB()
    val mLiveDataImageDog = imageDogDao.getAllImageDogFromDB()


    fun obtainDataInternet() {
        service.getDataFromApi().enqueue(object : Callback<ListDog>   {
            override fun onFailure(call: Call<ListDog>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<ListDog>, response: Response<ListDog>) {
                TODO("Not yet implemented")
            }


        })


    }
}