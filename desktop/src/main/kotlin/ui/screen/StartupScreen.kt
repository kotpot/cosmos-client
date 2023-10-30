package org.kotpot.cosmos.desktop.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.*
import org.kotpot.cosmos.desktop.di.appModule
import org.kotpot.cosmos.desktop.global.GlobalRouteManager
import org.kotpot.cosmos.desktop.ui.theme.Monorale
import org.kotpot.cosmos.shared.di.initKoin

private suspend fun waitInit() = withContext(Dispatchers.IO) {

    initKoin(appDeclaration = { modules(appModule) })

    // init theme config

    // init client config

    // init user

    delay(2000)
}

@Composable
fun Startup() {

    LaunchedEffect(true) {

        waitInit()

        GlobalRouteManager.animeToSetup()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Text(
                text = "cosmos",
                style = TextStyle(
                    fontFamily = Monorale,
                    fontSize = 64.sp,
                    lineHeight = 64.sp,
                    fontWeight = FontWeight.SemiBold,
                    baselineShift = BaselineShift(0.25f)
                ),
                color = MaterialTheme.colorScheme.onSurface,
            )
            Image(
                painter = painterResource("image/title_logo.svg"),
                contentDescription = null,
                modifier = Modifier.padding(start = 16.dp).height(80.dp).width(54.dp)
            )
        }
    }
}