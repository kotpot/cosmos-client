package org.kotpot.cosmos.ui

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


@Composable
fun BlackButton(text: String, onClick: () -> Unit) {

    Button(onClick) {

        Text(text, color = Color.White)
    }
}