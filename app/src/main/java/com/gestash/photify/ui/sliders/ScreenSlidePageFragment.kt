package com.gestash.photify.ui.sliders

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.PagerSnapHelper
import com.gestash.photify.databinding.FragmentScreenSlidePageBinding
import com.gestash.photify.ui.MainViewModel
import com.gestash.photify.utils.MarginDecoration
import org.koin.android.ext.android.inject

class ScreenSlidePageFragment : Fragment(){

    private val viewModel: MainViewModel by inject()
    private lateinit var binding: FragmentScreenSlidePageBinding
    private val marginDecoration: MarginDecoration by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentScreenSlidePageBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.pager.adapter = ScreenSliderAdapter()
        binding.pager.addItemDecoration(marginDecoration)
        val snapHelper = PagerSnapHelper() // Or PagerSnapHelper
        snapHelper.attachToRecyclerView(binding.pager)
        binding.pager.hasFixedSize()

        return binding.root
    }

}

