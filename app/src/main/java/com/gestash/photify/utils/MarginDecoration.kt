package com.gestash.photify.utils

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.gestash.photify.R

class MarginDecoration(context: Context): RecyclerView.ItemDecoration() {
    private var margin = context.resources.getDimensionPixelSize(R.dimen.item_margin)

    override fun getItemOffsets(
        outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State
    ) {
        outRect[margin, margin, margin] = margin
    }
}