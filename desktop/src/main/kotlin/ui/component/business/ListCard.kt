package org.kotpot.cosmos.desktop.ui.component.business

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.kotpot.cosmos.desktop.ui.icon.CosmosIcons
import org.kotpot.cosmos.desktop.ui.icon.ExpandLess

@Composable
fun ListCard(
    icon: ImageVector,
    title: String,
    additionalText: String,
    isFolded: Boolean,
    onFoldClick: () -> Unit,
    modifier: Modifier = Modifier,
    listContent: LazyListScope.() -> Unit,
) {
    Column(
        modifier = modifier,
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 12.dp, vertical = 8.dp)
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
            Text(
                text = " - $additionalText",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = CosmosIcons.ExpandLess,
                contentDescription = "Expand More",
                modifier = Modifier
                    .clip(MaterialTheme.shapes.small)
                    .clickable { onFoldClick() }
                    .rotate(if (isFolded) 180f else 0f)
            )
        }
        if (!isFolded) {
            Divider(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .fillMaxWidth()
                    .height(1.dp),
                color = MaterialTheme.colorScheme.outlineVariant
            )
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(horizontal = 12.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                listContent()
            }
        }
    }
}