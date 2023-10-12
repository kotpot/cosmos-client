package org.kotpot.cosmos.desktop.ui.icon

import androidx.compose.material.icons.materialIcon
import androidx.compose.material.icons.materialPath
import androidx.compose.ui.graphics.vector.ImageVector

val CosmosIcons.Broadcast: ImageVector
    get() {
        if (_broadcast != null) {
            return _broadcast!!
        }
        _broadcast = materialIcon(name = "Broadcast") {
            materialPath {
                moveTo(12.0F, 12.0F)
                moveToRelative(-1.5F, 0.0F)
                arcToRelative(1.5F, 1.5F, 0.0F, true, true, 3.0F, 0.0F)
                arcToRelative(1.5F, 1.5F, 0.0F, true, true, -3.0F, 0.0F)
                close()
            }
            materialPath {
                moveToRelative(15.32F, 15.32F)
                lineToRelative(-0.02F, -0.02F)
                curveToRelative(-0.25F, -0.25F, -0.29F, -0.66F, -0.07F, -0.95F)
                curveToRelative(0.5F, -0.68F, 0.77F, -1.5F, 0.77F, -2.36F)
                reflectiveCurveToRelative(-0.27F, -1.68F, -0.77F, -2.36F)
                curveToRelative(-0.21F, -0.29F, -0.18F, -0.69F, 0.07F, -0.95F)
                lineToRelative(0.02F, -0.02F)
                curveToRelative(0.32F, -0.32F, 0.85F, -0.29F, 1.12F, 0.08F)
                curveToRelative(0.69F, 0.94F, 1.06F, 2.06F, 1.06F, 3.24F)
                reflectiveCurveToRelative(-0.37F, 2.31F, -1.06F, 3.24F)
                curveToRelative(-0.27F, 0.36F, -0.8F, 0.4F, -1.12F, 0.08F)
                close()
            }
            materialPath {
                moveToRelative(8.68F, 15.32F)
                curveToRelative(-0.32F, 0.32F, -0.85F, 0.29F, -1.12F, -0.08F)
                curveToRelative(-0.69F, -0.94F, -1.06F, -2.06F, -1.06F, -3.24F)
                reflectiveCurveToRelative(0.37F, -2.31F, 1.06F, -3.24F)
                curveToRelative(0.27F, -0.36F, 0.8F, -0.4F, 1.12F, -0.08F)
                lineToRelative(0.02F, 0.02F)
                curveToRelative(0.25F, 0.25F, 0.29F, 0.66F, 0.07F, 0.95F)
                curveToRelative(-0.5F, 0.68F, -0.77F, 1.5F, -0.77F, 2.36F)
                reflectiveCurveToRelative(0.27F, 1.68F, 0.77F, 2.36F)
                curveToRelative(0.21F, 0.29F, 0.18F, 0.69F, -0.07F, 0.95F)
                lineToRelative(-0.02F, 0.02F)
                close()
            }
            materialPath {
                moveToRelative(5.83F, 18.17F)
                curveToRelative(-0.31F, 0.31F, -0.82F, 0.28F, -1.1F, -0.06F)
                curveToRelative(-1.44F, -1.71F, -2.22F, -3.85F, -2.22F, -6.11F)
                reflectiveCurveToRelative(0.78F, -4.4F, 2.22F, -6.11F)
                curveToRelative(0.29F, -0.34F, 0.79F, -0.38F, 1.1F, -0.06F)
                horizontalLineToRelative(0.01F)
                curveToRelative(0.28F, 0.29F, 0.28F, 0.73F, 0.02F, 1.04F)
                curveToRelative(-1.21F, 1.44F, -1.86F, 3.24F, -1.86F, 5.14F)
                reflectiveCurveToRelative(0.66F, 3.7F, 1.86F, 5.14F)
                curveToRelative(0.25F, 0.3F, 0.26F, 0.74F, -0.02F, 1.02F)
                horizontalLineToRelative(-0.01F)
                close()
            }
            materialPath {
                moveToRelative(18.17F, 18.17F)
                horizontalLineToRelative(-0.01F)
                curveToRelative(-0.28F, -0.29F, -0.28F, -0.73F, -0.02F, -1.04F)
                curveToRelative(1.21F, -1.44F, 1.86F, -3.24F, 1.86F, -5.14F)
                reflectiveCurveToRelative(-0.66F, -3.7F, -1.86F, -5.14F)
                curveToRelative(-0.25F, -0.3F, -0.26F, -0.74F, 0.02F, -1.02F)
                horizontalLineToRelative(0.01F)
                curveToRelative(0.31F, -0.33F, 0.82F, -0.29F, 1.1F, 0.05F)
                curveToRelative(1.44F, 1.71F, 2.22F, 3.85F, 2.22F, 6.11F)
                reflectiveCurveToRelative(-0.78F, 4.4F, -2.22F, 6.11F)
                curveToRelative(-0.29F, 0.34F, -0.79F, 0.38F, -1.1F, 0.06F)
                close()
            }
        }
        return _broadcast!!
    }

private var _broadcast: ImageVector? = null