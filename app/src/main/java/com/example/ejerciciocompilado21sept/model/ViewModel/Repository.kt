package com.example.ejerciciocompilado21sept.model.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.ejerciciocompilado21sept.model.Retrofit.RetrofitClient
import com.example.ejerciciocompilado21sept.model.Room.ListDog
import com.example.ejerciciocompilado21sept.model.Room.ListDogDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository(private val listDogDao: ListDogDao){
    private val service = RetrofitClient.getRetrofitCliente()
    val mLiveData = listDogDao.getAllListDogFromDB()

    fun obtainListDogByID(id: String): LiveData<ListDog> {
        return ListDogDao.getListDogByID(id)
    }

    //aca va lavieja
    fun getDataFromServer() {
        val call = service.getDataFromApi()
        call.enqueue(object : Callback<ListDog> {
            override fun onFailure(call: Call<ListDog>, t: Throwable) {
                Log.e("Repository", t.message.toString())
            }

            override fun onResponse(call: Call<ListDog>, response: Response<ListDog>) {
                when (response.code()) {
                    in 200..299 -> CoroutineScope(Dispatchers.IO).launch {
                        response.body()?.let {
                            listDogDao.insertAllListDog(it)
                        }
                    }
                    in 300..399 -> Log.d("ERROR 300", response.errorBody().toString())
                }
            }


        })
    }

    fun getDataFromServerWithCoroutines() = CoroutineScope(Dispatchers.IO).launch {
        val service = kotlin.runCatching { service.getDataFromApiCorutines() }
        service.onSuccess {
            when (it.code()) {
                in 200..299 -> it.body()?.let { it1 -> ListDogDao.insertAllListDog(it1)}
                in 300..399 -> Log.d("ERROR", "ERROR de Parametros ETC")
            }
        }
        service.onFailure {
            Log.e("REPO_ERROR", it.message.toString())

        }
    }

}