package com.nlgtuankiet.fera.home

import androidx.annotation.Keep
import androidx.fragment.app.Fragment
import com.nlgtuankiet.fera.domain.interactor.GetMediaInfo
import javax.inject.Inject

@Keep
class HomeFragment @Inject constructor(
  private val getMediaInfo: GetMediaInfo
) : Fragment(R.layout.home_fragment) {


}