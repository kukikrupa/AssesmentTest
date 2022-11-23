package com.almulla.assesmenttest.ui.component.main.to_do.add_task

import android.view.View
import com.almulla.assesmenttest.R
import com.almulla.assesmenttest.databinding.ActivityAddTaskBinding
import com.almulla.assesmenttest.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint


/** This activity is created for add task  */
@AndroidEntryPoint
class AddTaskActivity : BaseActivity<ActivityAddTaskBinding, AddTaskVm>(), View.OnClickListener {

    override fun getLayout(): Int {
        return R.layout.activity_add_task
    }

    override fun createViewModel(): Class<out AddTaskVm> {
        return AddTaskVm::class.java
    }

    override fun initViewBinding() {
    }


    override fun setVM(binding: ActivityAddTaskBinding) {
    }

    override fun observeViewModel() {
    }

    override fun onClick(view: View?) {

    }
}