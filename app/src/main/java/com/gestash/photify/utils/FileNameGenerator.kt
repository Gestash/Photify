package com.gestash.photify.utils

import java.io.File


class FileNameGenerator(private val cacheDir: File) {

    fun getImageFile(fileName: String): File {
        return File(cacheDir, fileName)
    }

    fun saveImageFile(fileName: String, data: ByteArray): File {
        val file = File(cacheDir, fileName)
        file.createNewFile()
        file.writeBytes(data)
        return file
    }
}