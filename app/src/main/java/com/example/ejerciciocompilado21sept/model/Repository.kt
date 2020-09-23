package com.example.ejerciciocompilado21sept.model

import androidx.lifecycle.LiveData
import retrofit2.Call
import retrofit2.Response


class Repository(private val ListDogDao: ListDogDao ) {
    private val service = RetrofitClient.getRetrofitCliente()
    val mLiveData = ListDogDao.getAllListDogFromDB()

    fun obtainListDoginByID(id: String): LiveData<ListDog> {
        return ListDogDao.getListDogByID(id)
    }

    //aquivalaviejaconfiable
    fun getDataFromServer() {
        val call = service.getDataFromApi()
        call.enqueue(object : retrofit2.Callback<ListDog> {
            override fun onFailure(call: Call<ListDog>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<ListDog>, response: Response<ListDog>) {
                TODO("Not yet implemented")
            }


        })
    }
}


