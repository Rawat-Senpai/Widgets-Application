package com.example.widgetsapplication.widgetPackage

import android.content.Intent
import android.widget.RemoteViewsService
import androidx.lifecycle.ViewModelProvider
import com.example.widgetsapplication.widgetPackage.StackRemoteViewsFactory
import dagger.hilt.android.AndroidEntryPoint

class StackWidgetService : RemoteViewsService() {
    override fun onGetViewFactory(intent: Intent?): RemoteViewsFactory =
        StackRemoteViewsFactory(this.applicationContext)




}