package com.gestash.photify.ui.sliders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gestash.photify.databinding.PagerItemBinding
import com.gestash.photify.ui.PictureInfo

class TestAdapter(private val pictures: List<PictureInfo>) :
    RecyclerView.Adapter<TestAdapter.TestViewHolder>() {


    class TestViewHolder(private var binding: PagerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(picture: PictureInfo) {
            binding.imageInfo = picture
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestViewHolder {
        return TestViewHolder(PagerItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: TestViewHolder, position: Int) {
        val pictureItem = pictures[position]
        holder.bind(pictureItem)
    }

    override fun getItemCount(): Int = pictures.size
}