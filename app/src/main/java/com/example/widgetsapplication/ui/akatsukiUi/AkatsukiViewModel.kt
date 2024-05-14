package com.example.widgetsapplication.ui.akatsukiUi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.widgetsapplication.api.AnimeApi
import com.example.widgetsapplication.models.AkatsukiResponse
import com.example.widgetsapplication.repository.AnimeRepository
import com.example.widgetsapplication.utils.NetworkResult
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AkatsukiViewModel @Inject constructor(private val animeRespsitory:AnimeRepository):ViewModel() {

    fun getAllAkatsukiMembers(){
        viewModelScope.launch {
            animeRespsitory.getAkatsukiMember()
        }
    }

    val getAllAkatsukiMember :StateFlow<NetworkResult<AkatsukiResponse>?> get() = animeRespsitory.akatsukiResponse



}