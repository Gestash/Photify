package com.gestash.photify.ui.home

import androidx.lifecycle.ViewModel
import com.gestash.photify.ui.PictureInfo

class HomeViewModel : ViewModel() {

    val pictures = arrayListOf<PictureInfo>(PictureInfo("UrlImage"), PictureInfo("UrlImage"))


}