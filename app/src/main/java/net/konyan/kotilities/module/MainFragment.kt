package net.konyan.kotilities.module

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.item_main.view.*
import net.konyan.frameworkandextensions.extension.logX
import net.konyan.frameworkandextensions.extension.setup
import net.konyan.kotilities.R

class MainFragment: Fragment(), MainContract.View{

    override lateinit var presenter: MainContract.Presenter

    private lateinit var recyclerMain: RecyclerView

    override fun setupRecycler(items: List<String>) {
        recyclerMain.setup(items, R.layout.item_main, { item ->
            this.findViewById<TextView>(R.id.tv_item).text = item
            this.setOnClickListener { logX("clicked $item") }
        })
    }

    override fun onStart() {
        super.onStart()
        presenter.start()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(container?.context).inflate(R.layout.fragment_main, container, false).also {
            recyclerMain = it.findViewById(R.id.rv_main)
        }
    }

    companion object {
        fun getInstance() = MainFragment()
    }
}