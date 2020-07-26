package com.nlgtuankiet.fera.core.ktx

import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.annotation.IdRes
import androidx.core.content.ContextCompat.getSystemService
import androidx.recyclerview.widget.RecyclerView


fun <T : View> View.bind(@IdRes id: Int, initializer: ((T) -> Unit)? = null): Lazy<T> =
  lazy(LazyThreadSafetyMode.NONE) {
    val view = findViewById<T>(id).notNull()
    initializer?.invoke(view)
    view
  }

fun View.showKeyboard() {
  val imm: InputMethodManager = getSystemService(context, InputMethodManager::class.java)
    .notNull()
  imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
}

fun View.hideKeyboard() {
  val imm: InputMethodManager = getSystemService(context, InputMethodManager::class.java)
    .notNull()
  imm.hideSoftInputFromWindow(windowToken, 0)
}

fun RecyclerView.addOnScrollStateChangeListener(onChange: (newState: Int) -> Unit) {
  val listener = object : RecyclerView.OnScrollListener() {
    override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
      super.onScrollStateChanged(recyclerView, newState)
      onChange.invoke(newState)
    }
  }
  addOnScrollListener(listener)
}