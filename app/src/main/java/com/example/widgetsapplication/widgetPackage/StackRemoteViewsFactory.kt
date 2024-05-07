package com.example.widgetsapplication.widgetPackage

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.widget.RemoteViews
import android.widget.RemoteViewsService
import androidx.core.os.bundleOf
import com.example.widgetsapplication.R

internal class StackRemoteViewsFactory(private val context: Context) :
    RemoteViewsService.RemoteViewsFactory {

    private val widgetItems = ArrayList<Bitmap>()

    override fun onCreate() {}

    override fun onDataSetChanged() {
        widgetItems.apply {
            add(BitmapFactory.decodeResource(context.resources, R.drawable.darth_vader))
            add(BitmapFactory.decodeResource(context.resources, R.drawable.star_wars_logo))
            add(BitmapFactory.decodeResource(context.resources, R.drawable.storm_trooper))
            add(BitmapFactory.decodeResource(context.resources, R.drawable.starwars))
            add(BitmapFactory.decodeResource(context.resources, R.drawable.falcon))
        }
    }

    override fun onDestroy() {
    }

    override fun getCount(): Int = widgetItems.size

    override fun getViewAt(position: Int): RemoteViews {
        val rv = RemoteViews(context.packageName, R.layout.widget_item)
        rv.setImageViewBitmap(R.id.image_view, widgetItems[position])

        val extras = bundleOf(ImagesBannerWidget.EXTRA_ITEM to position)
        val fillIntent = Intent()
        fillIntent.putExtras(extras)

        rv.setOnClickFillInIntent(R.id.image_view, fillIntent)
        return rv
    }

    override fun getLoadingView(): RemoteViews? = null

    override fun getViewTypeCount(): Int = 1

    override fun getItemId(position: Int): Long = 0

    override fun hasStableIds(): Boolean = false
}