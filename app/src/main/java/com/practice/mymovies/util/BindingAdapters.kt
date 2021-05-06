package com.practice.mymovies.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.practice.mymovies.R

@BindingAdapter("imageUrl")
fun ImageView.url(imageUrl: String) {
    val requestOptions = RequestOptions().placeholder(R.drawable.ic_launcher_foreground)
        .error(R.drawable.ic_launcher_background)

    Glide.with(this)
        .applyDefaultRequestOptions(requestOptions)
        .load(imageUrl)
        .into(this)
}
