package com.gestash.photify.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gestash.photify.ui.PictureInfo
import com.gestash.photify.ui.home.PictureAdapter

@BindingAdapter("pictures")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<PictureInfo>?) {
    val adapter = recyclerView.adapter as PictureAdapter
    adapter.submitList(data)
}

@BindingAdapter("imageUri")
fun bindImage(pictureView: ImageView, imageUri: String?) {
    Glide.with(pictureView.context)
        .load(imageUri)
        .into(pictureView)

}