package com.example.mvvmconcept.util

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.example.mvvmconcept.R
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.student_list_item.view.*
import java.lang.Exception

fun ImageView.loadImage(url: String?, progressBar: ProgressBar) {
    Picasso.get()
        .load(url)
        .resize(400, 400)
        .centerCrop()
        .error(R.drawable.ic_baseline_error_24)
        .into(this, object : Callback {
            override fun onSuccess() {
                progressBar.visibility = View.GONE
            }

            override fun onError(e: Exception?) {
                progressBar.visibility = View.VISIBLE
            }

        })
}