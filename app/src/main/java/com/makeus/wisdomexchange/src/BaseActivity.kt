package com.makeus.wisdomexchange.src

import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {
    fun showCustomToast(message: String?) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        if (currentFocus != null)
            inputMethodManager.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)

        return super.onTouchEvent(event)
    }
}