package br.com.disapps.acampa.ui

import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import br.com.disapps.acampa.R
import br.com.disapps.acampa.ui.commom.AppActivity
import br.com.disapps.acampa.ui.profile.ProfileFragment
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth
import java.util.*

class MainActivity : AppActivity() {

    private val RC_SIGN_IN = 123

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val auth = FirebaseAuth.getInstance()

        container = findViewById(R.id.container)

        replaceFragment(ProfileFragment.newInstance())

    }

    fun login(){
        startActivityForResult(
                                    AuthUI.getInstance()
                            .createSignInIntentBuilder()
                            .setAvailableProviders(
                                    Arrays.asList(
                                            AuthUI.IdpConfig.Builder(AuthUI.GOOGLE_PROVIDER).build(),
                                            AuthUI.IdpConfig.Builder(AuthUI.FACEBOOK_PROVIDER).build()))
                            .build(),
                    RC_SIGN_IN)
    }

    private fun getFragmentTransaction(): FragmentTransaction {
        return supportFragmentManager.beginTransaction()
    }


}
