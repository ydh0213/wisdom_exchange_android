package com.makeus.wisdomexchange.src

import android.graphics.Rect
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {
    fun showCustomToast(message: String?) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        val focusView = currentFocus
        if (focusView != null) {
            val rect = Rect()
            if (focusView.getGlobalVisibleRect(rect)
                && !rect.contains(ev!!.x.toInt(), ev.y.toInt())) {
                val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                if (imm.hideSoftInputFromWindow(focusView.windowToken, 0))
                    focusView.clearFocus()
            }
        }
        return super.dispatchTouchEvent(ev)
    }

    override fun onLowMemory() {
        super.onLowMemory()
        Glide.get(this).clearMemory()
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        Glide.get(this).trimMemory(level)
    }
}