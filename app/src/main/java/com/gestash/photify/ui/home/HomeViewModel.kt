package com.gestash.photify.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gestash.photify.ui.PictureInfo
import com.gestash.photify.utils.GallerySaver

class HomeViewModel(private val gallerySaver: GallerySaver) :
    ViewModel() {

    private val _pictures = MutableLiveData<List<PictureInfo>>()
    val pictures: LiveData<List<PictureInfo>>
        get() = _pictures

    fun loadPicturesPath() {
        try {
            val pictures = getPictures()
            val picturesInfo = pictures.map { PictureInfo(it) }.asReversed()
            _pictures.value = picturesInfo
        } catch (e: Exception) {
            _pictures.value = ArrayList()
        }
    }

    private fun getPictures(): ArrayList<String> {
        val appDir = gallerySaver.getDir()
        val files = appDir.listFiles() ?: null

        val list = arrayListOf<String>()
        if (files != null) {
            for (index in files) {
                val path = index.absolutePath
                list.add(path)
            }
        }
        return list
    }
}