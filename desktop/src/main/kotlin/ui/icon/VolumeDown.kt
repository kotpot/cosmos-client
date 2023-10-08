package org.kotpot.cosmos.desktop.ui.icon

import androidx.compose.material.icons.materialPath
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

val CosmosIcons.VolumeDown: ImageVector
    get() {
        if (_volumeDown != null) {
            return _volumeDown!!
        }
        _volumeDown = ImageVector.Builder(
            name = "VolumeDown",
            defaultWidth = 24.0.dp,
            defaultHeight = 24.0.dp,
            viewportWidth = 960.0F,
            viewportHeight = 960.0F,
        ).materialPath {
            moveTo(368.46F, 580.0F)
            lineTo(256.15F, 580.0F)
            quadTo(240.69F, 580.0F, 230.35F, 569.65F)
            quadTo(220.0F, 559.31F, 220.0F, 543.84F)
            lineTo(220.0F, 416.16F)
            quadTo(220.0F, 400.69F, 230.35F, 390.35F)
            quadTo(240.69F, 380.0F, 256.15F, 380.0F)
            lineTo(368.46F, 380.0F)
            lineTo(488.15F, 260.31F)
            quadTo(502.54F, 245.93F, 521.27F, 253.73F)
            quadTo(540.0F, 261.54F, 540.0F, 282.0F)
            lineTo(540.0F, 678.0F)
            quadTo(540.0F, 698.46F, 521.27F, 706.27F)
            quadTo(502.54F, 714.07F, 488.15F, 699.69F)
            lineTo(368.46F, 580.0F)

            moveTo(720.0F, 480.0F)
            quadTo(720.0F, 517.38F, 704.46F, 550.85F)
            quadTo(688.92F, 584.31F, 662.54F, 607.15F)
            quadTo(654.08F, 612.77F, 644.73F, 608.23F)
            quadTo(635.38F, 603.69F, 635.38F, 593.23F)
            lineTo(635.38F, 364.77F)
            quadTo(635.38F, 354.31F, 644.73F, 349.77F)
            quadTo(654.08F, 345.23F, 662.54F, 350.85F)
            quadTo(688.92F, 374.31F, 704.46F, 408.46F)
            quadTo(720.0F, 442.62F, 720.0F, 480.0F)
            close()
        }.build()
        return _volumeDown!!
    }
private var _volumeDown: ImageVector? = null