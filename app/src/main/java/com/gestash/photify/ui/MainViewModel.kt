package com.gestash.photify.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gestash.photify.utils.GallerySaver

class MainViewModel(private val gallerySaver: GallerySaver) :
    ViewModel() {

    private val _pictures = MutableLiveData<List<PictureInfo>>()
    val pictures: LiveData<List<PictureInfo>>
        get() = _pictures

    private val _imageUri = MutableLiveData<String>()
    val imageUri: LiveData<String>
        get() = _imageUri

    init {
        loadPicturesPath()
    }

    fun loadPicturesPath() {
        try {
            val pictures = getPictures()
            val picturesInfo = pictures.map { PictureInfo(it) }.asReversed()
            _pictures.value = picturesInfo
            _imageUri.value = pictures.last()

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