package br.com.disapps.acampa.ui.commom

import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.firebase.ui.auth.AuthUI
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter
import com.hannesdorfmann.mosby.mvp.MvpView

/**
 * Created by diefferson on 20/09/17.
 */
abstract class AppActivity : AppCompatActivity(), IAppActivityListener {

    protected var container: FrameLayout? = null

    override fun replaceFragment(fragment: AppFragment<*, *>) {
        val ft = fragmentTransaction

        ft.replace(container!!.id, fragment, fragment.fragmentTag)
        ft.commit()
    }

    override fun replaceAndBackStackFragment(fragment:  AppFragment<*, *>) {
        val ft = fragmentTransaction

        ft.replace(container!!.id, fragment, fragment.fragmentTag)
        ft.addToBackStack(fragment.fragmentTag)
        ft.commit()
    }

    private val fragmentTransaction: FragmentTransaction
        get() = supportFragmentManager.beginTransaction()


    override fun setTitle(title: String) {
        supportActionBar!!.setTitle(title)
    }


    override fun logout() {
        AuthUI.getInstance()
                .signOut(this)
    }

    override fun inflateView(resource: Int, viewGroup: View): View {
        val view = layoutInflater.inflate(resource, viewGroup.parent as ViewGroup, false)
        return view
    }
}
