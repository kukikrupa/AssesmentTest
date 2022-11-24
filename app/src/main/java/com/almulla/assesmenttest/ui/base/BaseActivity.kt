package com.almulla.assesmenttest.ui.base

import android.content.Intent
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.MenuItem
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProviders
import com.almulla.assesmenttest.ui.component.main.MainActivity
import com.almulla.assesmenttest.utils.isEnglishLangSelected
import java.util.*

/** This is parent activity class used to define global accessible methods, vm setup, init view binding */
abstract class BaseActivity<DB : ViewDataBinding, VM : BaseViewModel> : AppCompatActivity() {
    lateinit var viewModel: VM
    private lateinit var binding: DB
    abstract fun observeViewModel()
    protected abstract fun initViewBinding()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, getLayout())
        viewModel = ViewModelProviders.of(this).get(createViewModel())
        setVM(binding)
        viewModel.savedInstanceState = savedInstanceState
        binding.lifecycleOwner = this
        initViewBinding()
        observeViewModel()
        if (isEnglishLangSelected().toString() == "en")
            setLocale("en")
        else
            setLocale("ar")
    }

    fun setLocale(lang: String?) {
        var myLocale: Locale = Locale(lang)
        val res: Resources = resources
        val dm: DisplayMetrics = res.getDisplayMetrics()
        val conf: Configuration = res.getConfiguration()
        conf.locale = myLocale
        res.updateConfiguration(conf, dm)
        baseContext.resources.updateConfiguration(
            conf,
            baseContext.resources.displayMetrics
        )
        invalidateOptionsMenu()
    }


    @LayoutRes
    abstract fun getLayout(): Int

    fun getBinding(): DB = binding

    abstract fun setVM(binding: DB)

    abstract fun createViewModel(): Class<out VM>

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModelStore.clear()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        // refresh your views here
        super.onConfigurationChanged(newConfig)
    }
}