package com.example.widgetsapplication.widgetPackage

import android.content.Intent
import android.widget.RemoteViewsService
import androidx.lifecycle.ViewModelProvider
import com.example.widgetsapplication.repository.AnimeRepository
import com.example.widgetsapplication.widgetPackage.StackRemoteViewsFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class StackWidgetService : RemoteViewsService() {

    @Inject
    lateinit var animeRepository: AnimeRepository

    override fun onGetViewFactory(intent: Intent?): RemoteViewsFactory =
        StackRemoteViewsFactory(this.applicationContext, animeRepository)


}


