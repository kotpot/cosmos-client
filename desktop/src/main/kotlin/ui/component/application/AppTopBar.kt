package org.kotpot.cosmos.desktop.ui.component.application

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.window.WindowDraggableArea
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.FrameWindowScope
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.WindowState
import org.kotpot.cosmos.desktop.ui.icon.Close
import org.kotpot.cosmos.desktop.ui.icon.CosmosIcons
import org.kotpot.cosmos.desktop.ui.icon.HorizontalRule
import org.kotpot.cosmos.desktop.ui.icon.Stack
import org.kotpot.cosmos.desktop.ui.theme.Monorale


@Composable
fun FrameWindowScope.AppTopBar(
    windowState: WindowState,
    exitApplication: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(Color.Transparent)
    ) {
        WindowDraggableArea(
            modifier = Modifier
                .weight(1f)
        ) {
            Logo(
                modifier = Modifier
                    .padding(start = 22.dp, top = 14.dp)
            )
        }
        WindowControl(
            modifier = Modifier
                .padding(end = 8.dp, top = 8.dp)
                .height(56.dp)
                .background(Color.Transparent),
            onMinimize = { windowState.isMinimized = true },
            onMaximize = {
                if (windowState.placement == WindowPlacement.Floating) {
                    windowState.placement = WindowPlacement.Maximized
                } else {
                    windowState.placement = WindowPlacement.Floating
                }
            },
            onClose = { exitApplication() }
        )
    }
}

@Composable
fun Logo(
    modifier: Modifier = Modifier
) {
    Row(modifier) {
        Text(
            text = "cosmos",
            fontSize = 22.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            fontFamily = Monorale,
            fontWeight = FontWeight.SemiBold
        )
        Image(
            painter = painterResource("image/title_logo.svg"),
            contentDescription = "Cosmos logo",
            modifier = Modifier.padding(start = 3.dp, top = 1.dp)
        )
    }
}

@Composable
fun WindowControl(
    modifier: Modifier = Modifier,
    onMinimize: () -> Unit,
    onMaximize: () -> Unit,
    onClose: () -> Unit,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()

    Row(modifier) {
        Column(
            modifier = Modifier
                .size(40.dp)
                .clip(RoundedCornerShape(4.dp))
                .clickable { onMinimize() },
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = CosmosIcons.HorizontalRule,
                contentDescription = "Minimize",
                tint = MaterialTheme.colorScheme.onSurface
            )
        }
        Column(
            modifier = Modifier
                .size(40.dp)
                .clip(RoundedCornerShape(4.dp))
                .clickable { onMaximize() },
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = CosmosIcons.Stack,
                contentDescription = "Maximize",
                tint = MaterialTheme.colorScheme.onSurface
            )
        }
        CompositionLocalProvider(LocalRippleTheme provides ErrorRippleTheme) {
            Column(
                modifier = Modifier
                    .size(40.dp)
                    .background(
                        when (isHovered) {
                            true -> MaterialTheme.colorScheme.error
                            false -> Color.Transparent
                        },
                        RoundedCornerShape(4.dp)
                    )
                    .clip(RoundedCornerShape(4.dp))
                    .clickable { onClose() }
                    .hoverable(interactionSource),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = CosmosIcons.Close,
                    contentDescription = "Close",
                    tint = when (isHovered) {
                        true -> MaterialTheme.colorScheme.onError
                        false -> MaterialTheme.colorScheme.onSurface
                    }
                )
            }

        }
    }
}

private object ErrorRippleTheme : RippleTheme {
    @Composable
    override fun defaultColor() =
        RippleTheme.defaultRippleColor(
            Color(0xFFBA1A1A),
            lightTheme = true
        )

    @Composable
    override fun rippleAlpha() = RippleAlpha(
        pressedAlpha = 0.24f,
        focusedAlpha = 0.24f,
        draggedAlpha = 0.16f,
        hoveredAlpha = 0.16f
    )
}