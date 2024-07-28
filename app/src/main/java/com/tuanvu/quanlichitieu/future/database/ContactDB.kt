package com.tuanvu.quanlichitieu.future.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tuanvu.quanlichitieu.future.database.dao.ContactFileDao
import com.tuanvu.quanlichitieu.future.database.entity.ContactFile
import com.tuanvu.quanlichitieu.future.ultis.Constants.NAME_DATABASE_CONTACT

@Database(entities = [ContactFile::class], version = 1, exportSchema = false)
abstract class  ContactDB : RoomDatabase() {
    abstract fun contactHistoryDao(): ContactFileDao
    companion object {
        private var db: ContactDB? = null
        fun getInstance(context: Context): ContactDB {
            if (db == null) {
                synchronized(ContactDB::class) {
                    if (db == null) {
                        db = Room.databaseBuilder(
                            context.applicationContext,
                            ContactDB::class.java,
                            NAME_DATABASE_CONTACT
                        )
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build()
                    }
                }
            }
            return db!!
        }
        fun destroyInstance() {
            db = null
        }
    }
}
val Context.contactSelectDao: ContactFileDao get() = ContactDB.getInstance(applicationContext).contactHistoryDao()