package com.almulla.assesmenttest.ui.base

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.annotation.LayoutRes
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

/** This is parent fragment class used to define global accessible methods, vm setup, init view binding for fragments*/
abstract class BaseFragment<DB : ViewDataBinding> : Fragment() {
    lateinit var viewModel: BaseViewModel
    private lateinit var binding: DB
    open val toolbar: Toolbar?
        get() = null

    var coreActivity: BaseActivity<*, *>? = null
        private set

    abstract fun observeViewModel()
    protected abstract fun initViewBinding()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (!::binding.isInitialized) {
            binding = DataBindingUtil.inflate(inflater, getLayout(), container, false)
            binding.lifecycleOwner = this
            viewModel = ViewModelProvider(this).get(BaseViewModel::class.java)
        }
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstancState: Bundle?) {
        super.onViewCreated(view, savedInstancState)
        if (coreActivity != null) {
            if (coreActivity?.supportActionBar != null) {
            }
        }

        initViewBinding()
        observeViewModel()
    }

    @LayoutRes
    abstract fun getLayout(): Int

    fun getBinding(): DB = binding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseActivity<*, *>) {
            val activity = context as BaseActivity<*, *>?
            this.coreActivity = activity
        }
    }

    override fun onDetach() {
        coreActivity = null
        super.onDetach()
    }

}