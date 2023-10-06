package org.kotpot.cosmos.desktop.ui.component

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.kotpot.cosmos.desktop.ui.theme.CosmosTheme
import org.kotpot.cosmos.desktop.ui.theme.raleway
import org.kotpot.cosmos.desktop.ui.theme.roboto

@Preview
@Composable
fun pre() {
    CosmosTheme {
        MemberListItem(
            avatar = "image/album.jpg",
            name = "Kotlin",
            role = "moderator",
        )
    }
}
@Composable
fun MemberList(
    modifier: Modifier
) {
    Column(
        modifier
    ) {
        ListCard(
            icon = "icon/ic_group.svg",
            title = "Member",
            additionalText = "3",
        ) {
            items(10) {
                MemberListItem(
                    avatar = "image/album.jpg",
                    name = "Kotlin",
                    role = "moderator",
                )
            }
        }
    }
}

@Composable
fun MemberListItem(
    avatar: String,
    name: String,
    role: String,
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(avatar),
            contentDescription = "Avatar",
            modifier = Modifier
                .size(32.dp)
                .border(1.dp, MaterialTheme.colorScheme.outlineVariant, RoundedCornerShape(40.dp))
                .clip(RoundedCornerShape(40.dp))
        )
        Text(
            text = name,
            style = TextStyle(
                fontFamily = roboto,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                lineHeight = 20.sp,
                letterSpacing = 0.25.sp
            ),
        )
        if (role == "moderator") {
            Text(
                text = "MOD",
                style = TextStyle(
                    fontFamily = roboto,
                    fontWeight = FontWeight.Medium,
                    fontSize = 11.sp,
                    lineHeight = 16.sp,
                    letterSpacing = 0.5.sp
                ),
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.tertiaryContainer, RoundedCornerShape(24.dp))
                    .padding(horizontal = 6.dp, vertical = 2.dp)
            )
        }
    }
}