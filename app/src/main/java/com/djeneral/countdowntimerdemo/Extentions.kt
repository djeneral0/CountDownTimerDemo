package com.djeneral.countdowntimerdemo

import android.content.Context
import android.widget.Toast

fun Context.showToast(mess: String, duration: Int = Toast.LENGTH_SHORT){
    Toast.makeText(this, mess, duration).show()
}