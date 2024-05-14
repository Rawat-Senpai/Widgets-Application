package com.example.widgetsapplication.repository

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.widgetsapplication.api.AnimeApi
import com.example.widgetsapplication.models.AkatsukiResponse
import com.example.widgetsapplication.utils.NetworkResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class AnimeRepository @Inject constructor(private val animeApi:AnimeApi)  {

    private val _akatsukiResponse = MutableStateFlow<NetworkResult<AkatsukiResponse>?>(NetworkResult.Loading())
    val akatsukiResponse : StateFlow<NetworkResult<AkatsukiResponse>?> get()  =_akatsukiResponse

    suspend fun getAkatsukiMember(){
        _akatsukiResponse.value= NetworkResult.Loading()

        val response = animeApi.getAllAkatsukiMembers()

        if(response.isSuccessful){
            _akatsukiResponse.value=NetworkResult.Success(response.body())
        }else {
            _akatsukiResponse.value= NetworkResult.Error(response.toString())
        }

        Log.d("checkingDataa",response.toString())
//        else


    }


}