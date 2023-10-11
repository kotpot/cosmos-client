package org.kotpot.cosmos.desktop.router

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import java.util.*

class AnimationRouteController<T>(
    initRouter: T
) : RouteController<T> {

    private val stack: Deque<T> = LinkedList(listOf(initRouter))

    private val _stackSize = mutableStateOf(stack.size)
    val stackSize: State<Int> = _stackSize

    private val _curRouteState = mutableStateOf(initRouter)
    override val curRouteState: State<T> = _curRouteState

    private val _pushObs = LinkedList<Callback<T>>()
    private val _popObs = LinkedList<Callback<T>>()

    fun updateStackSize() {
        _stackSize.value = stack.size
    }

    override fun push(route: T) {
        if (route == stack.first) return
        stack.push(route)
        for (obs in _pushObs) {
            obs.invoke(route)
        }
        if (stack.size >= 6) {
            stack.removeLast()
        }
        _curRouteState.value = stack.first
    }

    override fun pop() {
        if (stack.size == 0) return
        val item = stack.poll()
        for (obs in _popObs) {
            obs.invoke(item)
        }
        _curRouteState.value = stack.first
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