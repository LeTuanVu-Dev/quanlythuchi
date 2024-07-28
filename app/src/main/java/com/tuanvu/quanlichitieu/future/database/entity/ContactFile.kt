package com.tuanvu.quanlichitieu.future.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "contact_histories",
)
class ContactFile(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    var phoneNumber: String,
    var contactName: String?,
    var idTemPlate:Long?
) {

}