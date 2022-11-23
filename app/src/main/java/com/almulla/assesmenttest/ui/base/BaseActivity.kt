package com.almulla.assesmenttest.ui.base

import android.os.Bundle
import android.view.MenuItem
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProviders

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
}