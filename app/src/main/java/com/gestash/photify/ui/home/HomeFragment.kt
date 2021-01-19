package com.gestash.photify.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gestash.photify.databinding.FragmentHomeBinding
import com.gestash.photify.utils.MarginDecoration
import org.koin.android.ext.android.inject

class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by inject()
    private val marginDecoration: MarginDecoration by inject()

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = homeViewModel
        homeViewModel.loadPicturesPath()

        binding.galleryView.addItemDecoration(marginDecoration)
        binding.galleryView.hasFixedSize()
        binding.galleryView.adapter = PictureAdapter(PictureAdapter.OnClickListener {

        })
        return binding.root
    }
}