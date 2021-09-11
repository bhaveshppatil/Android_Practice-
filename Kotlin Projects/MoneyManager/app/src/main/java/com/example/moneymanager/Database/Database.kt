package com.example.moneymanager.Database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import com.example.moneymanager.Model.MoneyModel

class Database(val context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    companion object {
        val DB_NAME = "manager.db"
        val DB_VERSION = 1
        val TABLE_NAME = "management"
        val ID = "id"
        val USERNAME = "username"
        val TOTAL_INCOME = "income"
        val ACT_NAME = "actname"
        val ACT_AMOUNT = "amount"
        val DATE = "date"
    }

    override fun onCreate(db: SQLiteDatabase?) {

        val CREATE_TABLE = "CREATE TABLE " +
                "$TABLE_NAME (" +
                "$ID INTEGER PRIMARY KEY," +
                "$USERNAME TEXT, " +
                "$TOTAL_INCOME INTEGER, " +
                "$ACT_NAME TEXT, " +
                "$ACT_AMOUNT INTEGER, " +
                "$DATE TEXT)"

        db?.execSQL(CREATE_TABLE)
    }

    fun insertData(name: String, totalIncome: Int, ActName: String, ActAmount: Int, date: String) {
        val db = writableDatabase
        val values = ContentValues()
        values.put(USERNAME, name)
        values.put(TOTAL_INCOME, totalIncome)
        values.put(ACT_NAME, ActName)
        values.put(ACT_AMOUNT, ActAmount)
        values.put(DATE, date)

        val valuesID = db.insert(TABLE_NAME, null, values)
        if (valuesID.toInt() == -1) {
            Toast.makeText(context, "Failed to insert data", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Data inserted Successfully", Toast.LENGTH_SHORT).show()

        }
    }

    fun getAllTaskData(): MutableList<MoneyModel> {
        val moneyModelList = mutableListOf<MoneyModel>()
        val db = readableDatabase
        val query = "select * from $TABLE_NAME"
        val cursor = db?.rawQuery(query, null)

        if (cursor != null && cursor.count > 0) {
            cursor.moveToFirst()
            do {
                val id = cursor.getInt(cursor.getColumnIndex(ID))
                val name = cursor.getString(cursor.getColumnIndex(USERNAME))
                val totalIncome = cursor.getInt(cursor.getColumnIndex(TOTAL_INCOME))
                val ActName = cursor.getString(cursor.getColumnIndex(ACT_NAME))
                val ActAmount = cursor.getInt(cursor.getColumnIndex(ACT_AMOUNT))
                val date = cursor.getString(cursor.getColumnIndex(DATE))

                val moneyModel = MoneyModel()
                moneyModel.name = name
                moneyModel.totalAmount = totalIncome
                moneyModel.decs = ActName
                moneyModel.activityAmount = ActAmount
                moneyModel.date = date
                moneyModel.id = id
                moneyModelList.add(moneyModel)

            } while (cursor.moveToNext())
        }
        return moneyModelList
    }

    fun editTaskData(moneyModel: MoneyModel) {

        val db = writableDatabase
        val contentValues = ContentValues()
        contentValues.put(USERNAME, moneyModel.name)
        contentValues.put(TOTAL_INCOME, moneyModel.totalAmount)
        contentValues.put(ACT_NAME, moneyModel.decs)
        contentValues.put(ACT_AMOUNT, moneyModel.activityAmount)
        contentValues.put(DATE, moneyModel.date)

        val result = db.update(TABLE_NAME, contentValues, "id=${moneyModel.id}", null)
        if (result == 1) {
            Toast.makeText(context, "Task Completed", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Failed to update", Toast.LENGTH_SHORT).show()
        }
    }

    fun deleteTaskData(moneyModel: MoneyModel) {
        val db = writableDatabase
        val res = db.delete(TABLE_NAME, "id = ${moneyModel.id}", null);

        if (res == 1) {
            Toast.makeText(context, "Task Deleted Successfully", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Failed to delete", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}