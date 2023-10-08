package org.kotpot.cosmos.desktop.ui.icon

import androidx.compose.material.icons.materialPath
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

val CosmosIcons.ArrowForward: ImageVector
    get() {
        if (_arrowForward != null) {
            return _arrowForward!!
        }
        _arrowForward = ImageVector.Builder(
            name = "ArrowForward",
            defaultWidth = 24.0.dp,
            defaultHeight = 24.0.dp,
            viewportWidth = 960.0F,
            viewportHeight = 960.0F,
        ).materialPath {
            moveTo(665.08F, 510.0F)
            lineTo(210.0F, 510.0F)
            quadTo(197.23F, 510.0F, 188.62F, 501.38F)
            quadTo(180.0F, 492.77F, 180.0F, 480.0F)
            quadTo(180.0F, 467.23F, 188.62F, 458.62F)
            quadTo(197.23F, 450.0F, 210.0F, 450.0F)
            lineTo(665.08F, 450.0F)
            lineTo(458.31F, 243.23F)
            quadTo(449.39F, 234.31F, 449.5F, 222.35F)
            quadTo(449.62F, 210.39F, 458.92F, 201.08F)
            quadTo(468.23F, 192.39F, 480.0F, 192.08F)
            quadTo(491.77F, 191.77F, 501.08F, 201.08F)
            lineTo(754.69F, 454.69F)
            quadTo(760.31F, 460.31F, 762.61F, 466.54F)
            quadTo(764.92F, 472.77F, 764.92F, 480.0F)
            quadTo(764.92F, 487.23F, 762.61F, 493.46F)
            quadTo(760.31F, 499.69F, 754.69F, 505.31F)
            lineTo(501.08F, 758.92F)
            quadTo(492.77F, 767.23F, 480.5F, 767.42F)
            quadTo(468.23F, 767.61F, 458.92F, 758.92F)
            quadTo(449.62F, 749.61F, 449.62F, 737.54F)
            quadTo(449.62F, 725.46F, 458.92F, 716.15F)
            lineTo(665.08F, 510.0F)
            close()
        }.build()
        return _arrowForward!!
    }
private var _arrowForward: ImageVector? = null