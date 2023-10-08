package org.kotpot.cosmos.desktop.ui.icon

import androidx.compose.material.icons.materialPath
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

val CosmosIcons.Search: ImageVector
    get() {
        if (_search != null) {
            return _search!!
        }
        _search = ImageVector.Builder(
            name = "Search",
            defaultWidth = 24.0.dp,
            defaultHeight = 24.0.dp,
            viewportWidth = 960.0F,
            viewportHeight = 960.0F,
        ).materialPath {
            moveTo(380.77F, 624.61F)
            quadTo(278.31F, 624.61F, 207.23F, 553.54F)
            quadTo(136.15F, 482.46F, 136.15F, 380.0F)
            quadTo(136.15F, 277.54F, 207.23F, 206.46F)
            quadTo(278.31F, 135.39F, 380.77F, 135.39F)
            quadTo(483.23F, 135.39F, 554.31F, 206.46F)
            quadTo(625.38F, 277.54F, 625.38F, 380.0F)
            quadTo(625.38F, 422.85F, 611.0F, 461.85F)
            quadTo(596.61F, 500.85F, 572.61F, 529.69F)
            lineTo(802.77F, 759.85F)
            quadTo(811.08F, 768.15F, 811.27F, 780.73F)
            quadTo(811.46F, 793.31F, 802.77F, 802.0F)
            quadTo(794.08F, 810.69F, 781.69F, 810.69F)
            quadTo(769.31F, 810.69F, 760.62F, 802.0F)
            lineTo(530.46F, 571.84F)
            quadTo(500.46F, 596.61F, 461.46F, 610.61F)
            quadTo(422.46F, 624.61F, 380.77F, 624.61F)

            moveTo(380.77F, 564.62F)
            quadTo(458.08F, 564.62F, 511.73F, 510.96F)
            quadTo(565.39F, 457.31F, 565.39F, 380.0F)
            quadTo(565.39F, 302.69F, 511.73F, 249.04F)
            quadTo(458.08F, 195.38F, 380.77F, 195.38F)
            quadTo(303.46F, 195.38F, 249.81F, 249.04F)
            quadTo(196.15F, 302.69F, 196.15F, 380.0F)
            quadTo(196.15F, 457.31F, 249.81F, 510.96F)
            quadTo(303.46F, 564.62F, 380.77F, 564.62F)
            close()
        }.build()
        return _search!!
    }
private var _search: ImageVector? = null