package com.nlgtuankiet.fera.core.ktx

import android.os.Bundle
import androidx.fragment.app.Fragment

@Suppress("NOTHING_TO_INLINE")
inline fun Fragment.requireArguments(): Bundle = requireNotNull(arguments)
