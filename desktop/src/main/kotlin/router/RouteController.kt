package org.kotpot.cosmos.desktop.router

import androidx.compose.runtime.snapshots.SnapshotStateList


typealias Callback<T> = (T) -> Unit

interface RouteController<T : RouterDefine> {

    val stack: SnapshotStateList<T>
    val curRoute get() = stack.lastOrNull()

    val routers: Array<T>

    fun push(route: T)

    fun pop()

    fun onPush(callback: Callback<T>)

    fun onPop(callback: Callback<T>)
}