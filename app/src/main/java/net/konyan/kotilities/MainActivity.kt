package net.konyan.kotilities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import net.konyan.frameworkandextensions.extension.replaceFragmentInActivity
import net.konyan.kotilities.module.MainFragment
import net.konyan.kotilities.module.MainPresenter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainFragment = supportFragmentManager.findFragmentById(R.id.container_main)
                as MainFragment? ?: MainFragment.getInstance().also {
            replaceFragmentInActivity(it, R.id.container_main)
        }

        val presenter = MainPresenter(mainFragment)
    }
}
