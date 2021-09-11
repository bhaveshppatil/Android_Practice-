package com.example.moneymanager

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moneymanager.Database.Database
import com.example.moneymanager.Model.MoneyAdapter
import com.example.moneymanager.Model.MoneyModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_money_manager.*

class MoneyManager : AppCompatActivity(), ClickListener {

    private lateinit var dialog: Dialog
    private val database = Database(this)
    private var moneyModelList = mutableListOf<MoneyModel>()
    private lateinit var moneyAdapter: MoneyAdapter

    private var totalIncome: Int = 0
    private var activityAmount: Int = 0
    private var date: String = ""
    private var username: String = ""
    private var activityName: String = ""

    private var eTotalIncome: Int = 0
    private var eActivityAmount: Int = 0
    private var eDate: String = ""
    private var eUsername: String = ""
    private var eActivityName: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_money_manager)
        initViews()
    }

    private fun initViews() {

        findViewById<FloatingActionButton>(R.id.floating_action_button).setOnClickListener {

            cardAddTask.visibility = View.VISIBLE


            ivCancel.setOnClickListener {
                cardAddTask.visibility = View.GONE
            }

            btnAdd.setOnClickListener {

                username = etUserName.text.toString()
                activityName = etActivityName.text.toString()
                date = etDate.text.toString()
                totalIncome = (etIncome.text.toString()).toUInt().toInt()
                activityAmount = (etActivityAmount.text.toString()).toUInt().toInt()

                database.insertData(username, totalIncome, activityName, activityAmount, date)
                updateData()
                cardAddTask.visibility = View.GONE
            }
        }

        moneyModelList.addAll(database.getAllTaskData())
        moneyAdapter = MoneyAdapter(this, moneyModelList, this)
        moneyRecyclerView.layoutManager = LinearLayoutManager(this)
        moneyRecyclerView.adapter = moneyAdapter

    }

    override fun editDetails(moneyModel: MoneyModel) {


        cardAddTask.visibility = View.VISIBLE

        ivCancel.setOnClickListener {
            cardAddTask.visibility = View.GONE
        }

        btnAdd.setOnClickListener {

            eUsername = etUserName.text.toString()
            eActivityName = etActivityName.text.toString()
            eDate = etDate.text.toString()
            eTotalIncome = (etIncome.text.toString()).toUInt().toInt()
            eActivityAmount = (etActivityAmount.text.toString()).toUInt().toInt()

            moneyModel.name = eUsername
            moneyModel.decs = eActivityName
            moneyModel.date = eDate
            moneyModel.totalAmount = eTotalIncome
            moneyModel.activityAmount = eActivityAmount

            database.editTaskData(moneyModel)
            updateData()
        }
    }

    override fun deleteActivity(moneyModel: MoneyModel) {
        database.deleteTaskData(moneyModel)
        updateData()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun updateData() {
        val updateData = database.getAllTaskData()
        moneyModelList.clear()
        moneyModelList.addAll(updateData)
        moneyAdapter.notifyDataSetChanged()
    }
}