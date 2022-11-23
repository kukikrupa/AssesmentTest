package com.almulla.assesmenttest.ui.component.change_language

import android.content.Intent
import android.os.Handler
import android.view.View
import com.almulla.assesmenttest.R
import com.almulla.assesmenttest.databinding.ActivityChangeLanguageBinding
import com.almulla.assesmenttest.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint


/** This activity is created for change language  */
@AndroidEntryPoint
class ChangeLanguageActivity : BaseActivity<ActivityChangeLanguageBinding, ChangeLanguageVm>(),
    View.OnClickListener {

    override fun getLayout(): Int {
        return R.layout.activity_change_language
    }

    override fun createViewModel(): Class<out ChangeLanguageVm> {
        return ChangeLanguageVm::class.java
    }

    override fun initViewBinding() {
    }

    override fun setVM(binding: ActivityChangeLanguageBinding) {
    }

    override fun observeViewModel() {
    }

    override fun onClick(view: View?) {

    }
}