package org.kotpot.cosmos.desktop.ui.icon

import androidx.compose.material.icons.materialPath
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

val CosmosIcons.Play: ImageVector
    get() {
        if (_play != null) {
            return _play!!
        }
        _play = ImageVector.Builder(
            name = "Play",
            defaultWidth = 24.0.dp,
            defaultHeight = 24.0.dp,
            viewportWidth = 960.0F,
            viewportHeight = 960.0F,
        ).materialPath {
            moveTo(395.23F, 688.69F)
            quadTo(377.15F, 700.54F, 358.58F, 690.0F)
            quadTo(340.0F, 679.46F, 340.0F, 657.77F)
            lineTo(340.0F, 302.23F)
            quadTo(340.0F, 280.54F, 358.58F, 270.0F)
            quadTo(377.15F, 259.46F, 395.23F, 271.31F)
            lineTo(675.08F, 449.46F)
            quadTo(691.54F, 460.31F, 691.54F, 480.0F)
            quadTo(691.54F, 499.69F, 675.08F, 510.54F)
            lineTo(395.23F, 688.69F)
            close()
        }.build()
        return _play!!
    }
private var _play: ImageVector? = null