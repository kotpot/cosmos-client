package org.kotpot.cosmos.desktop.ui.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.input.pointer.PointerInputChange
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun CosmosSlider(
    value: Float,
    onValueChange: (Float) -> Unit,
    enabled: Boolean = true,
    valueRange: ClosedFloatingPointRange<Float> = 0f..1f,
    onValueChangeFinished: (() -> Unit)? = null,
    railColor: Color = MaterialTheme.colorScheme.outlineVariant,
    trackColor: Color = MaterialTheme.colorScheme.primary,
    railHeight: Dp = 1.dp,
    trackHeight: Dp = 3.dp,
    modifier: Modifier = Modifier,
) {
    Slider(
        value = value,
        onValueChange = { progress, _ ->
            onValueChange(progress)
        },
        enabled = enabled,
        valueRange = valueRange,
        onValueChangeFinished = onValueChangeFinished,
        railColor = railColor,
        trackColor = trackColor,
        railHeight = railHeight,
        trackHeight = trackHeight,
        modifier = modifier,
    )
}

@Composable
private fun Slider(
    value: Float,
    onValueChange: (Float, Offset) -> Unit,
    enabled: Boolean = true,
    valueRange: ClosedFloatingPointRange<Float> = 0f..1f,
    onValueChangeFinished: (() -> Unit)? = null,
    railColor: Color = MaterialTheme.colorScheme.outlineVariant,
    trackColor: Color = MaterialTheme.colorScheme.primary,
    railHeight: Dp = 1.dp,
    trackHeight: Dp = 3.dp,
    modifier: Modifier = Modifier
) {
    val onValueChangeState = rememberUpdatedState(onValueChange)
    val onValueChangeFinishedState by rememberUpdatedState(onValueChangeFinished)

    BoxWithConstraints(
        modifier = modifier
            .requiredSizeIn(
                minWidth = 20.dp,
                maxHeight = trackHeight
            ),
        contentAlignment = Alignment.CenterStart
    ) {
        val width = constraints.maxWidth.toFloat()
        val trackStart = 0f
        val trackEnd = width - trackStart

        fun scaleToUserValue(offset: Float) =
            scale(trackStart, trackEnd, offset, valueRange.start, valueRange.endInclusive)

        fun scaleToOffset(userValue: Float) =
            scale(valueRange.start, valueRange.endInclusive, userValue, trackStart, trackEnd)

        val rawOffset = remember { mutableStateOf(scaleToOffset(value)) }

        LaunchedEffect(valueRange) {
            onValueChangeState.value(
                value,
                Offset(x = rawOffset.value.coerceIn(trackStart, trackEnd), y = 0f)
            )
        }

        val coerced = value.coerceIn(valueRange.start, valueRange.endInclusive)
        val fraction = calculateFraction(valueRange.start, valueRange.endInclusive, coerced)

        val dragModifier = Modifier
            .pointerInput(Unit) {
                detectDragGestures(
                    onDrag = { change: PointerInputChange, _: Offset ->
                        if (enabled) {
                            rawOffset.value = trackEnd - change.position.x
                            val offsetInTrack = rawOffset.value.coerceIn(trackStart, trackEnd)
                            onValueChangeState.value.invoke(
                                scaleToUserValue(offsetInTrack),
                                Offset(rawOffset.value.coerceIn(trackStart, trackEnd), 0f)
                            )
                        }

                    },
                    onDragEnd = {
                        if (enabled) {
                            onValueChangeFinishedState?.invoke()
                        }
                    }
                )
            }
            .pointerInput(Unit) {
                detectTapGestures { position: Offset ->
                    if (enabled) {
                        rawOffset.value = trackEnd - position.x
                        val offsetInTrack = rawOffset.value.coerceIn(trackStart, trackEnd)
                        onValueChangeState.value.invoke(
                            scaleToUserValue(offsetInTrack),
                            Offset(rawOffset.value.coerceIn(trackStart, trackEnd), 0f)
                        )
                        onValueChangeFinishedState?.invoke()
                    }
                }
            }

        SliderImpl(
            progress = fraction,
            railColor = railColor,
            trackColor = trackColor,
            railHeight = railHeight,
            trackHeight = trackHeight,
            modifier = dragModifier,
        )
    }
}

@Composable
private fun SliderImpl(
    progress: Float,
    railHeight: Dp,
    trackHeight: Dp,
    railColor: Color,
    trackColor: Color,
    modifier: Modifier = Modifier
) {
    Box(
        modifier
            .heightIn(
                max = trackHeight
                    .coerceAtLeast(3.dp)
            )
    ) {
        Track(
            fraction = progress,
            railColor = railColor,
            trackColor = trackColor,
            railHeight = railHeight,
            trackHeight = trackHeight,
            modifier = Modifier
                .height(trackHeight)
                .fillMaxWidth()
                .align(Alignment.CenterStart)
        )
    }
}

@Composable
private fun Track(
    fraction: Float,
    railColor: Color,
    trackColor: Color,
    railHeight: Dp,
    trackHeight: Dp,
    modifier: Modifier = Modifier
) {
    Canvas(modifier = modifier) {
        val width = size.width

        val centerY = center.y

        val sliderLeft = Offset(0f, centerY)
        val sliderRight = Offset(width.coerceAtLeast(0f), centerY)

        val sliderValue = Offset(
            sliderLeft.x + (sliderRight.x - sliderLeft.x) * fraction,
            center.y
        )

        // Rail
        drawLine(
            color = railColor,
            start = sliderLeft,
            end = sliderRight,
            strokeWidth = railHeight.toPx(),
            cap = StrokeCap.Round
        )

        // Track
        drawLine(
            color = trackColor,
            start = sliderLeft,
            end = sliderValue,
            strokeWidth = trackHeight.toPx(),
            cap = StrokeCap.Round
        )
    }
}

fun calculateFraction(start: Float, end: Float, pos: Float) =
    (if (end - start == 0f) 0f else (pos - start) / (end - start)).coerceIn(0f, 1f)

internal fun lerp(start: Float, end: Float, amount: Float): Float {
    return (1 - amount) * start + amount * end
}

internal fun scale(start1: Float, end1: Float, pos: Float, start2: Float, end2: Float) =
    lerp(start2, end2, calculateFraction(start1, end1, pos))