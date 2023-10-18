package org.kotpot.cosmos.desktop.ui.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import org.kotpot.cosmos.shared.viewmodel.ViewModel

@Composable
fun ViewModel.subscribeToComposition() {
    DisposableEffect(Unit) {
        onDispose {
            clear()
        }
    }
}