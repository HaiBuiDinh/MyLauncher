package com.ohno.mylauncher

import android.graphics.drawable.Drawable

data class AppInfo(
    val label: CharSequence,
    val packageName: CharSequence,
    val icon: Drawable
)
