package com.almulla.assesmenttest.ui.component.main.to_do.add_task

import android.R.id.message
import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.Intent
import android.view.View
import com.almulla.assesmenttest.R
import com.almulla.assesmenttest.databinding.ActivityAddTaskBinding
import com.almulla.assesmenttest.ui.base.BaseActivity
import com.almulla.assesmenttest.utils.NAVIGATION_TO_TASK
import com.almulla.assesmenttest.utils.TASK_DATE
import com.almulla.assesmenttest.utils.TASK_NAME
import dagger.hilt.android.AndroidEntryPoint
import java.util.*


/** This activity is created for add task  */
@AndroidEntryPoint
class AddTaskActivity : BaseActivity<ActivityAddTaskBinding, AddTaskVm>(), View.OnClickListener {
    val c = Calendar.getInstance()
    val year = c.get(Calendar.YEAR)
    val month = c.get(Calendar.MONTH)
    val day = c.get(Calendar.DAY_OF_MONTH)

    override fun getLayout(): Int {
        return R.layout.activity_add_task
    }

    override fun createViewModel(): Class<out AddTaskVm> {
        return AddTaskVm::class.java
    }

    override fun initViewBinding() {
        getBinding().apply {
            imageViewBack.setOnClickListener(this@AddTaskActivity)
            editTextTaskDateTime.setOnClickListener(this@AddTaskActivity)
            btnSave.setOnClickListener(this@AddTaskActivity)
            btnClear.setOnClickListener(this@AddTaskActivity)
        }
    }


    override fun setVM(binding: ActivityAddTaskBinding) {
    }

    override fun observeViewModel() {
    }

    override fun onClick(view: View?) {
        getBinding().apply {
            when (view) {
                imageViewBack -> finish()
                editTextTaskDateTime -> showDatePickerDialog()
                btnClear -> {
                    editTextTaskDateTime.setText("")
                    editTextTaskName.setText("")
                }
                btnSave -> {
                    if (editTextTaskDateTime.text.isEmpty() || editTextTaskName.text.isEmpty())
                        showValidationDialog()
                    else {
                        val intent = Intent()
                        intent.putExtra(TASK_NAME, editTextTaskName.text.toString())
                        intent.putExtra(TASK_DATE, editTextTaskDateTime.text.toString())
                        setResult(NAVIGATION_TO_TASK, intent)
                        finish()
                    }
                }
            }
        }
    }

    private fun showDatePickerDialog() {
        DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                getBinding().editTextTaskDateTime.setText("" + dayOfMonth + "-" + (monthOfYear + 1) + "-" + year)
            },
            year,
            month,
            day
        ).show()
    }

    private fun showValidationDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Demo App")
        builder.setMessage("Please add task name and date to proceed")

        builder.setPositiveButton(getString(R.string.ok)) { dialog, which ->
            dialog.dismiss()
        }

        builder.show()
    }
}