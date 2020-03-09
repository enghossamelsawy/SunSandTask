package com.task.sunsporttask.base.ext

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImageWithCaredEdgeFormResources(
    path: String?,
    placeHolderResource: Int = -1
) {
    Glide.with(this.context)
        .load(path)
        .override(this.width, this.height)
        .centerInside()
        .placeholder(placeHolderResource)
        .into(this)
}