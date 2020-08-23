package com.nlgtuankiet.fera.core.epoxy.view

import android.content.Context
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
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
) : AppCompatEditText(context, attributeSet) {
  init {
    isFocusable = true
    isFocusableInTouchMode = true
  }

  @ModelProp
  fun setContent(value: String) {
    if (!hasFocus()) {
      setText(value, BufferType.EDITABLE)
    }
  }

  @ModelProp
  @JvmOverloads
  fun setInputMode(type: Int = InputType.TYPE_CLASS_TEXT) {
    inputType = type
  }

  @ModelProp
  fun setImeOption(value: Int) {
    imeOptions = value
  }

  @CallbackProp
  override fun setOnEditorActionListener(l: OnEditorActionListener?) {
    super.setOnEditorActionListener(l)
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
