package com.kg.malikov.mukminapp.utils

import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.kg.malikov.mukminapp.R
import com.kg.malikov.mukminapp.base.BaseChangeFragment
import com.kg.malikov.mukminapp.base.BaseFragment
import java.lang.reflect.ParameterizedType

fun Fragment.showToast(message: String) {
    Toast.makeText(this.context, message, Toast.LENGTH_SHORT).show()
}

internal fun BottomNavigationView.checkItem(actionId: Int) {
    menu.findItem(actionId)?.isChecked = true
}

fun AppCompatActivity.replaceFragment(fragment: Fragment, addStack: Boolean = true) {
    if (addStack) {
        supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(
                R.id.nav_host_fragment,
                fragment
            ).commit()
    } else {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.nav_host_fragment,
                fragment
            ).commit()
    }

}

fun Fragment.replaceFragment(fragment: Fragment) {
    this.fragmentManager?.beginTransaction()
        ?.addToBackStack(null)
        ?.replace(
            R.id.nav_host_fragment,
            fragment
        )?.commit()
}

fun View.gone() {
    this.visibility = View.GONE
}

fun View.visible() {
    this.visibility = View.VISIBLE
}

internal fun <V : ViewBinding> getBinding(obj: Any, layoutInflater: LayoutInflater): V {
    val clazz = (obj.javaClass
        .genericSuperclass as ParameterizedType)
        .actualTypeArguments[0] as (Class<*>)
    try {
        return clazz.getMethod(
            "inflate",
            LayoutInflater::class.java
        ).invoke(null, layoutInflater) as V
    } catch (ex: Exception) {
        throw RuntimeException("The ViewBinding inflate function has been changed.", ex)
    }
}


internal fun <V : ViewBinding> BaseChangeFragment<V>.getBinding(): V {
    return getBinding(this, layoutInflater)
}

internal fun <V : ViewBinding> BaseFragment<V>.getBindingForBaseFragment(): V {
    return getBinding(this, layoutInflater)
}
