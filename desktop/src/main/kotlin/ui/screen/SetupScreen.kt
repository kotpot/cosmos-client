package org.kotpot.cosmos.desktop.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.FrameWindowScope
import androidx.compose.ui.window.WindowState
import org.kotpot.cosmos.desktop.ui.component.AppTopBar
import org.kotpot.cosmos.desktop.ui.component.LargeTextField
import org.kotpot.cosmos.desktop.ui.component.SimpleButton
import org.kotpot.cosmos.desktop.ui.theme.Monorale

@Composable
fun FrameWindowScope.Setup(
    windowState: WindowState,
    exitApplication: () -> Unit
) {
    var text by remember {
        mutableStateOf("")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .border(1.dp, MaterialTheme.colorScheme.outline, MaterialTheme.shapes.small)
            .background(MaterialTheme.colorScheme.inverseOnSurface, MaterialTheme.shapes.small)
    ) {
        AppTopBar(
            windowState,
            { exitApplication() }
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 154.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Let’s listen together",
                style = TextStyle(
                    fontFamily = Monorale,
                    fontSize = 64.sp,
                    lineHeight = 64.sp,
                    fontWeight = FontWeight.SemiBold
                ),
                modifier = Modifier.padding(bottom = 24.dp)
            )
            Text(
                text = "Enter your broadcast server link down below to get started",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(bottom = 24.dp)
            )
            LargeTextField(
                textFieldValue = text,
                onTextFieldValueChange = { text = it },
                hintText = "https://example.com/",
                showSearchIcon = false,
                modifier = Modifier
                    .padding(bottom = 64.dp)
                    .width(450.dp)
                    .height(40.dp)
            )
            SimpleButton(
                text = "JOIN",
                icon = "icon/ic_arrow_forward.svg",
                modifier = Modifier
                    .clip(MaterialTheme.shapes.small)
                    .clickable { }
                    .background(MaterialTheme.colorScheme.primary, MaterialTheme.shapes.small)
                    .border(1.dp, MaterialTheme.colorScheme.outline, MaterialTheme.shapes.small)
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            )
        }
    }
}