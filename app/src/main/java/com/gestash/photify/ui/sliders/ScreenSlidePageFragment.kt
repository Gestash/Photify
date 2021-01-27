package com.gestash.photify.ui.sliders

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.PagerSnapHelper
import com.gestash.photify.databinding.FragmentScreenSlidePageBinding
import com.gestash.photify.ui.MainViewModel
import com.gestash.photify.ui.dashboard.CameraFragmentDirections
import com.gestash.photify.ui.sliders.ScreenSlidePageFragmentDirections.actionSliderToGallery
import com.gestash.photify.utils.MarginDecoration
import org.koin.android.ext.android.inject


class ScreenSlidePageFragment : Fragment(){

    private val viewModel: MainViewModel by inject()
    private lateinit var binding: FragmentScreenSlidePageBinding
    private val marginDecoration: MarginDecoration by inject()

//    private val args: ScreenSlidePageFragmentArgs by navArgs()


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

        binding.allPhotosButton.setOnClickListener {
            this.findNavController().navigate(actionSliderToGallery())

        }
        binding.shareButton.setOnClickListener {  }
        binding.backButton.setOnClickListener {
            this.findNavController().navigateUp()
        }

//        val targetPhoto = args.targetImage


        binding.deleteButton.setOnClickListener { deletePhoto() }

        return binding.root
    }

    private fun deletePhoto() {
        val alert = AlertDialog.Builder(context)
        alert.setTitle("Delete file")
        alert.setMessage("Are you sure you want to delete this file?")
        alert.setCancelable(false)
        // the Yes button Fails to display
        // the Yes button Fails to display
        alert.setPositiveButton("Yes") { dialog, which -> // compiler warning this code is an Unchecked Cast

        }

        // the Cancel button Fails to display

        // the Cancel button Fails to display
        alert.setNegativeButton(
            "Cancel"
        ) { dialog, which -> dialog.cancel() }

//        return false

    }
}

