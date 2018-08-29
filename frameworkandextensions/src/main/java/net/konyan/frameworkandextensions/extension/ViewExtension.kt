package net.konyan.frameworkandextensions.extension

import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View


fun View.showSnackBar(message: String, duration: Int = Snackbar.LENGTH_SHORT) {
    Snackbar.make(this, message, duration)
}

fun <ITEM> RecyclerView.setup(items: List<ITEM>,
                              layoutResId: Int,
                              bindHolder: View.(ITEM) -> Unit,
                              setFix: Boolean = true,
                              manager: RecyclerView.LayoutManager = LinearLayoutManager(this.context))
        : GenericAdapter<ITEM> {
    return GenericAdapter.Adapter(items, layoutResId, bindHolder = bindHolder).apply {
        layoutManager = manager
        adapter = this
        setHasFixedSize(setFix)
    }
}

fun EditText.onChange(cb: (String) -> Unit){
    this.addTextChangedListener(object : TextWatcher {
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            cb(s.toString())
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { }

        override fun afterTextChanged(s: Editable?) { }
    })
}
