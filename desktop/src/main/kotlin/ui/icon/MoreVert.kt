package org.kotpot.cosmos.desktop.ui.icon

import androidx.compose.material.icons.materialPath
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

val CosmosIcons.MoreVert: ImageVector
    get() {
        if (_moreVert != null) {
            return _moreVert!!
        }
        _moreVert = ImageVector.Builder(
            name = "MoreVert",
            defaultWidth = 24.0.dp,
            defaultHeight = 24.0.dp,
            viewportWidth = 960.0F,
            viewportHeight = 960.0F,
        ).materialPath {
            moveTo(480.0F, 770.77F)
            quadTo(455.25F, 770.77F, 437.63F, 753.14F)
            quadTo(420.0F, 735.52F, 420.0F, 710.77F)
            quadTo(420.0F, 686.02F, 437.63F, 668.4F)
            quadTo(455.25F, 650.77F, 480.0F, 650.77F)
            quadTo(504.75F, 650.77F, 522.37F, 668.4F)
            quadTo(540.0F, 686.02F, 540.0F, 710.77F)
            quadTo(540.0F, 735.52F, 522.37F, 753.14F)
            quadTo(504.75F, 770.77F, 480.0F, 770.77F)

            moveTo(480.0F, 540.0F)
            quadTo(455.25F, 540.0F, 437.63F, 522.37F)
            quadTo(420.0F, 504.75F, 420.0F, 480.0F)
            quadTo(420.0F, 455.25F, 437.63F, 437.63F)
            quadTo(455.25F, 420.0F, 480.0F, 420.0F)
            quadTo(504.75F, 420.0F, 522.37F, 437.63F)
            quadTo(540.0F, 455.25F, 540.0F, 480.0F)
            quadTo(540.0F, 504.75F, 522.37F, 522.37F)
            quadTo(504.75F, 540.0F, 480.0F, 540.0F)

            moveTo(480.0F, 309.23F)
            quadTo(455.25F, 309.23F, 437.63F, 291.6F)
            quadTo(420.0F, 273.98F, 420.0F, 249.23F)
            quadTo(420.0F, 224.48F, 437.63F, 206.86F)
            quadTo(455.25F, 189.23F, 480.0F, 189.23F)
            quadTo(504.75F, 189.23F, 522.37F, 206.86F)
            quadTo(540.0F, 224.48F, 540.0F, 249.23F)
            quadTo(540.0F, 273.98F, 522.37F, 291.6F)
            quadTo(504.75F, 309.23F, 480.0F, 309.23F)
            close()
        }.build()
        return _moreVert!!
    }
private var _moreVert: ImageVector? = null