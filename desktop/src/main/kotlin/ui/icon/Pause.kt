package org.kotpot.cosmos.desktop.ui.icon

import androidx.compose.material.icons.materialPath
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

val CosmosIcons.Pause: ImageVector
    get() {
        if (_pause != null) {
            return _pause!!
        }
        _pause = ImageVector.Builder(
            name = "Pause",
            defaultWidth = 24.0.dp,
            defaultHeight = 24.0.dp,
            viewportWidth = 960.0F,
            viewportHeight = 960.0F,
        ).materialPath {
            moveTo(620.0F, 740.0F)
            quadTo(595.46F, 740.0F, 577.73F, 722.27F)
            quadTo(560.0F, 704.54F, 560.0F, 680.0F)
            lineTo(560.0F, 280.0F)
            quadTo(560.0F, 255.46F, 577.73F, 237.73F)
            quadTo(595.46F, 220.0F, 620.0F, 220.0F)
            lineTo(650.0F, 220.0F)
            quadTo(674.54F, 220.0F, 692.27F, 237.73F)
            quadTo(710.0F, 255.46F, 710.0F, 280.0F)
            lineTo(710.0F, 680.0F)
            quadTo(710.0F, 704.54F, 692.27F, 722.27F)
            quadTo(674.54F, 740.0F, 650.0F, 740.0F)
            lineTo(620.0F, 740.0F)

            moveTo(310.0F, 740.0F)
            quadTo(285.46F, 740.0F, 267.73F, 722.27F)
            quadTo(250.0F, 704.54F, 250.0F, 680.0F)
            lineTo(250.0F, 280.0F)
            quadTo(250.0F, 255.46F, 267.73F, 237.73F)
            quadTo(285.46F, 220.0F, 310.0F, 220.0F)
            lineTo(340.0F, 220.0F)
            quadTo(364.54F, 220.0F, 382.27F, 237.73F)
            quadTo(400.0F, 255.46F, 400.0F, 280.0F)
            lineTo(400.0F, 680.0F)
            quadTo(400.0F, 704.54F, 382.27F, 722.27F)
            quadTo(364.54F, 740.0F, 340.0F, 740.0F)
            lineTo(310.0F, 740.0F)
            close()
        }.build()
        return _pause!!
    }
private var _pause: ImageVector? = null