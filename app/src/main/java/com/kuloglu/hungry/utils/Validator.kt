package com.kuloglu.hungry.utils

import android.util.Patterns
import com.kuloglu.hungry.db.entities.User

class Validator {
    fun isEMailValid(emailText:String) = !emailText.isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailText).matches()

    fun isPhoneNumberValid(number:String) =!number.isNullOrEmpty() && Patterns.PHONE.matcher(number).matches()

    fun validateUserData(user:User) = isEMailValid(user.eMail) && isPhoneNumberValid(user.phoneNumber)
    fun validateUserData() = true
}