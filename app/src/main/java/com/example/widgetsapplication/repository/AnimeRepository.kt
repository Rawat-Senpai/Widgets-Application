package com.example.widgetsapplication.repository

import androidx.lifecycle.ViewModel
import com.example.widgetsapplication.api.AnimeApi
import com.example.widgetsapplication.utils.NetworkResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class AnimeRepository @Inject constructor(private val animeApi:AnimeApi) : ViewModel() {

    private val _akatsukiResponse = MutableStateFlow<NetworkResult<>>()
    val akatsukiResponse : StateFlow<NetworkResult<>>

}