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
        service.getDataFromApi().enqueue(object : Callback<DataListApi>   {
            override fun onFailure(call: Call<DataListApi>, t: Throwable) {
              Log.e("Repository",t.message.toString())
            }

            override fun onResponse(call: Call<DataListApi>, response: Response<DataListApi>) {
                Log.d("REPO", response.body().toString())
                when(response.code()) {
                    in 200..299 -> CoroutineScope(Dispatchers.IO).launch { response.body()?.
                    let{listDogDao.insertAllListDog(converter(it.message))}}
                    in 300..399 -> Log.d("ERROR 300", response.errorBody().toString() )
                }
            }

        })
    }


    fun converter(listadoperros: List<String>) : List<ListDog> {
        val listdog = mutableListOf<ListDog>( )
        listadoperros.map {
            listdog.add(ListDog(it))
        }
        return listdog
    }


}