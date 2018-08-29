package net.konyan.frameworkandextensions.framework

interface BaseView<P>{
    var presenter: P
    fun showMessage(@StringRes message: Int)
}
