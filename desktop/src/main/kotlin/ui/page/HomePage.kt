package org.kotpot.cosmos.desktop.ui.page

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomePage(
    modifier: Modifier = Modifier
) {
    Column(
        modifier
    ) {
        Text(text = "Hello, world!")
    }
}