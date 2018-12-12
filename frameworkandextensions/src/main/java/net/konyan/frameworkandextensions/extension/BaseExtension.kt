package net.konyan.frameworkandextensions.extension

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.annotation.IdRes
import android.support.v4.app.*
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import net.konyan.frameworkandextensions.BuildConfig
import net.konyan.frameworkandextensions.framework.BasePresenter
import java.security.MessageDigest


//toast

fun Any.toast(context: Context, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(context, this.toString(), length).show()
}


private fun loggin(tag: String, message: String, level: String){
    
    when (level){
        "e" -> Log.e(tag, message)
        "i" -> Log.i(tag, message)
        "w" -> Log.w(tag, message)
        else -> Log.d(tag, message)
    }
    
}

fun FragmentActivity.logX(message: String, level: String = "d"){
    loggin(this::class.java.simpleName, message, level)
}

fun AppCompatActivity.logX(message: String, level: String = "d"){
    loggin(this::class.java.simpleName, message, level)
}

fun Fragment.logX(message: String, level: String = "d"){
    loggin(this::class.java.simpleName, message, level)
}

fun BasePresenter.logX(message: String, level: String = "d"){
    loggin(this::class.java.simpleName, message, level)
}

//fragment mvp
fun AppCompatActivity.replaceFragmentInActivity(fragment: Fragment, @IdRes frameId: Int) {
    supportFragmentManager.transact {
        replace(frameId, fragment)
    }
}

private inline fun FragmentManager.transact(action: FragmentTransaction.() -> Unit) {
    beginTransaction().apply {
        action()
    }.commit()
}

fun AppCompatActivity.addFragmentToActivity(fragment: Fragment, tag: String) {
    supportFragmentManager.transact {
        add(fragment, tag)
    }
}

fun AppCompatActivity.setupActionBar(@IdRes toolbarId: Int, action: ActionBar.() -> Unit) {
    setSupportActionBar(findViewById(toolbarId))
    supportActionBar?.run {
        action()
    }
}



//activity navigation
inline fun <reified T: Activity> AppCompatActivity.navigate(requestCode: Int = 0x007, key: String = Intent.EXTRA_INTENT, bundle: Bundle = Bundle()){
    val intent = Intent( this, T::class.java)
    intent.putExtra(key, bundle)
    startActivityForResult(intent, requestCode)
}

inline fun <reified T: Activity> FragmentActivity.navigate(requestCode: Int = 0x007, key: String = Intent.EXTRA_INTENT, bundle: Bundle = Bundle()){
    val intent = Intent( this, T::class.java)
    intent.putExtra(key, bundle)
    startActivityForResult(intent, requestCode)
}

inline fun <reified T: Activity> Fragment.navigate(requestCode: Int = 0x007, key: String = Intent.EXTRA_INTENT, bundle: Bundle = Bundle()){
    val intent = Intent( this.context, T::class.java)
    intent.putExtra(key, bundle)
    startActivityForResult(intent, requestCode)
}


//hasing

fun String.hash(type: String = "MD5"): String{
    return HashUtils.hash(this, type)
}

/**
 * Hashing Utils
 * @author Sam Clarke <www.samclarke.com>
 * @license MIT
 */
object HashUtils {
    fun hash(input: String, type: String): String{
        return when(type){
            "SHA-1" -> hashString(input, type)
            "SHA-256" -> hashString(input, type)
            "SHA-512" -> hashString(input, type)
            "MD5" -> hashString(input, type)
            else -> hashString(input, type)
        }
    }

    fun sha512(input: String) = hashString("SHA-512", input)

    fun sha256(input: String) = hashString("SHA-256", input)

    fun sha1(input: String) = hashString("SHA-1", input)

    /**
     * Supported algorithms on Android:
     *
     * Algorithm	Supported API Levels
     * MD5          1+
     * SHA-1	    1+
     * SHA-224	    1-8,22+
     * SHA-256	    1+
     * SHA-384	    1+
     * SHA-512	    1+
     */
    private fun hashString(input: String, type: String): String {
        val HEX_CHARS = "0123456789ABCDEF"
        val bytes = MessageDigest
                .getInstance(type)
                .digest(input.toByteArray())
        val result = StringBuilder(bytes.size * 2)

        bytes.forEach {
            val i = it.toInt()
            result.append(HEX_CHARS[i shr 4 and 0x0f])
            result.append(HEX_CHARS[i and 0x0f])
        }

        return result.toString()
    }
}
