package kr.museekee.letmegohome.screens

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

@Composable
fun LoadingScreen() {
    Text(
        modifier = Modifier
            .fillMaxHeight()
            .wrapContentHeight(align = Alignment.CenterVertically),
        text = "Loading...",
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.titleLarge
    )
}