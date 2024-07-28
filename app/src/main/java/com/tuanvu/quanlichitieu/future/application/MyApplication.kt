package com.tuanvu.quanlichitieu.future.application

import android.app.Application
import android.util.Log
import com.its.baseapp.its.preferences.SharedPreferencesManager
import com.tuanvu.quanlichitieu.future.database.AppDatabase
import com.tuanvu.quanlichitieu.future.database.repositories.TableUserRepository

class MyApplication : Application() {

    companion object {
        lateinit var instanceApp: MyApplication
        lateinit var instanceSharePreference: SharedPreferencesManager
    }
    val database by lazy { AppDatabase.getDatabase(this) }
    val tableUserRepository by lazy { TableUserRepository(database.tableUserDao()) }


    override fun onCreate() {
        super.onCreate()
        Log.d("VuLT", "onCreate: ")
        instanceApp = this
        instanceSharePreference = SharedPreferencesManager(this)

    }
}