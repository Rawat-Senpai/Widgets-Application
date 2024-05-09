package com.example.widgetsapplication.repository

import com.example.widgetsapplication.api.AnimeApi
import com.example.widgetsapplication.utils.NetworkResult
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class AnimeRepository @Inject constructor(private val animeApi:AnimeApi) {

    private val _akatsukiResponse = MutableStateFlow<NetworkResult<>>()

}