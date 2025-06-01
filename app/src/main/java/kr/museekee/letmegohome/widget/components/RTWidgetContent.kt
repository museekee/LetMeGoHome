package kr.museekee.letmegohome.widget.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.glance.GlanceModifier
import androidx.glance.background
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.fillMaxWidth
import androidx.glance.layout.height
import androidx.glance.layout.wrapContentHeight
import androidx.glance.text.Text
import androidx.glance.text.TextAlign
import androidx.glance.text.TextStyle
import androidx.glance.unit.ColorProvider

@Composable
fun RTWidgetContent() {
    Column(
        modifier = GlanceModifier
            .fillMaxSize()
            .background(Color(0xAA000000)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalAlignment = Alignment.Top
    ) {
        Text(
            modifier = GlanceModifier
                .fillMaxWidth()
                .height(20.dp)
                .wrapContentHeight(),
            text = "금요귀가",
            style = TextStyle(
                color = ColorProvider(Color(0xFFFFFFFF)),
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )
        )
    }
}