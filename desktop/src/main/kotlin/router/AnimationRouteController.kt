package org.kotpot.cosmos.desktop.router

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import java.util.LinkedList

class AnimationRouteController<T : RouterDefine>(
    override val routers: Array<T>,
    initRouter: T
) : RouteController<T> {

    private val mutableRouteStack = mutableStateListOf(initRouter)
    override val stack: SnapshotStateList<T> = mutableRouteStack

    private val _pushObs = LinkedList<Callback<T>>()
    private val _popObs = LinkedList<Callback<T>>()

    override fun push(route: T) {
        stack.add(stack.lastIndex, route)
        for (obs in _pushObs) {
            obs.invoke(route)
        }
    }

    override fun pop() {
        val item = stack.removeLast()
        for (obs in _popObs) {
            obs.invoke(item)
        }
    }

    fun replace(route: T) {
        val old = stack.removeLast()
        stack.add(route)
        for (obs in _pushObs) {
            obs.invoke(route)
        }
        for (obs in _popObs) {
            obs.invoke(old)
        }
    }

    override fun onPop(callback: Callback<T>) {
        _popObs.add(callback)
    }

    override fun onPush(callback: Callback<T>) {
        _pushObs.add(callback)
    }
}