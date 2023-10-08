package org.kotpot.cosmos.desktop.ui.icon

import androidx.compose.material.icons.materialPath
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

val CosmosIcons.HorizontalRule: ImageVector
    get() {
        if (_horizontalRule != null) {
            return _horizontalRule!!
        }
        _horizontalRule = ImageVector.Builder(
            name = "HorizontalRule",
            defaultWidth = 24.0.dp,
            defaultHeight = 24.0.dp,
            viewportWidth = 960.0F,
            viewportHeight = 960.0F,
        ).materialPath {
            moveTo(210.0F, 510.0F)
            quadTo(197.25F, 510.0F, 188.63F, 501.37F)
            quadTo(180.0F, 492.74F, 180.0F, 479.99F)
            quadTo(180.0F, 467.23F, 188.63F, 458.62F)
            quadTo(197.25F, 450.0F, 210.0F, 450.0F)
            lineTo(750.0F, 450.0F)
            quadTo(762.75F, 450.0F, 771.37F, 458.63F)
            quadTo(780.0F, 467.26F, 780.0F, 480.01F)
            quadTo(780.0F, 492.77F, 771.37F, 501.38F)
            quadTo(762.75F, 510.0F, 750.0F, 510.0F)
            lineTo(210.0F, 510.0F)
            close()
        }.build()
        return _horizontalRule!!
    }
private var _horizontalRule: ImageVector? = null