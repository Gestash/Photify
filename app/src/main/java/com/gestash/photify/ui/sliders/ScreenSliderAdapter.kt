package com.gestash.photify.ui.sliders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gestash.photify.databinding.PagerItemBinding
import com.gestash.photify.ui.PictureInfo

class ScreenSliderAdapter : ListAdapter<PictureInfo, ScreenSliderAdapter.ScreenSliderViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScreenSliderViewHolder {
        return ScreenSliderViewHolder(PagerItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ScreenSliderViewHolder, position: Int) {
        val pictureItem = getItem(position)
        holder.bind(pictureItem)
    }

    class ScreenSliderViewHolder(private var binding: PagerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(picture: PictureInfo) {
            binding.imageInfo = picture
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<PictureInfo>() {
        override fun areItemsTheSame(oldItem: PictureInfo, newItem: PictureInfo): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: PictureInfo, newItem: PictureInfo): Boolean {
            return oldItem == newItem
        }
    }
}