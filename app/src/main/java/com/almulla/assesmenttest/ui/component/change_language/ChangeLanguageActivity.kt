package com.almulla.assesmenttest.ui.component.change_language

import android.content.Intent
import android.content.res.Configuration
import android.content.res.Resources
import android.util.DisplayMetrics
import android.view.View
import com.almulla.assesmenttest.R
import com.almulla.assesmenttest.databinding.ActivityChangeLanguageBinding
import com.almulla.assesmenttest.ui.base.BaseActivity
import com.almulla.assesmenttest.ui.component.main.MainActivity
import com.almulla.assesmenttest.utils.isEnglishLangSelected
import com.almulla.assesmenttest.utils.setIsEnglishLangSelected
import dagger.hilt.android.AndroidEntryPoint
import java.util.*


/** This activity is created for change language  */
@AndroidEntryPoint
class ChangeLanguageActivity : BaseActivity<ActivityChangeLanguageBinding, ChangeLanguageVm>(),
    View.OnClickListener {
    var myLocale: Locale? = null

    override fun getLayout(): Int {
        return R.layout.activity_change_language
    }

    override fun createViewModel(): Class<out ChangeLanguageVm> {
        return ChangeLanguageVm::class.java
    }

    override fun initViewBinding() {
        getBinding().apply {
            imageViewBack.setOnClickListener(this@ChangeLanguageActivity)
            buttonSave.setOnClickListener(this@ChangeLanguageActivity)

            if (isEnglishLangSelected().toString() == "en")
                radioButtonEnglish.isChecked = true
            else
                radioButtonArabic.isChecked = true
        }
    }

    override fun setVM(binding: ActivityChangeLanguageBinding) {
    }

    override fun observeViewModel() {
    }

    override fun onClick(view: View?) {
        getBinding().apply {
            when (view) {
                imageViewBack -> finish()
                buttonSave -> {
                    if (radioButtonEnglish.isChecked) {
                        setIsEnglishLangSelected("en")
                        setLocale("en")
                    } else {
                        setIsEnglishLangSelected("ar")
                        setLocale("ar")
                    }

                    val intent = Intent(this@ChangeLanguageActivity, MainActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                    finish()
                }
            }
        }
    }

}