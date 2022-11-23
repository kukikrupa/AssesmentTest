package com.almulla.assesmenttest.ui.component.main.to_do

import android.annotation.SuppressLint
import android.view.View
import androidx.fragment.app.viewModels
import com.almulla.assesmenttest.R
import com.almulla.assesmenttest.databinding.FragmentToDoListBinding
import com.almulla.assesmenttest.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ToDoListFragment : BaseFragment<FragmentToDoListBinding>(), View.OnClickListener {

    private val toDoListBinding: ToDoListVm by viewModels()

    override fun getLayout(): Int {
        return R.layout.fragment_to_do_list
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