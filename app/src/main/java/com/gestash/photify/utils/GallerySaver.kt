package com.gestash.photify.utils

import android.content.Context
import android.media.MediaScannerConnection
import android.os.Environment
import android.util.Log
import java.io.File

class GallerySaver(private val context: Context) {


    fun saveToGallery(file: File) {
        val root = Environment.getExternalStorageDirectory()
        val galleryDir = File(root, "PhotiFy")
        if (!galleryDir.exists()) {
            galleryDir.mkdir()
        }
        val savedFile = File(galleryDir, file.name)
        savedFile.createNewFile()
        savedFile.writeBytes(file.readBytes())

        MediaScannerConnection.scanFile(context, arrayOf(savedFile.path), null) { path, uri ->
            Log.i("ExternalStorage", "Scanned $path:");
            Log.i("ExternalStorage", "-> uri=$uri");
        }
    }


    fun returnDir(): File {
        val root = Environment.getExternalStorageDirectory()
        val galleryDir = File(root, "PhotiFy")
        if (!galleryDir.exists()) {
            galleryDir.mkdir()
        }
        return galleryDir
//        val file = File(galleryDir, cachedFile.name)
//        file.createNewFile()
//        file.writeBytes(cachedFile.readBytes())
//
//        MediaScannerConnection.scanFile(context, arrayOf(file.path), null) { path, uri ->
//            Log.i("ExternalStorage", "Scanned $path:");
//            Log.i("ExternalStorage", "-> uri=$uri");
//        }
    }
}