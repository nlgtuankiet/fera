package com.nlgtuankiet.fera.image.transformer

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import androidx.annotation.ColorRes
import com.bumptech.glide.load.Key
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation
import java.security.MessageDigest

class ColorFilterTransformer(
  @ColorRes
  private val color: Int
) : BitmapTransformation() {
  override fun transform(
    pool: BitmapPool,
    toTransform: Bitmap,
    outWidth: Int,
    outHeight: Int
  ): Bitmap {
    val width = toTransform.width
    val height = toTransform.height
    val config = if (toTransform.config != null) toTransform.config else Bitmap.Config.ARGB_8888
    val bitmap = pool[width, height, config]
    bitmap.density = toTransform.density
    val canvas = Canvas(bitmap)
    val paint = Paint()
    paint.isAntiAlias = true
    paint.colorFilter = PorterDuffColorFilter(
      color,
      PorterDuff.Mode.SRC_ATOP
    )
    canvas.drawBitmap(toTransform, 0f, 0f, paint)
    return bitmap
  }

  override fun toString(): String {
    return "ColorFilterTransformation(color=$color)"
  }

  override fun equals(other: Any?): Boolean {
    return other is ColorFilterTransformer && other.color == color
  }

  override fun hashCode(): Int {
    return ID.hashCode() + color * 10
  }

  override fun updateDiskCacheKey(messageDigest: MessageDigest) {
    messageDigest.update((ID + color).toByteArray(Key.CHARSET))
  }

  companion object {
    private const val VERSION = 1
    private const val ID = "com.nlgtuankiet.fera.image.transformer.ColorFilterTransformer.$VERSION"
  }
}
