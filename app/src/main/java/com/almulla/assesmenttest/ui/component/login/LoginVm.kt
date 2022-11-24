package com.almulla.assesmenttest.ui.component.login

import androidx.appcompat.app.AppCompatActivity
import com.almulla.assesmenttest.R
import com.almulla.assesmenttest.ui.base.BaseViewModel
import com.almulla.assesmenttest.utils.GOOGLE_LOGIN_REQUEST_CODE
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.Scopes
import com.google.android.gms.common.api.Scope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/** This ViewModel will handle login screen **/
@HiltViewModel
class LoginVm @Inject constructor() : BaseViewModel() {
    lateinit var gso: GoogleSignInOptions
    lateinit var mGoogleSignInClient: GoogleSignInClient
    var mGoogleSignInAccount: GoogleSignInAccount? = null

    fun onGoogleLoginClick(mActivity: AppCompatActivity) {
        configureGoogleLogin(mActivity)
        val signInIntent = mGoogleSignInClient.signInIntent
        mActivity.startActivityForResult(signInIntent, GOOGLE_LOGIN_REQUEST_CODE)
    }

    private fun configureGoogleLogin(mActivity: AppCompatActivity) {
        gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .requestIdToken(mActivity.getString(R.string.google_auth_web_clent_id))
            .requestScopes(Scope(Scopes.DRIVE_APPFOLDER))
            .requestServerAuthCode(mActivity.getString(R.string.google_auth_server_clent_id))
            .build()
        mGoogleSignInClient = GoogleSignIn.getClient(mActivity, gso)
        mGoogleSignInAccount = GoogleSignIn.getLastSignedInAccount(mActivity)
    }
}