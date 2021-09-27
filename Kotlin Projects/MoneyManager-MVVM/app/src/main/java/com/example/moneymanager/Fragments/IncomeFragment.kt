package com.example.moneymanager.Fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moneymanager.Database.MoneyDAO
import com.example.moneymanager.Database.MoneyRoomDatabase
import com.example.moneymanager.Model.MoneyModel
import com.example.moneymanager.R
import com.example.moneymanager.Repository.MoneyRepo
import com.example.moneymanager.ViewModels.MoneyViewModel
import com.example.moneymanager.ViewModels.MoneyViewModelFactory
import com.example.moneymanager.Views.Adapter.ClickListener
import com.example.moneymanager.Views.Adapter.MoneyAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_income.*

class IncomeFragment : Fragment(R.layout.fragment_income), ClickListener {

    private var moneyModelList = mutableListOf<MoneyModel>()
    private lateinit var moneyAdapter: MoneyAdapter

    private lateinit var roomDatabase: MoneyRoomDatabase
    lateinit var moneyDAO: MoneyDAO

    lateinit var viewModel: MoneyViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        roomDatabase = context?.let { MoneyRoomDatabase.getDatabaseObject(it) }!!
        moneyDAO = roomDatabase.getMoneyTaskDAO()

        val repo = MoneyRepo(moneyDAO)
        val viewModelFactory = MoneyViewModelFactory(repo)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MoneyViewModel::class.java)

        initViews(view)
    }

    private fun initViews(view: View) {

        view.findViewById<FloatingActionButton>(R.id.floating_action_button).setOnClickListener {

            cardAddTask.visibility = View.VISIBLE

            ivCancel.setOnClickListener {
                cardAddTask.visibility = View.GONE
            }

            btnAdd.setOnClickListener {

                val username: String = etUserName.text.toString()
                val activityName: String = etActivityName.text.toString()
                val date: String = etDate.text.toString()
                val totalIncome: Int = (etIncome.text.toString()).toUInt().toInt()
                val activityAmount: Int = (etActivityAmount.text.toString()).toUInt().toInt()

                val newMoneyModel = MoneyModel(username, activityName, date, totalIncome, activityAmount)
                viewModel.addTask(newMoneyModel)
                cardAddTask.visibility = View.GONE
            }
        }

        moneyAdapter = context?.let { MoneyAdapter(it, moneyModelList, this) }!!
        moneyRecyclerView.layoutManager = LinearLayoutManager(context)
        moneyRecyclerView.adapter = moneyAdapter

        viewModel.getTask().observe(viewLifecycleOwner, Observer {
            moneyModelList.clear()
            moneyModelList.addAll(it)
            moneyAdapter.notifyDataSetChanged()
        })
    }

    override fun editDetails(moneyModel: MoneyModel) {

        cardAddTask.visibility = View.VISIBLE
        ivCancel.setOnClickListener {
            cardAddTask.visibility = View.GONE
        }

        btnAdd.setOnClickListener {

            val eUsername: String = etUserName.text.toString()
            val eActivityName: String = etActivityName.text.toString()
            val eDate: String = etDate.text.toString()
            val eTotalIncome: Int = (etIncome.text.toString()).toUInt().toInt()
            val eActivityAmount: Int = (etActivityAmount.text.toString()).toUInt().toInt()

            moneyModel.taskName = eUsername
            moneyModel.decs = eActivityName
            moneyModel.date = eDate
            moneyModel.total_income = eTotalIncome
            moneyModel.task_amount = eActivityAmount

            viewModel.updateTask(moneyModel)

            cardAddTask.visibility = View.GONE
        }
    }

    override fun deleteActivity(moneyModel: MoneyModel) {
        viewModel.deleteTask(moneyModel)
    }
}