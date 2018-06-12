package net.konyan.kotilities.module

import net.konyan.frameworkandextensions.framework.BasePresenter
import net.konyan.frameworkandextensions.framework.BaseView

interface MainContract{

    interface Presenter: BasePresenter

    interface View: BaseView<Presenter>{
        fun setupRecycler(items: List<String>)
    }
}