package org.kotpot.cosmos.desktop.ui.icon

import androidx.compose.material.icons.materialPath
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

val CosmosIcons.SkipPrevious: ImageVector
    get() {
        if (_skipPrevious != null) {
            return _skipPrevious!!
        }
        _skipPrevious = ImageVector.Builder(
            name = "SkipPrevious",
            defaultWidth = 24.0.dp,
            defaultHeight = 24.0.dp,
            viewportWidth = 960.0F,
            viewportHeight = 960.0F,
        ).materialPath {
            moveTo(274.6F, 692.31F)
            quadTo(261.85F, 692.31F, 253.23F, 683.68F)
            quadTo(244.62F, 675.06F, 244.62F, 662.31F)
            lineTo(244.62F, 297.69F)
            quadTo(244.62F, 284.94F, 253.25F, 276.32F)
            quadTo(261.88F, 267.69F, 274.63F, 267.69F)
            quadTo(287.39F, 267.69F, 296.0F, 276.32F)
            quadTo(304.62F, 284.94F, 304.62F, 297.69F)
            lineTo(304.62F, 662.31F)
            quadTo(304.62F, 675.06F, 295.99F, 683.68F)
            quadTo(287.36F, 692.31F, 274.6F, 692.31F)

            moveTo(659.15F, 655.15F)
            lineTo(441.92F, 509.92F)
            quadTo(425.85F, 499.03F, 425.85F, 479.98F)
            quadTo(425.85F, 460.92F, 441.92F, 450.08F)
            lineTo(659.15F, 304.85F)
            quadTo(677.23F, 292.62F, 696.31F, 303.08F)
            quadTo(715.38F, 313.55F, 715.38F, 335.39F)
            lineTo(715.38F, 624.61F)
            quadTo(715.38F, 646.31F, 696.31F, 657.15F)
            quadTo(677.23F, 668.0F, 659.15F, 655.15F)
            close()
        }.build()
        return _skipPrevious!!
    }
private var _skipPrevious: ImageVector? = null