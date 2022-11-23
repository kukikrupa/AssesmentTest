package com.almulla.assesmenttest.ui.component.login

import android.content.Intent
import android.os.Handler
import android.view.View
import com.almulla.assesmenttest.R
import com.almulla.assesmenttest.databinding.ActivityLoginBinding
import com.almulla.assesmenttest.ui.base.BaseActivity
import com.almulla.assesmenttest.ui.component.main.MainActivity
import com.almulla.assesmenttest.utils.SPLASH_TIMER
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
        startMainActivity()

    }

    override fun observeViewModel() {
    }

    override fun onClick(view: View?) {

    }

    override fun setVM(binding: ActivityLoginBinding) {
    }

    private fun startMainActivity() {
        Handler().postDelayed({
            startActivity(
                Intent(this, MainActivity::class.java)
            )
            finish()
        }, 1000)
    }

}