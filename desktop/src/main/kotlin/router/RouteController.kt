package org.kotpot.cosmos.desktop.router

import androidx.compose.runtime.State


typealias Callback<T> = (T) -> Unit

interface RouteController<T> {

    val curRouteState: State<T>

    fun push(route: T)

    fun pop()

    fun onPush(callback: Callback<T>)

    fun onPop(callback: Callback<T>)
}