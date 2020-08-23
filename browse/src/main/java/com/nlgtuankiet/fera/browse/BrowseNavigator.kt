package com.nlgtuankiet.fera.browse

import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.nlgtuankiet.fera.browsetype.BrowseTypeFragmentArgs
import com.nlgtuankiet.fera.domain.entity.MediaType
import com.nlgtuankiet.fera.domain.entity.Path
import com.nlgtuankiet.fera.domain.entity.asString
import javax.inject.Inject

class BrowseNavigator @Inject constructor(
  private val fragment: BrowseFragment
) {
  private val controller: NavController?
    get() = fragment.view?.findNavController()

  fun toBrowseType(type: MediaType, path: Path? = null) {
    val args = BrowseTypeFragmentArgs(type.asString(), dir = path?.value)
    controller?.navigate(com.nlgtuankiet.fera.core.R.id.browsetype, args.toBundle())
  }
}
