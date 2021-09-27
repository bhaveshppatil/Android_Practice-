package com.example.moneymanager.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.moneymanager.Model.MoneyModel

@Database(entities = [MoneyModel::class], version = 1)
abstract class MoneyRoomDatabase : RoomDatabase() {

    // getMoneyTaskDAO it will generate the code that will return taskDAO interface
    abstract fun getMoneyTaskDAO(): MoneyDAO

    companion object{
        private var INSTANCE : MoneyRoomDatabase? = null
        fun getDatabaseObject(context: Context) : MoneyRoomDatabase{

            if (INSTANCE == null){
                var builder = Room.databaseBuilder(context.applicationContext, MoneyRoomDatabase::class.java, "money.db")
                builder.fallbackToDestructiveMigration()
                INSTANCE = builder.build()
                return INSTANCE!!
            }else{
                return INSTANCE!!
            }
        }
    }
}