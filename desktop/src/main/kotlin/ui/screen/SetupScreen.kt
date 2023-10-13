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
import org.kotpot.cosmos.desktop.global.GlobalRouteManager
import org.kotpot.cosmos.desktop.locale.from
import org.kotpot.cosmos.desktop.locale.string.LocaleString
import org.kotpot.cosmos.desktop.ui.component.AppTopBar
import org.kotpot.cosmos.desktop.ui.component.LargeTextField
import org.kotpot.cosmos.desktop.ui.component.SimpleButton
import org.kotpot.cosmos.desktop.ui.icon.ArrowForward
import org.kotpot.cosmos.desktop.ui.icon.CosmosIcons
import org.kotpot.cosmos.desktop.ui.theme.Monorale

@Composable
fun FrameWindowScope.SetupScreen(
    windowState: WindowState,
    exitApplication: () -> Unit
) {
    var text by remember {
        mutableStateOf("")
    }

    AppTopBar(
        windowState,
        exitApplication
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 154.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = LocaleString::setupTitle.from(),
            style = TextStyle(
                fontFamily = Monorale,
                fontSize = 64.sp,
                lineHeight = 64.sp,
                fontWeight = FontWeight.SemiBold
            ),
            modifier = Modifier.padding(bottom = 24.dp)
        )
        Text(
            text = LocaleString::setupHint.from(),
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
            text = LocaleString::setupBtnText.from(),
            icon = CosmosIcons.ArrowForward,
            modifier = Modifier
                .clip(MaterialTheme.shapes.small)
                .clickable { GlobalRouteManager.animeToMain() }
                .background(MaterialTheme.colorScheme.primary, MaterialTheme.shapes.small)
                .border(1.dp, MaterialTheme.colorScheme.outline, MaterialTheme.shapes.small)
                .padding(horizontal = 16.dp, vertical = 8.dp)
        )
    }
}