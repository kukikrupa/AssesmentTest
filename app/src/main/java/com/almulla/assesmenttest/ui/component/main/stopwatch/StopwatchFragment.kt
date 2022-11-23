package com.almulla.assesmenttest.ui.component.main.stopwatch

import android.annotation.SuppressLint
import android.view.View
import androidx.fragment.app.viewModels
import com.almulla.assesmenttest.R
import com.almulla.assesmenttest.databinding.FragmentStopwatchBinding
import com.almulla.assesmenttest.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class StopwatchFragment : BaseFragment<FragmentStopwatchBinding>(), View.OnClickListener {

    private val stopwatchFragment: StopwatchVm by viewModels()

    override fun getLayout(): Int {
        return R.layout.fragment_stopwatch
    }

    override fun observeViewModel() {
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun initViewBinding() {

    }

    override fun onClick(view: View?) {
        getBinding().apply {
            when (view) {
            }
        }
    }

}