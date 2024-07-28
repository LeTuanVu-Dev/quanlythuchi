package com.tuanvu.quanlichitieu.future.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.tuanvu.quanlichitieu.future.database.entity.ContactFile
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactFileDao {
    @Query("SELECT * FROM contact_histories WHERE id = :id")
    fun getContactFromId(id: Long): ContactFile

    @Query("SELECT * FROM contact_histories")
    fun getAllContact(): Flow<List<ContactFile>>

    @Insert
    fun insert(contactFile: ContactFile): Long
    @Update
    fun updateContact(contactFile: ContactFile)

    @Delete
    fun deleteContact(contactFile: ContactFile)
}
