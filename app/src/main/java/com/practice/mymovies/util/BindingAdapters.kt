package com.practice.mymovies.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.practice.mymovies.R

@BindingAdapter("imageUrl")
fun ImageView.url(imageUrl: String) {
    val requestOptions = RequestOptions().placeholder(R.drawable.ic_baseline_image_search_24)
        .error(R.drawable.ic_no_image)

    Glide.with(this)
        .applyDefaultRequestOptions(requestOptions)
        .load(imageUrl)
        .into(this)
}
