package org.kotpot.cosmos.desktop.router

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import java.util.*

class AnimationRouteController<T>(
    initRouter: T
) : RouteController<T> {

    private val stack: Deque<T> = LinkedList(listOf(initRouter))

    private val _curRouteState = mutableStateOf(initRouter)
    override val curRouteState: State<T> = _curRouteState

    private val _pushObs = LinkedList<Callback<T>>()
    private val _popObs = LinkedList<Callback<T>>()

    override fun push(route: T) {
        stack.push(route)
        for (obs in _pushObs) {
            obs.invoke(route)
        }
        _curRouteState.value = stack.last
    }

    override fun pop() {
        val item = stack.pop()
        for (obs in _popObs) {
            obs.invoke(item)
        }
        _curRouteState.value = stack.last
    }

    fun replace(route: T) {
        val item = stack.pop()
        for (obs in _popObs) {
            obs.invoke(item)
        }
        stack.push(route)
        for (obs in _pushObs) {
            obs.invoke(route)
        }
        _curRouteState.value = stack.last
    }

    override fun onPop(callback: Callback<T>) {
        _popObs.add(callback)
    }

    override fun onPush(callback: Callback<T>) {
        _pushObs.add(callback)
    }
}