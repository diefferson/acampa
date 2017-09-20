package br.com.disapps.acampa.ui.commom

import android.view.View

/**
 * Created by jonathan on 13/10/16.
 */

interface IAppActivityListener {

    fun setTitle(title: String)

    fun replaceFragment(fragment: AppFragment<*, *>)

    fun replaceAndBackStackFragment(fragment: AppFragment<*, *>)

    fun inflateView(layout: Int, viewGroup: View): View

    fun logout()
}
