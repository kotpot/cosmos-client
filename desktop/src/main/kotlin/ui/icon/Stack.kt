package org.kotpot.cosmos.desktop.ui.icon

import androidx.compose.material.icons.materialIcon
import androidx.compose.material.icons.materialPath
import androidx.compose.ui.graphics.vector.ImageVector

val CosmosIcons.Stack: ImageVector
    get() {
        if (_stack != null) {
            return _stack!!
        }
        _stack = materialIcon(name = "Stack") {
            materialPath {
                moveTo(7.8077F, 19.0F)
                curveTo(7.30898F, 19.0F, 6.88302F, 18.8233F, 6.52982F, 18.4701F)
                curveTo(6.17661F, 18.1169F, 6.0F, 17.691F, 6.0F, 17.1923F)
                verticalLineTo(7.8077F)
                curveTo(6.0F, 7.30898F, 6.17661F, 6.88302F, 6.52982F, 6.52982F)
                curveTo(6.88302F, 6.17661F, 7.30898F, 6.0F, 7.8077F, 6.0F)
                horizontalLineTo(17.1923F)
                curveTo(17.691F, 6.0F, 18.1169F, 6.17661F, 18.4701F, 6.52982F)
                curveTo(18.8233F, 6.88302F, 19.0F, 7.30898F, 19.0F, 7.8077F)
                verticalLineTo(17.1923F)
                curveTo(19.0F, 17.691F, 18.8233F, 18.1169F, 18.4701F, 18.4701F)
                curveTo(18.1169F, 18.8233F, 17.691F, 19.0F, 17.1923F, 19.0F)
                horizontalLineTo(7.8077F)

                moveTo(7.8077F, 17.5F)
                horizontalLineTo(17.1923F)
                curveTo(17.282F, 17.5F, 17.3557F, 17.4711F, 17.4134F, 17.4134F)
                curveTo(17.4711F, 17.3557F, 17.5F, 17.282F, 17.5F, 17.1923F)
                verticalLineTo(7.8077F)
                curveTo(17.5F, 7.71795F, 17.4711F, 7.64423F, 17.4134F, 7.58652F)
                curveTo(17.3557F, 7.52882F, 17.282F, 7.49998F, 17.1923F, 7.49998F)
                horizontalLineTo(7.8077F)
                curveTo(7.71795F, 7.49998F, 7.64423F, 7.52882F, 7.58652F, 7.58652F)
                curveTo(7.52882F, 7.64423F, 7.49998F, 7.71795F, 7.49998F, 7.8077F)
                verticalLineTo(17.1923F)
                curveTo(7.49998F, 17.282F, 7.52882F, 17.3557F, 7.58652F, 17.4134F)
                curveTo(7.64423F, 17.4711F, 7.71795F, 17.5F, 7.8077F, 17.5F)
                close()
            }
        }
        return _stack!!
    }

private var _stack: ImageVector? = null