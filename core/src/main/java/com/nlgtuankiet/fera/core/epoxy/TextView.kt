package com.nlgtuankiet.fera.core.epoxy

import android.content.Context
import android.util.AttributeSet
import androidx.annotation.ColorRes
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModel
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.StringAttributeData
import com.nlgtuankiet.fera.core.R
import com.nlgtuankiet.fera.core.ktx.wrap

@ModelView(
  autoLayout = ModelView.Size.WRAP_WIDTH_WRAP_HEIGHT,
  baseModelClass = TextBaseModel::class
)
class Body1TextView @JvmOverloads constructor(
  context: Context,
  attributeSet: AttributeSet? = null,
  defStyleAttr: Int = 0,
) : AppCompatTextView(context.wrap(R.style.Body1), attributeSet, defStyleAttr)

@ModelView(
  autoLayout = ModelView.Size.WRAP_WIDTH_WRAP_HEIGHT,
  baseModelClass = TextBaseModel::class
)
class Body2TextView @JvmOverloads constructor(
  context: Context,
  attributeSet: AttributeSet? = null,
  defStyleAttr: Int = 0,
) : AppCompatTextView(context.wrap(R.style.Body2), attributeSet, defStyleAttr)

@ModelView(
  autoLayout = ModelView.Size.WRAP_WIDTH_WRAP_HEIGHT,
  baseModelClass = TextBaseModel::class
)
class Headline1TextView @JvmOverloads constructor(
  context: Context,
  attributeSet: AttributeSet? = null,
  defStyleAttr: Int = 0,
) : AppCompatTextView(context.wrap(R.style.Headline1), attributeSet, defStyleAttr)

@ModelView(
  autoLayout = ModelView.Size.WRAP_WIDTH_WRAP_HEIGHT,
  baseModelClass = TextBaseModel::class
)
class Headline2TextView @JvmOverloads constructor(
  context: Context,
  attributeSet: AttributeSet? = null,
  defStyleAttr: Int = 0,
) : AppCompatTextView(context.wrap(R.style.Headline2), attributeSet, defStyleAttr)

@ModelView(
  autoLayout = ModelView.Size.WRAP_WIDTH_WRAP_HEIGHT,
  baseModelClass = TextBaseModel::class
)
class Headline3TextView @JvmOverloads constructor(
  context: Context,
  attributeSet: AttributeSet? = null,
  defStyleAttr: Int = 0,
) : AppCompatTextView(context.wrap(R.style.Headline3), attributeSet, defStyleAttr)

@ModelView(
  autoLayout = ModelView.Size.WRAP_WIDTH_WRAP_HEIGHT,
  baseModelClass = TextBaseModel::class
)
class Headline4TextView @JvmOverloads constructor(
  context: Context,
  attributeSet: AttributeSet? = null,
  defStyleAttr: Int = 0,
) : AppCompatTextView(context.wrap(R.style.Headline4), attributeSet, defStyleAttr)

@ModelView(
  autoLayout = ModelView.Size.WRAP_WIDTH_WRAP_HEIGHT,
  baseModelClass = TextBaseModel::class
)
class Headline5TextView @JvmOverloads constructor(
  context: Context,
  attributeSet: AttributeSet? = null,
  defStyleAttr: Int = 0,
) : AppCompatTextView(context.wrap(R.style.Headline5), attributeSet, defStyleAttr)

@ModelView(
  autoLayout = ModelView.Size.WRAP_WIDTH_WRAP_HEIGHT,
  baseModelClass = TextBaseModel::class
)
class Headline6TextView @JvmOverloads constructor(
  context: Context,
  attributeSet: AttributeSet? = null,
  defStyleAttr: Int = 0,
) : AppCompatTextView(context.wrap(R.style.Headline6), attributeSet, defStyleAttr)

@ModelView(
  autoLayout = ModelView.Size.WRAP_WIDTH_WRAP_HEIGHT,
  baseModelClass = TextBaseModel::class
)
class CaptionTextView @JvmOverloads constructor(
  context: Context,
  attributeSet: AttributeSet? = null,
  defStyleAttr: Int = 0,
) : AppCompatTextView(context.wrap(R.style.Caption), attributeSet, defStyleAttr)

@ModelView(
  autoLayout = ModelView.Size.WRAP_WIDTH_WRAP_HEIGHT,
  baseModelClass = TextBaseModel::class
)
class OverlineTextView @JvmOverloads constructor(
  context: Context,
  attributeSet: AttributeSet? = null,
  defStyleAttr: Int = 0,
) : AppCompatTextView(context.wrap(R.style.Overline), attributeSet, defStyleAttr)


abstract class TextBaseModel<T : AppCompatTextView> : EpoxyModel<T>() {

  @EpoxyAttribute
  var text: CharSequence? = null

  @EpoxyAttribute
  @ColorRes
  var color: Int? = null

  override fun bind(view: T) {
    super.bind(view)
    setText(view)
    setTextColor(view)
  }

  @Suppress("UNCHECKED_CAST")
  override fun bind(view: T, previouslyBoundModel: EpoxyModel<*>) {
    super.bind(view, previouslyBoundModel)
    val that: TextBaseModel<T> = previouslyBoundModel as TextBaseModel<T>
    if (text != that.text) {
      setText(view)
    }
    if (color != that.color) {
      setTextColor(view)
    }
  }

  private fun setText(view: T) {
    view.text = StringAttributeData(text).toString(view.context)
  }

  private fun setTextColor(view: T) {
    color?.let { view.setTextColor(ContextCompat.getColor(view.context, it)) }
  }
}
