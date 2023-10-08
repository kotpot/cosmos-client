package org.kotpot.cosmos.desktop.ui.icon

import androidx.compose.material.icons.materialPath
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

val CosmosIcons.Filled.Home: ImageVector
    get() {
        if (_home != null) {
            return _home!!
        }
        _home = ImageVector.Builder(
            name = "Home",
            defaultWidth = 24.0.dp,
            defaultHeight = 24.0.dp,
            viewportWidth = 960.0F,
            viewportHeight = 960.0F,
        ).materialPath {
            moveTo(180.0F, 760.0F)
            lineTo(180.0F, 406.15F)
            quadTo(180.0F, 388.98F, 187.68F, 373.62F)
            quadTo(195.37F, 358.25F, 208.92F, 348.31F)
            lineTo(436.62F, 176.77F)
            quadTo(455.57F, 162.31F, 479.94F, 162.31F)
            quadTo(504.31F, 162.31F, 523.38F, 176.77F)
            lineTo(751.08F, 348.31F)
            quadTo(764.63F, 358.25F, 772.32F, 373.62F)
            quadTo(780.0F, 388.98F, 780.0F, 406.15F)
            lineTo(780.0F, 760.0F)
            quadTo(780.0F, 784.54F, 762.27F, 802.27F)
            quadTo(744.54F, 820.0F, 720.0F, 820.0F)
            lineTo(592.31F, 820.0F)
            quadTo(576.94F, 820.0F, 566.55F, 809.6F)
            quadTo(556.15F, 799.21F, 556.15F, 783.84F)
            lineTo(556.15F, 588.46F)
            quadTo(556.15F, 573.09F, 545.76F, 562.7F)
            quadTo(535.36F, 552.31F, 520.0F, 552.31F)
            lineTo(440.0F, 552.31F)
            quadTo(424.64F, 552.31F, 414.24F, 562.7F)
            quadTo(403.85F, 573.09F, 403.85F, 588.46F)
            lineTo(403.85F, 783.84F)
            quadTo(403.85F, 799.21F, 393.45F, 809.6F)
            quadTo(383.06F, 820.0F, 367.69F, 820.0F)
            lineTo(240.0F, 820.0F)
            quadTo(215.46F, 820.0F, 197.73F, 802.27F)
            quadTo(180.0F, 784.54F, 180.0F, 760.0F)
            close()
        }.build()
        return _home!!
    }
private var _home: ImageVector? = null