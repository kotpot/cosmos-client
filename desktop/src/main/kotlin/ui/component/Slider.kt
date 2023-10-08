package org.kotpot.cosmos.desktop.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times

@Composable
fun Slider(
    value: Float,
    onValueChange: (Float) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true, // TODO
    valueRange: ClosedFloatingPointRange<Float> = 0f..1f,
    onValueChangeFinished: (() -> Unit)? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    val progress = valueToFraction(value, valueRange.start, valueRange.endInclusive)
    Slider(
        modifier = modifier,
        progress = progress,
        onProgressChange = {
            onValueChange(fractionToValue(it, valueRange.start, valueRange.endInclusive))
        },
        enabled = enabled,
        onValueChangeFinished = onValueChangeFinished,
        interactionSource = interactionSource
    )
}

@Composable
private fun Slider(
    progress: Float,
    onProgressChange: (Float) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true, // TODO
    onValueChangeFinished: (() -> Unit)? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    // TODO: Refactor this component
    val currentOnProgressChange by rememberUpdatedState(onProgressChange)
    BoxWithConstraints(
        modifier = modifier.defaultMinSize(minWidth = 120.dp, minHeight = 3.dp),
        contentAlignment = Alignment.CenterStart,
        propagateMinConstraints = true
    ) {
        val width by rememberUpdatedState(minWidth)
        var dragging by remember { mutableStateOf(false) }

        fun calcProgress(offset: Offset): Float {
            return valueToFraction(offset.x, 0f, constraints.minWidth - 0f).coerceIn(0f, 1f)
        }

        Rail()

        Box(Modifier.composed {
            var offset by remember { mutableStateOf(Offset.Zero) }
            draggable(
                state = rememberDraggableState {
                    offset = Offset(x = offset.x + it, y = offset.y)
                    currentOnProgressChange(calcProgress(offset))
                },
                interactionSource = interactionSource,
                onDragStarted = {
                    dragging = true
                    offset = it
                },
                onDragStopped = {
                    dragging = false
                    onValueChangeFinished?.invoke()
                },
                orientation = Orientation.Horizontal
            )
        }.pointerInput(Unit) {
            awaitEachGesture {
                val down = awaitFirstDown()
                currentOnProgressChange(calcProgress(down.position))
            }
        }, contentAlignment = Alignment.CenterStart) {
            Track(progress, width)
        }
    }
}

@Stable
private fun fractionToValue(fraction: Float, start: Float, end: Float): Float = (end - start) * fraction + start

@Stable
private fun valueToFraction(
    value: Float, start: Float, end: Float
): Float = (value - start) / (end - start)

@Composable
private fun Rail() {
    Box(
        modifier = Modifier
            .requiredHeight(1.dp)
            .clip(RoundedCornerShape(100))
            .background(MaterialTheme.colorScheme.outlineVariant, RoundedCornerShape(100)),
        content = {}
    )
}

@Composable
private fun Track(
    fraction: Float,
    maxWidth: Dp
) {
    val width = (fraction * (maxWidth))
    Box(
        Modifier.width(width)
            .requiredHeight(3.dp)
            .background(MaterialTheme.colorScheme.primary, CircleShape)
    )
}