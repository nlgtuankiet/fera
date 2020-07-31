package com.nlgtuankiet.fera.core.epoxy.view

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.widget.TextView
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.widget.doOnTextChanged
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.nlgtuankiet.fera.core.epoxy.ViewBaseModel

@ModelView(
  autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT,
  baseModelClass = ViewBaseModel::class
)
class EditText @JvmOverloads constructor(
  context: Context,
  attributeSet: AttributeSet? = null
): AppCompatEditText(context, attributeSet) {
  
  @ModelProp
  fun setContent(value: String) {
    if (!hasFocus()) {
      println("EditText setContent $value")
      setText(value, BufferType.EDITABLE)
    }
  }


  private var onTextChangeWithFocusListener: ((String) -> Unit)? = null

  private val onTextChangeWithFocusWatcher = object : TextWatcher {
    override fun afterTextChanged(s: Editable?) {

    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
      if (this@EditText.hasFocus()) {
        onTextChangeWithFocusListener?.invoke(s?.toString() ?: "")
      }

    }
  }

  @CallbackProp
  fun setOnTextChangeWithFocusListener(value: ((String) -> Unit)?) {
    onTextChangeWithFocusListener = value
    if (value == null) {
      removeTextChangedListener(onTextChangeWithFocusWatcher)
    } else {
      addTextChangedListener(onTextChangeWithFocusWatcher)
    }
  }
  
}