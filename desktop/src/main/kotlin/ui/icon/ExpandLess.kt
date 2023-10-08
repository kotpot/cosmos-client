package org.kotpot.cosmos.desktop.ui.icon

import androidx.compose.material.icons.materialPath
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

val CosmosIcons.ExpandLess: ImageVector
    get() {
        if (_expandLess != null) {
            return _expandLess!!
        }
        _expandLess = ImageVector.Builder(
            name = "ExpandLess",
            defaultWidth = 24.0.dp,
            defaultHeight = 24.0.dp,
            viewportWidth = 960.0F,
            viewportHeight = 960.0F,
        ).materialPath {
            moveTo(480.0F, 417.54F)
            lineTo(317.08F, 580.46F)
            quadTo(308.77F, 588.77F, 296.19F, 588.96F)
            quadTo(283.62F, 589.15F, 274.92F, 580.46F)
            quadTo(266.23F, 571.77F, 266.23F, 559.39F)
            quadTo(266.23F, 547.0F, 274.92F, 538.31F)
            lineTo(454.69F, 358.54F)
            quadTo(460.31F, 352.92F, 466.54F, 350.62F)
            quadTo(472.77F, 348.31F, 480.0F, 348.31F)
            quadTo(487.23F, 348.31F, 493.46F, 350.62F)
            quadTo(499.69F, 352.92F, 505.31F, 358.54F)
            lineTo(685.08F, 538.31F)
            quadTo(693.38F, 546.62F, 693.58F, 559.19F)
            quadTo(693.77F, 571.77F, 685.08F, 580.46F)
            quadTo(676.38F, 589.15F, 664.0F, 589.15F)
            quadTo(651.62F, 589.15F, 642.92F, 580.46F)
            lineTo(480.0F, 417.54F)
            close()
        }.build()
        return _expandLess!!
    }
private var _expandLess: ImageVector? = null