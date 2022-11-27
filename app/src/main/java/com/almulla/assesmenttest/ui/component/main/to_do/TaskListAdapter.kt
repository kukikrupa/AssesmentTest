package com.almulla.assesmenttest.ui.component.main.to_do

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.almulla.assesmenttest.R
import kotlinx.android.synthetic.main.item_task_layout.view.*

class TaskListAdapter(val context: Context, val items: ArrayList<Task>) :
    RecyclerView.Adapter<TaskListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_task_layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items.get(position)
        holder.tvItem.text = item.name
        holder.tvDate.text = item.date

    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Holds the TextView that will add each item to
        val tvItem: TextView = view.text_view_task_name
        val tvDate: TextView = view.text_view_task_date
    }

    fun addData(list: ArrayList<Task>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

}