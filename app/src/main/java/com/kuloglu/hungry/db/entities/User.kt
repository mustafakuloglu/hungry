package com.kuloglu.hungry.db.entities

import android.telephony.PhoneNumberUtils
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class User {
    @PrimaryKey(autoGenerate = true)
    public var id: Long = 0
    var name  = ""
    var surname = ""
    var userName = ""
    var address = ""
    var eMail = ""
    var phoneNumber = ""
    var photoUrl = ""

    override fun equals(other: Any?): Boolean {
        if(other is User)
        {
           return (other.name == name &&
               other.surname ==surname &&
               other.userName == userName &&
               other.address == address &&
               other.eMail == eMail&&
               other.phoneNumber == phoneNumber&&
               other.photoUrl ==photoUrl)
        }
        return super.equals(other)
    }
}