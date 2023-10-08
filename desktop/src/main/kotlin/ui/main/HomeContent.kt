<<<<<<<< HEAD:desktop/src/main/kotlin/ui/page/HomePage.kt
package org.kotpot.cosmos.desktop.ui.page
========
package org.kotpot.cosmos.desktop.ui.main
>>>>>>>> 2b71804 (Add content package):desktop/src/main/kotlin/ui/main/HomeContent.kt

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeContent(
    modifier: Modifier = Modifier
) {
    Column(
        modifier
    ) {
        Text(text = "Hello, world!")
    }
}