package org.kotpot.cosmos.desktop.ui.icon

import androidx.compose.material.icons.materialPath
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

val CosmosIcons.SkipNext: ImageVector
    get() {
        if (_skipNext != null) {
            return _skipNext!!
        }
        _skipNext = ImageVector.Builder(
            name = "SkipNext",
            defaultWidth = 24.0.dp,
            defaultHeight = 24.0.dp,
            viewportWidth = 960.0F,
            viewportHeight = 960.0F,
        ).materialPath {
            moveTo(685.37F, 692.31F)
            quadTo(672.61F, 692.31F, 664.0F, 683.68F)
            quadTo(655.38F, 675.06F, 655.38F, 662.31F)
            lineTo(655.38F, 297.69F)
            quadTo(655.38F, 284.94F, 664.01F, 276.32F)
            quadTo(672.64F, 267.69F, 685.4F, 267.69F)
            quadTo(698.15F, 267.69F, 706.77F, 276.32F)
            quadTo(715.38F, 284.94F, 715.38F, 297.69F)
            lineTo(715.38F, 662.31F)
            quadTo(715.38F, 675.06F, 706.75F, 683.68F)
            quadTo(698.13F, 692.31F, 685.37F, 692.31F)

            moveTo(300.85F, 655.15F)
            quadTo(282.77F, 668.0F, 263.69F, 657.15F)
            quadTo(244.62F, 646.31F, 244.62F, 624.61F)
            lineTo(244.62F, 335.39F)
            quadTo(244.62F, 313.55F, 263.69F, 303.08F)
            quadTo(282.77F, 292.62F, 300.85F, 304.85F)
            lineTo(518.08F, 450.08F)
            quadTo(534.15F, 460.97F, 534.15F, 480.02F)
            quadTo(534.15F, 499.08F, 518.08F, 509.92F)
            lineTo(300.85F, 655.15F)
            close()
        }.build()
        return _skipNext!!
    }
private var _skipNext: ImageVector? = null