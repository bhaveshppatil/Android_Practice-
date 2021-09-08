package com.masai.taskmanagerapp

import android.app.Dialog
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.masai.taskmanagerapp.Database.DatabaseHandler
import com.masai.taskmanagerapp.adapter.TasksAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity(), ClickListener {

    lateinit var taskAdapter: TasksAdapter
    private lateinit var dialog: Dialog
    private var taskModelList = mutableListOf<TaskModel>()
    private val dbHandler = DatabaseHandler(this)

    private var title: String = ""
    private var decs: String = ""
    private var newTitle = ""
    private var newDesc = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.toolbar))
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {

            cardAddTask.visibility = View.VISIBLE

            ivCancel.setOnClickListener {
                cardAddTask.visibility = View.GONE
            }

            btnAddTask.setOnClickListener {
                title = etTaskTitle.text.toString()
                decs = etTaskDecs.text.toString()
                dbHandler.insertTaskData("Title: $title", "Description: $decs")
                updateData()
                cardAddTask.visibility = View.GONE

            }
        }

//        taskModelList = dbHandler.getAllTask()
        taskModelList.addAll(dbHandler.getAllTask())

        taskAdapter = TasksAdapter(this, taskModelList, this)
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = taskAdapter

    }

    override fun onUpdateClick(taskModel: TaskModel) {

        cardAddTask.visibility = View.VISIBLE

        ivCancel.setOnClickListener {
            cardAddTask.visibility = View.GONE
        }

        btnAddTask.setOnClickListener {

            newTitle = etTaskTitle.text.toString()
            newDesc = etTaskDecs.text.toString()

            taskModel.title = newTitle
            taskModel.decs = newDesc

            dbHandler.editTaskData(taskModel)
            updateData()

        }
    }

    override fun onDeleteClick(taskModel: TaskModel) {
        dbHandler.deleteTaskData(taskModel)
        updateData()
    }

    private fun updateData() {
        val updatedData = dbHandler.getAllTask()
        taskModelList.clear()
        taskModelList.addAll(updatedData)
        taskAdapter.notifyDataSetChanged()
    }


    private fun dataUserInput() {


    }
}