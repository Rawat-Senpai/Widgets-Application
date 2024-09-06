package com.example.widgetsapplication.widgetPackage

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.util.Log
import android.widget.RemoteViews
import android.widget.RemoteViewsService
import androidx.core.os.bundleOf
import com.bumptech.glide.Glide
import com.example.widgetsapplication.R
import com.example.widgetsapplication.repository.AnimeRepository
import com.example.widgetsapplication.utils.NetworkResult
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import javax.inject.Inject


internal class StackRemoteViewsFactory @Inject constructor(@ApplicationContext private val context: Context , private val animeRepository: AnimeRepository) :
    RemoteViewsService.RemoteViewsFactory {


    private val widgetItems = ArrayList<Bitmap>()
    private val imageUrls = ArrayList<String>()
    override fun onCreate() {}

    override fun onDataSetChanged() {



        widgetItems.clear()

        runBlocking {

            animeRepository.getAkatsukiMember()

            val response = animeRepository.akatsukiResponse.value

            if(response is NetworkResult.Success){
                imageUrls.clear()


                imageUrls.addAll(animeRepository.extractImageUrls(response.data))

                widgetItems.clear()

                imageUrls.forEach{url->
                    Log.d("checkingResponseImage",url.toString())
                    val bitmap = getBitmapFromUrl(url)
                    bitmap?.let {
                        widgetItems.add(it)
                    }
                }
            }

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

    private suspend fun getBitmapFromUrl(url: String): Bitmap? {

        return withContext(Dispatchers.IO) {
            try {
                val futureTarget = Glide.with(context)
                    .asBitmap()
                    .load(url)
                    .submit()

                futureTarget.get()
            } catch (e: Exception) {
                e.printStackTrace()
                null
            }
        }
    }

}