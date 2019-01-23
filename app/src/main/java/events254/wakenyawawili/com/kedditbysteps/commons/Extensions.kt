package events254.wakenyawawili.com.kedditbysteps.commons

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Add new method to ViewGroup called inflate,
 * Funtion will be called from an instance of the class eg container.inflate
 */
fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}