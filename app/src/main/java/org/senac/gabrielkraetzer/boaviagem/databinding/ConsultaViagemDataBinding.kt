package org.senac.gabrielkraetzer.boaviagem.databinding

import android.app.Activity
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class ConsultaViagemDataBinding<out T : ViewDataBinding>(
    @LayoutRes private val resId : Int): ReadOnlyProperty<Activity, T>{

    private var binding: T? = null

    override fun getValue(thisRef: Activity, property: KProperty<*>): T = binding ?: createBinding(thisRef).also {
        binding = it
    }

    private fun createBinding(activity: Activity): T = DataBindingUtil.setContentView(activity, resId)


}