package org.kotpot.cosmos.desktop.ui.component.business.room.side

import androidx.compose.animation.animateColor
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.kotpot.cosmos.shared.ui.ext.StatefulWidget
import org.kotpot.cosmos.shared.ui.ext.VerticallyAnimatedExpandable


// TODO These may be common config, and should be put into a common object

private const val DEFAULT_COLOR_ALPHA = 0.72f

private val DEFAULT_BACKGROUND_COLOR
    @Composable @ReadOnlyComposable
    get() = MaterialTheme.colorScheme.surface.copy(DEFAULT_COLOR_ALPHA)

private val DEFAULT_BORDER_COLOR
    @Composable @ReadOnlyComposable
    get() = MaterialTheme.colorScheme.surface.copy(DEFAULT_COLOR_ALPHA)

private val DEFAULT_SHAPE
    @Composable @ReadOnlyComposable
    get() = MaterialTheme.shapes.small

// Shape Ext

private val ZeroSideCorner = CornerSize(0.dp)

private val SmallTopShape
    @Composable @ReadOnlyComposable
    get() = DEFAULT_SHAPE.copy(bottomStart = ZeroSideCorner, bottomEnd = ZeroSideCorner)

private val SmallBottomShape
    @Composable @ReadOnlyComposable
    get() = DEFAULT_SHAPE.copy(topStart = ZeroSideCorner, topEnd = ZeroSideCorner)

@Composable
private fun Modifier.roomSideContentBackground() = background(DEFAULT_BACKGROUND_COLOR, DEFAULT_SHAPE)

private val RoomSideContentModifier
    @Composable
    get() = Modifier.roomSideContentBackground()
        .border(1.dp, DEFAULT_BORDER_COLOR.copy(DEFAULT_COLOR_ALPHA), DEFAULT_SHAPE)

private val RoomSideContentTopModifier
    @Composable get() = Modifier
        .roomSideContentBackground()
        .border(1.dp, DEFAULT_BORDER_COLOR.copy(DEFAULT_COLOR_ALPHA), SmallTopShape)

private val RoomSideContentFooterModifier
    @Composable
    get() = Modifier
        .roomSideContentBackground()
        .border(1.dp, DEFAULT_BORDER_COLOR.copy(DEFAULT_COLOR_ALPHA), SmallBottomShape)


@Composable
fun ColumnScope.RoomSideExpandableListCard(
    expand: () -> Boolean,
    header: @Composable () -> Unit = {},
    items: LazyListScope.() -> Unit,
) {

    StatefulWidget<Boolean>(expand) {
        val modifier = if (it) RoomSideContentTopModifier else RoomSideContentModifier
        Box(modifier = modifier) { header() }
    }

    VerticalExpandList(expand, items)

}

// = VerticallyAnimatedExpandable(expand)
@Composable
fun ColumnScope.VerticalExpandList(
    expand: () -> Boolean,
    items: LazyListScope.() -> Unit,
) = VerticallyAnimatedExpandable(expand) {

    Column(modifier = RoomSideContentFooterModifier) {
        RoomSideListDivider()

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(horizontal = 12.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items()
        }
    }
}
