package me.firdaus1453.koinsample.domain.router

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager

/**
 * Created by firdaus1453 on 2/17/2019.
 */

// TODO Mensederhanakan pengambilan data dari activity sebelumnya
fun FragmentManager.openFragment(
    container: Int,
    fragment: Fragment,
    bundle: Bundle? = null) {

    if (bundle != null){
        fragment.arguments = bundle
    }

    val transaction = beginTransaction()
    transaction.replace(container,fragment)
    transaction.addToBackStack(null)
    transaction.commit()
}