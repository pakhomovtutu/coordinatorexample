package com.example.bottommenucoordinator

import android.graphics.Rect
import android.util.TypedValue
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class FirstElementSpaceDecorator: RecyclerView.ItemDecoration() {


    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view)

        if(position == 0) {
            outRect.top += TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                56f, // высота тулбара
                parent.context.resources.displayMetrics
            ).toInt()
        }
    }
}