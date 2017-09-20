package br.com.disapps.acampa.ui.commom

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.hannesdorfmann.mosby.mvp.MvpFragment
import com.hannesdorfmann.mosby.mvp.MvpPresenter
import com.hannesdorfmann.mosby.mvp.MvpView
import java.net.HttpURLConnection

/**
 * Created by diefferson on 20/09/17.
 */
abstract class AppFragment<V : MvpView, P : MvpPresenter<V>> : MvpFragment<V, P>(){

    protected var appActivityListener: IAppActivityListener? = null
        private set


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(fragmentLayout, container, false)
    }

    override  fun onAttach(context: Context) {
        super.onAttach(context)
        appActivityListener = context as IAppActivityListener
    }

    fun logout() {
        appActivityListener!!.logout()
        getActivity().finish()
    }


    protected fun setMessageContent(message: String) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show()
    }


    abstract val fragmentTag: String

    abstract val fragmentLayout: Int
}