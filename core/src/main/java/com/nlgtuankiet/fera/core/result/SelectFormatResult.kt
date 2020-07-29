package com.nlgtuankiet.fera.core.result

import android.os.Parcelable
import com.nlgtuankiet.fera.domain.entity.Extension
import com.nlgtuankiet.fera.domain.entity.MuxerCode
import kotlinx.android.parcel.Parcelize


@Parcelize
data class SelectFormatResult(
  val extension: Extension,
  val muxerCode: MuxerCode
) : Parcelable {
  companion object {
    const val Key = "SelectFormatResult"
  }
}