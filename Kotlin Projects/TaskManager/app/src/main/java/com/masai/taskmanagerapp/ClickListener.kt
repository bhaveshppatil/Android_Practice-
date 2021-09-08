package com.masai.taskmanagerapp

interface ClickListener {

    fun onUpdateClick(taskModel: TaskModel)
    fun onDeleteClick(taskModel: TaskModel)
}