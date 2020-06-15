package com.nlgtuankiet.fera.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nlgtuankiet.fera.R
import com.nlgtuankiet.fera.domain.interactor.GetMediaInfo
import javax.inject.Inject

class HomeFragment @Inject constructor(
  private val getMediaInfo: GetMediaInfo
) : Fragment(R.layout.home_fragment) {


}