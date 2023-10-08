package org.kotpot.cosmos.desktop.ui.icon

import androidx.compose.material.icons.materialPath
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

val CosmosIcons.ExpandMore: ImageVector
    get() {
        if (_expandMore != null) {
            return _expandMore!!
        }
        _expandMore = ImageVector.Builder(
            name = "ExpandMore",
            defaultWidth = 24.0.dp,
            defaultHeight = 24.0.dp,
            viewportWidth = 960.0F,
            viewportHeight = 960.0F,
        ).materialPath {
            moveTo(480.0F, 586.46F)
            quadTo(472.77F, 586.46F, 466.54F, 584.15F)
            quadTo(460.31F, 581.84F, 454.69F, 576.23F)
            lineTo(274.92F, 396.46F)
            quadTo(266.62F, 388.15F, 266.42F, 375.58F)
            quadTo(266.23F, 363.0F, 274.92F, 354.31F)
            quadTo(283.62F, 345.62F, 296.0F, 345.62F)
            quadTo(308.38F, 345.62F, 317.08F, 354.31F)
            lineTo(480.0F, 517.23F)
            lineTo(642.92F, 354.31F)
            quadTo(651.23F, 346.0F, 663.81F, 345.81F)
            quadTo(676.38F, 345.62F, 685.08F, 354.31F)
            quadTo(693.77F, 363.0F, 693.77F, 375.39F)
            quadTo(693.77F, 387.77F, 685.08F, 396.46F)
            lineTo(505.31F, 576.23F)
            quadTo(499.69F, 581.84F, 493.46F, 584.15F)
            quadTo(487.23F, 586.46F, 480.0F, 586.46F)
            close()
        }.build()
        return _expandMore!!
    }
private var _expandMore: ImageVector? = null