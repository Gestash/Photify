package com.gestash.photify.ui.sliders

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.viewpager2.widget.ViewPager2
import com.gestash.photify.databinding.FragmentScreenSlidePageBinding
import com.gestash.photify.ui.home.HomeViewModel
import com.gestash.photify.utils.MarginDecoration
import org.intellij.lang.annotations.JdkConstants
import org.koin.android.ext.android.inject

class ScreenSlidePageFragment : Fragment(){

    private val viewModel: HomeViewModel by inject()
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
        viewModel.loadPicturesPath()

        binding.pager.adapter = ScreenSliderAdapter()
        binding.pager.addItemDecoration(marginDecoration)
        binding.pager.hasFixedSize()
//
//
//        viewModel.pictures.observe(viewLifecycleOwner,{
//            val data = it
//            binding.viewPager.adapter = TestAdapter(data)
////            binding.viewPager.addItemDecoration(marginDecoration)
//        })


//        binding.pager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
//            override fun onPageSelected(position: Int) {
//                super.onPageSelected(position)
//                // Теперь только необходимое
//            }
//        })

        return binding.root
    }

}

