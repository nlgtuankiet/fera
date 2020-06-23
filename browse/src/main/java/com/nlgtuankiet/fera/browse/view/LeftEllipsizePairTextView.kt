package com.nlgtuankiet.fera.browse.view

import android.content.Context
import android.text.TextUtils
import android.util.AttributeSet
import android.util.TypedValue
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import com.nlgtuankiet.fera.browse.R
import com.squareup.contour.ContourLayout
import com.squareup.contour.SizeMode

class LeftEllipsizePairTextView @JvmOverloads constructor(
  context: Context,
  attributeSet: AttributeSet? = null
) : ContourLayout(context, attributeSet) {

  private lateinit var leftTextView: AppCompatTextView
  private var leftText = ""
  private var leftStyle = -1
  private var leftTextSize = -1f
  private var leftTextColor = -1

  private lateinit var rightTextView: AppCompatTextView
  private var rightText = ""
  private var rightStyle = -1
  private var rightTextSize = -1f
  private var rightTextColor = -1

  init {
    val ta = context.theme.obtainStyledAttributes(
      attributeSet,
      R.styleable.LeftEllipsizePairTextView,
      0,
      0
    )
    try {
      leftText = ta.getString(R.styleable.LeftEllipsizePairTextView_leftText) ?: ""
      leftStyle = ta.getResourceId(R.styleable.LeftEllipsizePairTextView_leftStyle, -1)
      leftTextSize = ta.getDimension(R.styleable.LeftEllipsizePairTextView_leftTextSize, -1f)
      leftTextColor = ta.getResourceId(R.styleable.LeftEllipsizePairTextView_leftTextColor, -1)

      rightText = ta.getString(R.styleable.LeftEllipsizePairTextView_rightText) ?: ""
      rightStyle = ta.getResourceId(R.styleable.LeftEllipsizePairTextView_rightStyle, -1)
      rightTextSize = ta.getDimension(R.styleable.LeftEllipsizePairTextView_rightTextSize, -1f)
      rightTextColor = ta.getResourceId(R.styleable.LeftEllipsizePairTextView_rightTextColor, -1)
    } finally {
      ta.recycle()
    }
    rightTextView = AppCompatTextView(context)
    rightTextView.apply {
      setSingleLine()
      if (rightStyle != 0) {
        setTextAppearance(rightStyle)
      }
      if (rightTextSize != -1f) {
        setTextSize(TypedValue.COMPLEX_UNIT_PX, rightTextSize)
      }
      if (rightTextColor != -1) {
        setTextColor(ContextCompat.getColor(context, rightTextColor))
      }
      text = rightText
      applyLayout(
        x = minOf(
          leftTo { leftTextView.right() + 8.dip },
          rightTo { parent.width() }
        ),
        y = topTo { parent.top() }
      )
    }

    leftTextView = AppCompatTextView(context)
    leftTextView.apply {
      setSingleLine()
      ellipsize = TextUtils.TruncateAt.END
      if (leftStyle != 0) {
        setTextAppearance(leftStyle)
      }
      if (leftTextSize != -1f) {
        setTextSize(TypedValue.COMPLEX_UNIT_PX, leftTextSize)
      }
      if (leftTextColor != -1) {
        setTextColor(ContextCompat.getColor(context, leftTextColor))
      }
      text = leftText
      applyLayout(
        x = leftTo { parent.left() }
          .rightTo(SizeMode.AtMost) {
            parent.width() - rightTextView.width()
          },
        y = topTo { parent.top() }
      )
    }

    contourHeightOf {
      maxOf(rightTextView.height(), leftTextView.height())
    }
  }

  @Suppress("unused")
  fun setRightText(text: String) {
    rightTextView.text = text
  }

  @Suppress("unused")
  fun setLeftText(text: String) {
    leftTextView.text = text
  }
}
