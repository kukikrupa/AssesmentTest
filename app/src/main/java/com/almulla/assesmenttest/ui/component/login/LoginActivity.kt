package com.almulla.assesmenttest.ui.component.login

import android.content.Intent
import android.os.Handler
import android.util.Log
import android.view.View
import com.almulla.assesmenttest.R
import com.almulla.assesmenttest.databinding.ActivityLoginBinding
import com.almulla.assesmenttest.ui.base.BaseActivity
import com.almulla.assesmenttest.ui.component.main.MainActivity
import com.almulla.assesmenttest.utils.GOOGLE_LOGIN_REQUEST_CODE
import com.almulla.assesmenttest.utils.SPLASH_TIMER
import com.almulla.assesmenttest.utils.setIsLogin
import com.almulla.assesmenttest.utils.setUserName
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint


/** This activity is created for login  */
@AndroidEntryPoint
class LoginActivity : BaseActivity<ActivityLoginBinding, LoginVm>(), View.OnClickListener {

    override fun getLayout(): Int {
        return R.layout.activity_login
    }

    override fun createViewModel(): Class<out LoginVm> {
        return LoginVm::class.java
    }

    override fun initViewBinding() {
        FirebaseAuth.getInstance().signOut()
        getBinding().btnLoginGoogle.setOnClickListener(this)
    }

    override fun observeViewModel() {
    }

    override fun onClick(view: View?) {
        getBinding().apply {
            when (view) {
                btnLoginGoogle -> viewModel.onGoogleLoginClick(this@LoginActivity)
            }
        }
    }

    override fun setVM(binding: ActivityLoginBinding) {
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            GOOGLE_LOGIN_REQUEST_CODE -> {
                val task = GoogleSignIn.getSignedInAccountFromIntent(data)
                handleGoogleSignInResult(task)
            }

        }
    }

    private fun handleGoogleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)
            val personName = account?.displayName

            setIsLogin(true)
            setUserName(personName.toString())
            // Signed in successfully, show authenticated UI.
            startActivity(Intent(this, MainActivity::class.java))
        } catch (e: ApiException) {
            e.printStackTrace()
        }

    }

}