package org.kotpot.cosmos.shared.ui.ext

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State

@Composable
fun Scope(block: @Composable () -> Unit){
    block()
}

@Composable
inline fun <reified T> StatefulWidget(
    state: Any,
    content: @Composable (T) -> Unit
){
    val value = when(state) {
        is State<*> -> state.value
        is Function0<*> -> state.invoke()
        else -> state
    }

    if (value !is T) throw IllegalArgumentException("state must be a ${T::class} value provider, but get ${state::class}")

    content(value)
}