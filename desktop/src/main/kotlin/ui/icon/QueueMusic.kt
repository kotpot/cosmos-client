package org.kotpot.cosmos.desktop.ui.icon

import androidx.compose.material.icons.materialPath
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

val CosmosIcons.QueueMusic: ImageVector
    get() {
        if (_queueMusic != null) {
            return _queueMusic!!
        }
        _queueMusic = ImageVector.Builder(
            name = "QueueMusic",
            defaultWidth = 24.0.dp,
            defaultHeight = 24.0.dp,
            viewportWidth = 960.0F,
            viewportHeight = 960.0F,
        ).materialPath {
            moveTo(635.68F, 780.0F)
            quadTo(590.77F, 780.0F, 559.42F, 748.7F)
            quadTo(528.08F, 717.4F, 528.08F, 672.69F)
            quadTo(528.08F, 627.66F, 559.49F, 596.14F)
            quadTo(590.9F, 564.62F, 635.77F, 564.62F)
            quadTo(648.95F, 564.62F, 660.94F, 568.23F)
            quadTo(672.92F, 571.85F, 683.46F, 579.16F)
            lineTo(683.46F, 294.62F)
            quadTo(683.46F, 279.91F, 693.41F, 269.95F)
            quadTo(703.36F, 260.0F, 718.08F, 260.0F)
            lineTo(825.38F, 260.0F)
            quadTo(840.09F, 260.0F, 850.05F, 269.95F)
            quadTo(860.0F, 279.9F, 860.0F, 294.6F)
            quadTo(860.0F, 309.31F, 850.05F, 319.27F)
            quadTo(840.09F, 329.23F, 825.38F, 329.23F)
            lineTo(743.46F, 329.23F)
            lineTo(743.46F, 672.69F)
            quadTo(743.46F, 717.4F, 712.02F, 748.7F)
            quadTo(680.59F, 780.0F, 635.68F, 780.0F)

            moveTo(170.0F, 615.38F)
            quadTo(157.25F, 615.38F, 148.63F, 606.75F)
            quadTo(140.0F, 598.13F, 140.0F, 585.37F)
            quadTo(140.0F, 572.61F, 148.63F, 564.0F)
            quadTo(157.25F, 555.38F, 170.0F, 555.38F)
            lineTo(410.77F, 555.38F)
            quadTo(423.52F, 555.38F, 432.14F, 564.01F)
            quadTo(440.77F, 572.64F, 440.77F, 585.4F)
            quadTo(440.77F, 598.15F, 432.14F, 606.77F)
            quadTo(423.52F, 615.38F, 410.77F, 615.38F)
            lineTo(170.0F, 615.38F)

            moveTo(170.0F, 467.69F)
            quadTo(157.25F, 467.69F, 148.63F, 459.06F)
            quadTo(140.0F, 450.43F, 140.0F, 437.68F)
            quadTo(140.0F, 424.92F, 148.63F, 416.31F)
            quadTo(157.25F, 407.69F, 170.0F, 407.69F)
            lineTo(565.77F, 407.69F)
            quadTo(578.52F, 407.69F, 587.14F, 416.32F)
            quadTo(595.77F, 424.95F, 595.77F, 437.71F)
            quadTo(595.77F, 450.46F, 587.14F, 459.08F)
            quadTo(578.52F, 467.69F, 565.77F, 467.69F)
            lineTo(170.0F, 467.69F)

            moveTo(170.0F, 320.0F)
            quadTo(157.25F, 320.0F, 148.63F, 311.37F)
            quadTo(140.0F, 302.74F, 140.0F, 289.99F)
            quadTo(140.0F, 277.23F, 148.63F, 268.62F)
            quadTo(157.25F, 260.0F, 170.0F, 260.0F)
            lineTo(565.77F, 260.0F)
            quadTo(578.52F, 260.0F, 587.14F, 268.63F)
            quadTo(595.77F, 277.26F, 595.77F, 290.01F)
            quadTo(595.77F, 302.77F, 587.14F, 311.39F)
            quadTo(578.52F, 320.0F, 565.77F, 320.0F)
            lineTo(170.0F, 320.0F)
            close()
        }.build()
        return _queueMusic!!
    }
private var _queueMusic: ImageVector? = null