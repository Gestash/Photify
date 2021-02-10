package com.gestash.photify.ui.sliders

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.MimeTypeMap
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.PagerSnapHelper
import com.gestash.photify.databinding.FragmentScreenSlidePageBinding
import com.gestash.photify.ui.MainViewModel
import com.gestash.photify.ui.PictureInfo
import com.gestash.photify.ui.sliders.ScreenSlidePageFragmentDirections.Companion.actionSliderToCamera
import com.gestash.photify.ui.sliders.ScreenSlidePageFragmentDirections.Companion.actionSliderToGallery
import com.gestash.photify.utils.MarginDecoration
import org.koin.android.ext.android.inject
import java.io.File


class ScreenSlidePageFragment : Fragment() {

    private val viewModel: MainViewModel by inject()
    private lateinit var binding: FragmentScreenSlidePageBinding
    private val marginDecoration: MarginDecoration by inject()
    private var uri = ""

    private val args: ScreenSlidePageFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentScreenSlidePageBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        val adapter = ScreenSliderAdapter()
        binding.pager.adapter = adapter
        binding.pager.addItemDecoration(marginDecoration)
        val snapHelper = PagerSnapHelper() // Or PagerSnapHelper
        snapHelper.attachToRecyclerView(binding.pager)
        binding.pager.hasFixedSize()

        val id = args.currentFile
        Log.d("Uri from navars", "id  from navars: $id ")
        uri = "file://$id"
        viewModel.pictures.observe(viewLifecycleOwner, { list ->

            val index = list.indexOf(PictureInfo(id))
            binding.pager.scrollToPosition(index)

        })
        binding.allPhotosButton.setOnClickListener {
            this.findNavController().navigate(actionSliderToGallery())

        }
        binding.backButton.setOnClickListener {
            this.findNavController().navigate(actionSliderToCamera())
        }

        binding.shareButton.setOnClickListener { sharePhoto() }
        binding.deleteButton.setOnClickListener { deletePhoto() }

        return binding.root
    }

    private fun deletePhoto() {
//        val alert = AlertDialog.Builder(context)
//        alert.setTitle("Delete file")
//        alert.setMessage("Are you sure you want to delete this file?")
//        alert.setCancelable(false)
//        // the Yes button Fails to display
//        // the Yes button Fails to display
//        alert.setPositiveButton("Yes") { dialog, which -> // compiler warning this code is an Unchecked Cast
//
//        }
//
//        // the Cancel button Fails to display
//
//        // the Cancel button Fails to display
//        alert.setNegativeButton(
//            "Cancel"
//        ) { dialog, which -> dialog.cancel() }
//
////        return false

    }

    private fun sharePhoto() {
        val intent = Intent().apply {
            val file = File(uri)
            val mediaType = MimeTypeMap.getSingleton()
                .getMimeTypeFromExtension(file.extension)
            putExtra(Intent.EXTRA_STREAM, uri)
            type = mediaType
            action = Intent.ACTION_SEND
            flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
        }
        startActivity(Intent.createChooser(intent, "Share using"))
    }
}

