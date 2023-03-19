package com.example.callforinternet.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.callforinternet.domain.model.SaveUserNameParam
import com.example.callforinternet.domain.usecase.GetUserUseCase
import com.example.callforinternet.domain.usecase.SaveUserUseCase

class MainActivityViewModel(
    private val getUserUseCase: GetUserUseCase,
    private val setUserUseCase: SaveUserUseCase
) : ViewModel() {

    private var getDataMutable = MutableLiveData<String>()
    val getDataLive: LiveData<String> = getDataMutable

    init {
        getData()
    }

    fun getData(){
        getDataMutable.value = getUserUseCase.execute().firstName
    }

    fun saveData(string: String){
        val result = setUserUseCase.execute(SaveUserNameParam(string))
        getDataMutable.value = "Save result $result"
    }
}