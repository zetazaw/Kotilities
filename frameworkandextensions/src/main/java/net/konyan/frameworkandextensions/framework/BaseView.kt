package net.konyan.frameworkandextensions.framework

import android.support.annotation.StringRes

interface BaseView<P>{
    var presenter: P
    fun setLoading(active: Boolean)
    fun showMessage(@StringRes message: Int)
}
