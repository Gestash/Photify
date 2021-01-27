package com.gestash.photify.utils

import android.widget.ImageButton
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target.SIZE_ORIGINAL
import com.gestash.photify.ui.PictureInfo
import com.gestash.photify.ui.home.PictureAdapter
import com.gestash.photify.ui.sliders.ScreenSliderAdapter
import com.gestash.photify.ui.sliders.TestAdapter
import com.github.chrisbanes.photoview.PhotoView
import com.squareup.picasso.Picasso

@BindingAdapter("pictures")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<PictureInfo>?) {
    val adapter = recyclerView.adapter as PictureAdapter
    adapter.submitList(data)
}

@BindingAdapter("images")
fun bindViewPager(recyclerView: RecyclerView, data: List<PictureInfo>?) {
    val adapter = recyclerView.adapter as ScreenSliderAdapter
    adapter.submitList(data)
}

//@BindingAdapter("images")
//fun bindViewPager(viewPager: ViewPager2, data: List<PictureInfo>?) {
//    val adapter = viewPager.adapter as TestAdapter
////    adapter.setData(data)
////    adapter.submitList(data)
//}

@BindingAdapter("imageUri")
fun bindImage(pictureView: ImageView, imageUri: String?) {
    Glide.with(pictureView.context)
        .load(imageUri)
        .into(pictureView)

}
@BindingAdapter("image")
fun bindSlidersImage(imageView: ImageView, image: String?) {
    Glide.with(imageView.context)
        .load(image)
        .into(imageView)
}

@BindingAdapter("lastimage")
fun bindImage(thumbnail: ImageButton, imageUri: String?) {
    Glide.with(thumbnail.context)
        .load(imageUri)
        .apply(RequestOptions.circleCropTransform())
        .into(thumbnail)

}