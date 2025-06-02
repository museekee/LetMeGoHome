package kr.museekee.letmegohome.widget.components

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.glance.GlanceModifier
import androidx.glance.background
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.fillMaxHeight
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.fillMaxWidth
import androidx.glance.layout.height
import androidx.glance.layout.padding
import androidx.glance.text.Text
import androidx.glance.text.TextAlign
import androidx.glance.text.TextStyle
import androidx.glance.unit.ColorProvider
import kr.museekee.letmegohome.utils.DT

@Composable
fun RTWidgetContent(context: Context, remain: DT) {
    val (days, hours, minutes, seconds) = remain

    Column(
        modifier = GlanceModifier
            .fillMaxSize()
            .background(Color(0xAA000000)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalAlignment = Alignment.Top
    ) {
        Column(
            modifier = GlanceModifier
                .fillMaxWidth()
                .height(30.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = GlanceModifier
                    .fillMaxWidth(),
                text = "금요귀가",
                style = TextStyle(
                    color = ColorProvider(Color(0xFFFFFFFF)),
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center
                )
            )
        }
        Column(
            modifier = GlanceModifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = GlanceModifier
                    .fillMaxHeight()
                    .padding(bottom = 10.dp), // 80dp
                // 2dp gap
            ) {
                Text(
                    text = "$days $hours $minutes $seconds",
                    style = TextStyle(
                        color = ColorProvider(Color(0xFFFFFFFF))
                    )
                )
            }
        }
    }
}