package org.kotpot.cosmos.desktop.ui.icon

import androidx.compose.material.icons.materialPath
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

val CosmosIcons.Close: ImageVector
    get() {
        if (_close != null) {
            return _close!!
        }
        _close = ImageVector.Builder(
            name = "Close",
            defaultWidth = 24.0.dp,
            defaultHeight = 24.0.dp,
            viewportWidth = 960.0F,
            viewportHeight = 960.0F,
        ).materialPath {
            moveTo(480.0F, 522.15F)
            lineTo(277.08F, 725.08F)
            quadTo(268.77F, 733.38F, 256.19F, 733.58F)
            quadTo(243.62F, 733.77F, 234.92F, 725.08F)
            quadTo(226.23F, 716.38F, 226.23F, 704.0F)
            quadTo(226.23F, 691.62F, 234.92F, 682.92F)
            lineTo(437.85F, 480.0F)
            lineTo(234.92F, 277.08F)
            quadTo(226.62F, 268.77F, 226.42F, 256.19F)
            quadTo(226.23F, 243.62F, 234.92F, 234.92F)
            quadTo(243.62F, 226.23F, 256.0F, 226.23F)
            quadTo(268.38F, 226.23F, 277.08F, 234.92F)
            lineTo(480.0F, 437.85F)
            lineTo(682.92F, 234.92F)
            quadTo(691.23F, 226.62F, 703.81F, 226.42F)
            quadTo(716.38F, 226.23F, 725.08F, 234.92F)
            quadTo(733.77F, 243.62F, 733.77F, 256.0F)
            quadTo(733.77F, 268.38F, 725.08F, 277.08F)
            lineTo(522.15F, 480.0F)
            lineTo(725.08F, 682.92F)
            quadTo(733.38F, 691.23F, 733.58F, 703.81F)
            quadTo(733.77F, 716.38F, 725.08F, 725.08F)
            quadTo(716.38F, 733.77F, 704.0F, 733.77F)
            quadTo(691.62F, 733.77F, 682.92F, 725.08F)
            lineTo(480.0F, 522.15F)
            close()
        }.build()
        return _close!!
    }
private var _close: ImageVector? = null