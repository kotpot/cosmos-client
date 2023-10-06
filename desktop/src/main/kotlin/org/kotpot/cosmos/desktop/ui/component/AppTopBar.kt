package org.kotpot.cosmos.desktop.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.kotpot.cosmos.desktop.ui.theme.raleway

@Composable
fun AppTopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(Color.Transparent)
    ) {
        Logo(
            modifier = Modifier
                .padding(start = 28.dp, top = 21.dp)
        )
    }
}

@Composable
fun Logo(
    modifier: Modifier = Modifier
) {
    Row(modifier) {
        Text(
            text = "cosmos",
            fontSize = 22.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            fontFamily = raleway,
            fontWeight = FontWeight.SemiBold
        )
        Image(
            painter = painterResource("image/title_logo.svg"),
            contentDescription = "Cosmos logo",
            modifier = Modifier.padding(start = 3.dp, top = 1.dp)
        )
    }
}

@Composable
fun WindowControl(
    modifier: Modifier = Modifier,
    onMinimize: () -> Unit,
    onMaximize: () -> Unit,
    onClose: () -> Unit,
) {
    Row(modifier) {
        Icon(
            painter = painterResource("icon/ic_horizontal_rule.svg"),
            contentDescription = "Minimize",
            modifier = Modifier
                .clip(RoundedCornerShape(4.dp))
                .clickable { onMinimize() }
        )
        Spacer(modifier = Modifier.width(16.dp))
        Icon(
            painter = painterResource("icon/ic_stack.svg"),
            contentDescription = "Maximize",
            modifier = Modifier
                .clip(RoundedCornerShape(4.dp))
                .clickable { onMaximize() }
        )
        Spacer(modifier = Modifier.width(16.dp))
        Icon(
            painter = painterResource("icon/ic_close.svg"),
            contentDescription = "Close",
            modifier = Modifier
                .clip(RoundedCornerShape(4.dp))
                .clickable { onClose() }
        )
    }
}