package com.kuloglu.hungry.utils.extensions

import android.app.Activity
import androidx.appcompat.app.AlertDialog
import android.widget.Toast

fun Activity.toast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) =
        Toast.makeText(this, message, duration).show()

