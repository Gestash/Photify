package com.gestash.photify.utils

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.gestash.photify.R

import com.gestash.photify.ui.PictureInfo
import com.gestash.photify.ui.home.PictureAdapter

@BindingAdapter("pictures")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<PictureInfo>?) {
    val adapter = recyclerView.adapter as PictureAdapter
    adapter.submitList(data)
}

@BindingAdapter("imageUri")
fun bindImage(pictureView: ImageView, imgUri: String?) {
    if (imgUri == null) {
        pictureView.visibility = View.GONE
    } else {
        val imageUri = imgUri.toUri().buildUpon().scheme("https").build()
        Glide.with(pictureView.context)
            .load(imageUri)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.loading_animation)
                    .error(R.drawable.ic_broken_image)
            )
            .into(pictureView)
    }
}