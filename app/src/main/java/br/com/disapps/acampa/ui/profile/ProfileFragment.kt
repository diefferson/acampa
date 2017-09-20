package br.com.disapps.acampa.ui.profile

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import br.com.disapps.acampa.R
import br.com.disapps.acampa.ui.commom.AppFragment
import br.com.disapps.acampa.ui.profile.edit.EditProfileFragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

/**
 * Created by diefferson on 20/09/17.
 */
class ProfileFragment:  AppFragment<IProfileView, ProfilePresenter>(), IProfileView{

    companion object {
        fun newInstance():ProfileFragment= ProfileFragment()
    }

    override val fragmentTag: String = ProfileFragment.javaClass.simpleName

    override val fragmentLayout: Int = R.layout.fragment_profile

    override fun createPresenter() = ProfilePresenter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setHasOptionsMenu(true)

        var profileAvatar: ImageView = view.findViewById(R.id.profile_avatar)

        Glide.with(context)
                .load("http://res.cloudinary.com/hrscywv4p/image/upload/c_limit,fl_lossy,h_1440,w_720,f_auto,q_auto/v1/1140299/14718815_1231620990235370_1598408848884952393_n_macbqf.jpg")
                .apply(RequestOptions.circleCropTransform())
                .into(profileAvatar)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.profile_menu, menu)

    }

    override  fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.action_menu_edit ->

                appActivityListener?.replaceFragment(EditProfileFragment.newInstance())
            else -> return super.onOptionsItemSelected(item)
        }

        return true

    }



}

