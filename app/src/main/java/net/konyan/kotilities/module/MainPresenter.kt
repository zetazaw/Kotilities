package net.konyan.kotilities.module

import java.util.*


class MainPresenter(private val view: MainContract.View): MainContract.Presenter{

    init {
        view.presenter = this
    }

    private var isFirst = true

    override fun start() {
        if (isFirst) view.setupRecycler(Arrays.asList("Cat", "Dog", "Tiger", "Monkey"))
        isFirst = false
    }
}