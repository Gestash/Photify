package com.gestash.photify.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.gestash.photify.databinding.FragmentGalleryBinding
import com.gestash.photify.ui.MainViewModel
import com.gestash.photify.utils.MarginDecoration
import org.koin.android.ext.android.inject

class GalleryFragment : Fragment() {

    private val homeViewModel: MainViewModel by inject()
    private val marginDecoration: MarginDecoration by inject()

    private lateinit var binding: FragmentGalleryBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGalleryBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = homeViewModel

        binding.galleryView.addItemDecoration(marginDecoration)
        binding.galleryView.hasFixedSize()
        binding.galleryView.adapter = PictureAdapter(PictureAdapter.OnClickListener {
            val index = it.imageUri ?: ""
            this.findNavController().navigate(GalleryFragmentDirections.actionGalleryToSlider(index))
        })

        binding.backButtonFromGallery.setOnClickListener {
            this.findNavController().navigate(GalleryFragmentDirections.actionGalleryToCamera())
        }
        return binding.root
    }
}