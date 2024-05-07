package com.example.widgetsapplication.widgetPackage

import android.content.Intent
import android.widget.RemoteViewsService
import com.example.widgetsapplication.widgetPackage.StackRemoteViewsFactory

class StackWidgetService : RemoteViewsService() {
    override fun onGetViewFactory(intent: Intent?): RemoteViewsFactory =
        StackRemoteViewsFactory(this.applicationContext)
}