package org.kotpot.cosmos.desktop.ui.component.business.room.side

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.kotpot.cosmos.shared.ui.ext.StatefulWidget


@Composable
fun RoomSideListHeader(
    icon: ImageVector,
    title: String,
    additional: () -> String,
    onFoldClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .padding(horizontal = 12.dp, vertical = 8.dp).clickable(onClick = onFoldClick)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = "Icon",
            modifier = Modifier
                .padding(end = 6.dp)
        )
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurface
        )
        StatefulWidget<String>(additional) {
            Text(
                text = " - $it",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.weight(1f))
//        Icon(
//            imageVector = CosmosIcons.ExpandLess,
//            contentDescription = "Expand More",
//            modifier = Modifier
//                .clip(MaterialTheme.shapes.small)
//                .clickable { onFoldClick() }
//                .rotate(if (isFolded) 180f else 0f)
//        )
    }
}

@Composable
fun RoomSideListDivider() = Divider(
        modifier = Modifier
            .padding(horizontal = 12.dp)
            .fillMaxWidth()
            .height(1.dp),
        color = MaterialTheme.colorScheme.outlineVariant
    )