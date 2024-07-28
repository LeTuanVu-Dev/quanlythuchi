package com.tuanvu.quanlichitieu.future.database.repositories

import com.tuanvu.quanlichitieu.future.database.dao.ContactFileDao
import com.tuanvu.quanlichitieu.future.database.entity.ContactFile
import kotlinx.coroutines.flow.Flow

class ContactHistoryRepository(private val contactFileDao: ContactFileDao) {
    val allContactHistories : Flow<List<ContactFile>> = contactFileDao.getAllContact()

    suspend fun insert(contactFile: ContactFile) {
        contactFileDao.insert(contactFile)
    }

    suspend fun update(contactFile: ContactFile) {
        contactFileDao.updateContact(contactFile)
    }

    suspend fun delete(contactFile: ContactFile) {
        contactFileDao.deleteContact(contactFile)
    }
}