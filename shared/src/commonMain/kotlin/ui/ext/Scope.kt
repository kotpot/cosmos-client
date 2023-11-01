package org.kotpot.cosmos.shared.ui.ext

import androidx.compose.runtime.Composable

@Composable
fun Scope(block: @Composable () -> Unit){
    block()
}