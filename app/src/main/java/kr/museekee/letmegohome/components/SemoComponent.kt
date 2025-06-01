package kr.museekee.letmegohome.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import kr.museekee.letmegohome.R

@Composable
fun SemoComponent(onClick: () -> Unit, clickable: Boolean = true, angle: Float = 0f) {
    Image(
        painter = painterResource(id = R.drawable.semo),
        contentDescription = null,
        modifier = Modifier
            .rotate(angle)
            .clickable { if (clickable) onClick() },
        contentScale = ContentScale.Fit,
        colorFilter = ColorFilter.tint(if (clickable) Color.White else Color(0xFF888888))
    )
}