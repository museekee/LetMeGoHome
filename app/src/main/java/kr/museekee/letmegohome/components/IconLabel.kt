package kr.museekee.letmegohome.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

@Composable
fun IconLabel(icon: Painter, label: String, onClick: (() -> Unit)? = {}) {
    Column(
        modifier = Modifier
            .clickable { onClick?.invoke() },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Image(
            modifier = Modifier
                .size(90.dp)
                .border(3.dp, Color(0xFFFFFFFF)),
            painter = icon,
            contentDescription = null
        )
        Text(
            modifier = Modifier
                .wrapContentHeight(align = Alignment.CenterVertically),
            text = label,
            style = MaterialTheme.typography.bodySmall,
        )
    }
}