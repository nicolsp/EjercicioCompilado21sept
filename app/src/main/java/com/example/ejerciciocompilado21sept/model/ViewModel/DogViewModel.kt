package com.example.ejerciciocompilado21sept.model.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.ejerciciocompilado21sept.model.Room.DogDataBase
import com.example.ejerciciocompilado21sept.model.Room.ImageDogDao
import com.example.ejerciciocompilado21sept.model.Room.ListDog
import com.example.ejerciciocompilado21sept.model.Room.ListDogDao

class DogViewModel(application: Application): AndroidViewModel(application) {

    private var repository: Repository
    init {
        val listDogDao = DogDataBase.getDataBase(application).getListDogDao()
         val imageDogDao = DogDataBase.getDataBase(application).getImageDogDao()
        repository = Repository(listDogDao,imageDogDao)
        repository.obtainDataInternet()

    }

    fun exposeLiveDataFromDatabase(): LiveData<List<ListDog>> {
        return repository.mLiveDataListDog

    }





}