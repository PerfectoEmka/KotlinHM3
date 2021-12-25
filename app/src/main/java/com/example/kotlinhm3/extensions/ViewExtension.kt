package com.example.kotlinhm3.extensions
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.load(s: String){
    Glide.with(this).load(s).into(this)
}

fun View.setVisibility(bool: Boolean){
    visibility = if (bool){
        View.VISIBLE
    } else {
        View.INVISIBLE
    }
}
