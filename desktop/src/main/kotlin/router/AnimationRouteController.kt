package org.kotpot.cosmos.desktop.router

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import java.util.*

class AnimationRouteController<T>(
    initRouter: T,
    private val _maxSiz: Int = 2
) : RouteController<T> {

    private val _stack: Deque<T> = LinkedList(listOf(initRouter))

    private val _stackSize = mutableStateOf(_stack.size)
    override val curStackSize: State<Int> = _stackSize

    private val _curRouteState = mutableStateOf(initRouter)
    override val curRouteState: State<T> = _curRouteState

    private val _pushObs = LinkedList<Callback<T>>()
    private val _popObs = LinkedList<Callback<T>>()

    override fun push(route: T) {
        if (route == _stack.first) return
        _stack.push(route)
        for (obs in _pushObs) {
            obs.invoke(route)
        }
        if (_stack.size >= _maxSiz) {
            _stack.removeLast()
        }
        _stackSize.value = _stack.size
        _curRouteState.value = _stack.first
    }

    override fun pop() {
        if (_stack.size <= 1) return
        val item = _stack.poll()
        for (obs in _popObs) {
            obs.invoke(item)
        }
        _stackSize.value = _stack.size
        _curRouteState.value = _stack.first
    }

    fun replace(route: T) {
        val item = _stack.pop()
        for (obs in _popObs) {
            obs.invoke(item)
        }
        _stack.push(route)
        for (obs in _pushObs) {
            obs.invoke(route)
        }
        _curRouteState.value = _stack.last
    }

    override fun onPop(callback: Callback<T>) {
        _popObs.add(callback)
    }

    override fun onPush(callback: Callback<T>) {
        _pushObs.add(callback)
    }
}