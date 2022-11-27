package com.almulla.assesmenttest.ui.component.main

import androidx.lifecycle.MutableLiveData
import com.almulla.assesmenttest.ui.base.BaseViewModel
import com.almulla.assesmenttest.ui.component.main.to_do.Task
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/** This ViewModel will handle the main **/
@HiltViewModel
class MainVm @Inject constructor() : BaseViewModel() {
    var taskList: ArrayList<Task> = arrayListOf()
    var isValueOfTaskUpdated = MutableLiveData<Boolean>()

    public fun addTask(task: Task) {
        taskList.add(task)
        isValueOfTaskUpdated.value = true
    }

}