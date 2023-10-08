package org.kotpot.cosmos.desktop.ui.icon

import androidx.compose.material.icons.materialPath
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

val CosmosIcons.Add: ImageVector
    get() {
        if (_add != null) {
            return _add!!
        }
        _add = ImageVector.Builder(
            name = "Add",
            defaultWidth = 24.0.dp,
            defaultHeight = 24.0.dp,
            viewportWidth = 960.0F,
            viewportHeight = 960.0F,
        ).materialPath {
            moveTo(450.0F, 510.0F)
            lineTo(250.0F, 510.0F)
            quadTo(237.25F, 510.0F, 228.63F, 501.37F)
            quadTo(220.0F, 492.74F, 220.0F, 479.99F)
            quadTo(220.0F, 467.23F, 228.63F, 458.62F)
            quadTo(237.25F, 450.0F, 250.0F, 450.0F)
            lineTo(450.0F, 450.0F)
            lineTo(450.0F, 250.0F)
            quadTo(450.0F, 237.25F, 458.63F, 228.63F)
            quadTo(467.26F, 220.0F, 480.01F, 220.0F)
            quadTo(492.77F, 220.0F, 501.38F, 228.63F)
            quadTo(510.0F, 237.25F, 510.0F, 250.0F)
            lineTo(510.0F, 450.0F)
            lineTo(710.0F, 450.0F)
            quadTo(722.75F, 450.0F, 731.37F, 458.63F)
            quadTo(740.0F, 467.26F, 740.0F, 480.01F)
            quadTo(740.0F, 492.77F, 731.37F, 501.38F)
            quadTo(722.75F, 510.0F, 710.0F, 510.0F)
            lineTo(510.0F, 510.0F)
            lineTo(510.0F, 710.0F)
            quadTo(510.0F, 722.75F, 501.37F, 731.37F)
            quadTo(492.74F, 740.0F, 479.99F, 740.0F)
            quadTo(467.23F, 740.0F, 458.62F, 731.37F)
            quadTo(450.0F, 722.75F, 450.0F, 710.0F)
            lineTo(450.0F, 510.0F)
            close()
        }.build()
        return _add!!
    }
private var _add: ImageVector? = null