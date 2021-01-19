package com.gestash.photify.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gestash.photify.databinding.PictureItemBinding
import com.gestash.photify.ui.PictureInfo


class PictureAdapter(private val onClickListener: OnClickListener) :
    ListAdapter<PictureInfo, PictureAdapter.PictureViewHolder>(DiffCallback) {

    class PictureViewHolder(private var binding: PictureItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(picture: PictureInfo) {
            binding.pictureInfo = picture
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PictureViewHolder {
        return PictureViewHolder(PictureItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: PictureViewHolder, position: Int) {
        val pictureItem = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(pictureItem)
        }
        holder.bind(pictureItem)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<PictureInfo>() {
        override fun areItemsTheSame(oldItem: PictureInfo, newItem: PictureInfo): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: PictureInfo, newItem: PictureInfo): Boolean {
            return oldItem == newItem
        }
    }

    class OnClickListener(val clickListener: (picture: PictureInfo) -> Unit) {
        fun onClick(picture: PictureInfo) = clickListener(picture)
    }
}