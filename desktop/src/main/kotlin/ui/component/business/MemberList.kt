package org.kotpot.cosmos.desktop.ui.component.business

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import org.kotpot.cosmos.desktop.locale.from
import org.kotpot.cosmos.desktop.locale.string.LocaleString
import org.kotpot.cosmos.desktop.ui.icon.Add
import org.kotpot.cosmos.desktop.ui.icon.CosmosIcons
import org.kotpot.cosmos.desktop.ui.icon.Group
import org.kotpot.cosmos.desktop.ui.state.component.MemberSongState
import org.kotpot.cosmos.shared.model.Member

@Composable
fun MemberList(
    state: MemberSongState,
    onFoldClick: () -> Unit,
    modifier: Modifier
) {
    Column(
        modifier
    ) {
        ListCard(
            icon = CosmosIcons.Group,
            title = LocaleString::mainMemberListTitle.from(),
            additionalText = state.member.size.toString(),
            isFolded = state.isMemberFolded,
            onFoldClick = { onFoldClick() },
            modifier = Modifier
                .background(MaterialTheme.colorScheme.surface.copy(0.72f), MaterialTheme.shapes.small)
                .border(1.dp, MaterialTheme.colorScheme.outlineVariant.copy(0.72f), MaterialTheme.shapes.small)
        ) {
            items(state.member) {
                MemberListItem(it)
            }
            item {
                InviteItem()
            }
        }
    }
}

@Composable
fun MemberListItem(
    member: Member
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        var name by remember { mutableStateOf(member.name) }

        Image(
            painter = painterResource(member.avatar),
            contentDescription = "Avatar",
            modifier = Modifier
                .size(32.dp)
                .border(1.dp, MaterialTheme.colorScheme.outlineVariant, RoundedCornerShape(40.dp))
                .clip(RoundedCornerShape(40.dp)),
            contentScale = ContentScale.Fit
        )
        Text(
            text = member.name,
            style = MaterialTheme.typography.bodyMedium.copy(
                baselineShift = BaselineShift(0.3f)
            ),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            onTextLayout = { textLayoutResult ->
                if (textLayoutResult.hasVisualOverflow) {
                    name = name.dropLast(4).plus("...") //TODO: Remove once compose-multiplatform#1888 is fixed
                }
            }
        )
        if (member.role == "moderator") {
            Text(
                text = "MOD",
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.tertiaryContainer, RoundedCornerShape(24.dp))
                    .padding(horizontal = 6.dp, vertical = 2.dp)
                    .offset(0.dp, (-1).dp)
            )
        }
    }
}

@Composable
fun InviteItem() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(
            modifier = Modifier
                .size(32.dp)
                .border(1.dp, MaterialTheme.colorScheme.outlineVariant, RoundedCornerShape(40.dp))
                .clip(RoundedCornerShape(40.dp)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = CosmosIcons.Add,
                contentDescription = "Invite",
                tint = MaterialTheme.colorScheme.outline
            )
        }
        Text(
            text = "Invite",
            style = MaterialTheme.typography.bodyMedium.copy(
                baselineShift = BaselineShift(0.25f)
            ),
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}