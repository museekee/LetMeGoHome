package kr.museekee.letmegohome.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TimeComponent(num: Int, measure: String, color: Color = Color(0xFFFFFFFF)) {
    val (a, b) = num.toString().padStart(2, '0').chunked(1)
    Row(
        modifier = Modifier
            .height(65.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        NumberComponent(
            num = a,
            color = color
        )
        NumberComponent(
            num = b,
            color = color
        )
        Text(
            modifier = Modifier
                .fillMaxHeight()
                .wrapContentHeight(align = androidx.compose.ui.Alignment.CenterVertically),
            text = measure,
            style = MaterialTheme.typography.bodyLarge,
            color = color
        )
    }
}