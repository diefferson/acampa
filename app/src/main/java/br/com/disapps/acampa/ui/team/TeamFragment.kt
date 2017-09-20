package br.com.disapps.acampa.ui.team

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.disapps.acampa.R
import com.hannesdorfmann.mosby.mvp.MvpFragment

/**
 * Created by diefferson on 20/09/17.
 */
class TeamFragment: MvpFragment<ITeamView, TeamPresenter>(), ITeamView{

    companion object {
        fun newInstance():TeamFragment= TeamFragment()
    }

    override fun createPresenter(): TeamPresenter = TeamPresenter()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater!!.inflate(R.layout.fragment_team, container, false)

        return rootView
    }
}