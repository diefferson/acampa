package br.com.disapps.acampa.ui.profile.edit

import br.com.disapps.acampa.R
import br.com.disapps.acampa.ui.commom.AppFragment

/**
 * Created by diefferson on 20/09/17.
 */
class EditProfileFragment: AppFragment<IEditProfileView, EditProfilePresenter>(), IEditProfileView {

    override val fragmentTag: String
        get() = EditProfileFragment.javaClass.simpleName
    override val fragmentLayout: Int
        get() = R.layout.fragment_edit_profile

    companion object {
        fun newInstance(): EditProfileFragment = EditProfileFragment()
    }

    override fun createPresenter(): EditProfilePresenter = EditProfilePresenter()


}