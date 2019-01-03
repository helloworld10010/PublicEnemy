package com.dnf.jarvis.publicenemy.utils

import android.support.design.widget.Snackbar
import android.view.View

fun View.showSnackBar(message: String) {
    Snackbar.make(this, message, Snackbar.LENGTH_SHORT).show()
}