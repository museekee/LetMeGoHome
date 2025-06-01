package kr.museekee.letmegohome.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun MiniWarp(text: String, onClick: () -> Unit) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .padding(end = 30.dp)
            .wrapContentHeight(align = Alignment.CenterVertically)
            .clickable { onClick() },
        textAlign = TextAlign.End,
        text = text,
        color = Color(0xFF888888),
        style = MaterialTheme.typography.bodySmall,
    )
}