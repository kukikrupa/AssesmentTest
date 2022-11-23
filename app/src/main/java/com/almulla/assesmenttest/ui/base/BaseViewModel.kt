package com.almulla.assesmenttest.ui.base

import android.os.Bundle
import androidx.lifecycle.ViewModel

/** This is parent view model class used to define global accessible methods at view model level  */
open class BaseViewModel : ViewModel() {
    var savedInstanceState: Bundle? = null
}