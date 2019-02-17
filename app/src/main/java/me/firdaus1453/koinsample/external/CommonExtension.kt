package me.firdaus1453.koinsample.external

import android.widget.ImageView
import com.squareup.picasso.Picasso

/**
 * Created by firdaus1453 on 2/17/2019.
 */
fun ImageView.loadFromUrl(url: String?){
    Picasso.get()
        .load(url)
        .fit()
        .centerCrop()
        .into(this)
}