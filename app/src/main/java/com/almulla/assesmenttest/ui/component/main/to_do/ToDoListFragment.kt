package com.almulla.assesmenttest.ui.component.main.to_do

import android.annotation.SuppressLint
import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.almulla.assesmenttest.R
import com.almulla.assesmenttest.databinding.FragmentToDoListBinding
import com.almulla.assesmenttest.ui.base.BaseFragment
import com.almulla.assesmenttest.ui.component.main.MainVm
import com.almulla.assesmenttest.ui.component.main.to_do.add_task.AddTaskActivity
import com.almulla.assesmenttest.utils.NAVIGATION_TO_TASK
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ToDoListFragment : BaseFragment<FragmentToDoListBinding>(), View.OnClickListener {

    private val mainVM: MainVm by activityViewModels()

    override fun getLayout(): Int {
        return R.layout.fragment_to_do_list
    }

    override fun observeViewModel() {
        mainVM.isValueOfTaskUpdated.observe(viewLifecycleOwner)
        {
            addRefreshListAdapter()
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun initViewBinding() {
        getBinding().fab.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        getBinding().apply {
            when (view) {
                fab -> {
                    startActivityForResult(
                        Intent(requireActivity(), AddTaskActivity::class.java),
                        NAVIGATION_TO_TASK
                    )
                }
            }
        }
    }

    private fun addRefreshListAdapter() {
        getBinding().recyclerViewTasks.layoutManager = LinearLayoutManager(requireActivity())
        val itemAdapter = TaskListAdapter(requireActivity(), mainVM.taskList)
        getBinding().recyclerViewTasks.adapter = itemAdapter

        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val task: Task =
                    mainVM.taskList[viewHolder.adapterPosition]
                val position = viewHolder.adapterPosition
                mainVM.taskList.removeAt(viewHolder.adapterPosition)
                itemAdapter.notifyItemRemoved(viewHolder.adapterPosition)
                Toast.makeText(requireActivity(), "Task deleted successfully", Toast.LENGTH_SHORT)
                    .show()

            }
        }).attachToRecyclerView(getBinding().recyclerViewTasks)
    }


}