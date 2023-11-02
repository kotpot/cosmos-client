package org.kotpot.cosmos.desktop.ui.component.puppet

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.kotpot.cosmos.desktop.ui.icon.CosmosIcons
import org.kotpot.cosmos.desktop.ui.icon.Search
import org.kotpot.cosmos.desktop.ui.theme.Monorale

@Composable
@Preview
fun LargeTextField(
    textFieldValue: String,
    onTextFieldValueChange: (String) -> Unit,
    showSearchIcon: Boolean,
    hintText: String,
    modifier: Modifier = Modifier
) {

    Column(modifier) {
        Row(
            modifier = Modifier
                .border(1.dp, MaterialTheme.colorScheme.outlineVariant.copy(0.72f), RoundedCornerShape(24.dp))
                .background(MaterialTheme.colorScheme.surface.copy(0.72f), RoundedCornerShape(24.dp)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (showSearchIcon) {
                Icon(
                    imageVector = CosmosIcons.Search,
                    contentDescription = "Search",
                    modifier = Modifier
                        .padding(start = 12.dp, top = 8.dp, bottom = 8.dp, end = 8.dp)
                )
            }
            BasicTextField(
                value = textFieldValue,
                onValueChange = { onTextFieldValueChange(it) },
                modifier = when (showSearchIcon) {
                    true -> Modifier.weight(1f).padding(end = 12.dp)
                    false -> Modifier.weight(1f).padding(horizontal = 12.dp)
                },
                singleLine = true,
                textStyle = TextStyle(
                    fontFamily = Monorale,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    letterSpacing = 0.15.sp,
                    color = MaterialTheme.colorScheme.onSurface
                ),
                decorationBox = { innerTextField ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 8.dp, bottom = 8.dp)
                    ) {
                        if (textFieldValue.isEmpty()) {
                            Text(
                                text = hintText,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                style = MaterialTheme.typography.titleMedium
                            )
                        }
                        innerTextField()
                    }
                }
            )
        }
    }
}