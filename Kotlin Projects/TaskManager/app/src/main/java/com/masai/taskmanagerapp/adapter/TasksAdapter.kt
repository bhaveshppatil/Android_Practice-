package com.masai.taskmanagerapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.masai.taskmanagerapp.ClickListener
import com.masai.taskmanagerapp.R
import com.masai.taskmanagerapp.TaskModel

class TasksAdapter(
    val context: Context,
    val tasksList: MutableList<TaskModel>,
    val clickListener: ClickListener
) :
    RecyclerView.Adapter<TasksAdapter.TaskViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val inflater = LayoutInflater.from(context)
        val view1: View = inflater.inflate(R.layout.task_item_row, parent, false)
        return TaskViewHolder(view1)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = tasksList.get(position)
        holder.title.text = task.title
        holder.desc.text = task.decs

        holder.btnEdit.setOnClickListener {
            clickListener.onUpdateClick(task)
        }
        holder.btnDelete.setOnClickListener {
            clickListener.onDeleteClick(task)
        }

    }

    override fun getItemCount(): Int {
        return tasksList.size
    }

    class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var title: TextView = itemView.findViewById(R.id.tvTaskTitle)
        var desc: TextView = itemView.findViewById(R.id.tvDesc)
        var btnEdit: Button = itemView.findViewById(R.id.btnEdit)
        var btnDelete: Button = itemView.findViewById(R.id.btnDelete)

    }
}