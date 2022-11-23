package com.almulla.assesmenttest.ui.component.splash

import android.content.Intent
import android.os.Handler
import android.view.View
import com.almulla.assesmenttest.R
import com.almulla.assesmenttest.databinding.ActivitySplashBinding
import com.almulla.assesmenttest.ui.base.BaseActivity
import com.almulla.assesmenttest.ui.component.login.LoginActivity
import com.almulla.assesmenttest.utils.SPLASH_TIMER
import dagger.hilt.android.AndroidEntryPoint


/** This activity is created for splash  */
@AndroidEntryPoint
class SplashActivity : BaseActivity<ActivitySplashBinding, SplashVm>(), View.OnClickListener {

    override fun getLayout(): Int {
        return R.layout.activity_splash
    }

    override fun createViewModel(): Class<out SplashVm> {
        return SplashVm::class.java
    }

    override fun initViewBinding() {
        startNextActivity()
    }

    private fun startNextActivity() {
        Handler().postDelayed({
            startActivity(
                Intent(this, LoginActivity::class.java)
            )
            finish()
        }, SPLASH_TIMER)
    }


    override fun setVM(binding: ActivitySplashBinding) {
    }

    override fun observeViewModel() {
    }

    override fun onClick(view: View?) {

    }
}