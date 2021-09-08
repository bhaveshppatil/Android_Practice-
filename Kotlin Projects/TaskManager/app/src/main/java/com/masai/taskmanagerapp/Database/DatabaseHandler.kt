package com.masai.taskmanagerapp.Database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import com.masai.taskmanagerapp.TaskModel

class DatabaseHandler(val context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    companion object {
        val DB_NAME = "TaskDB"
        val DB_VERSION = 1
        val TABLE_NAME = "task"
        val ID = "id"
        val TITLE = "title"
        val DECS = "decs"
    }

    override fun onCreate(db: SQLiteDatabase?) {

        val CREATE_TABLE_QUERY = "CREATE TABLE " +
                "$TABLE_NAME(" +
                "$ID INTEGER PRIMARY KEY," +
                "$TITLE TEXT, " +
                "$DECS TEXT)"

        db?.execSQL(CREATE_TABLE_QUERY)
    }

    fun insertTaskData(title: String, decs: String) {
        val db = writableDatabase
        val values = ContentValues()
        values.put(TITLE, title)
        values.put(DECS, decs)

        val idValues = db.insert(TABLE_NAME, null, values)
        if (idValues.toInt() == -1) {
            Toast.makeText(context, "Failed to insert data", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Data inserted Successfully", Toast.LENGTH_SHORT).show()

        }
    }

    fun getAllTask(): MutableList<TaskModel> {

        val taskList = mutableListOf<TaskModel>()
        val db = readableDatabase
        val query = "select * from $TABLE_NAME"

        val cursor = db?.rawQuery(query, null)

        if (cursor != null && cursor.count > 0) {
            cursor.moveToFirst()

            do {
                val id = cursor.getInt(cursor.getColumnIndex(ID))
                val title = cursor.getString(cursor.getColumnIndex(TITLE))
                val decs = cursor.getString(cursor.getColumnIndex(DECS))

                val taskModel = TaskModel()
                taskModel.id = id
                taskModel.decs = decs
                taskModel.title = title

                taskList.add(taskModel)

            } while (cursor.moveToNext())
        }
        return taskList
    }

    fun editTaskData(taskModel: TaskModel) {
        val db = writableDatabase
        val contentValues = ContentValues()
        contentValues.put(TITLE, taskModel.title)
        contentValues.put(DECS, taskModel.decs)

        val res = db.update(TABLE_NAME, contentValues, "id=${taskModel.id}", null)
        if (res == 1) {
            Toast.makeText(context, "Task Completed", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Failed to update", Toast.LENGTH_SHORT).show()
        }
    }

    fun deleteTaskData(taskModel: TaskModel) {
        val db = writableDatabase
        val res = db.delete(TABLE_NAME, "id = ${taskModel.id}", null);

        if (res == 1) {
            Toast.makeText(context, "Task Deleted Successfully", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Failed to delete", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}