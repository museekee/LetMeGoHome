package kr.museekee.letmegohome.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kr.museekee.letmegohome.R

@Composable
fun NumberComponent(num: String, color: Color = Color(0xFFFFFFFF)) {
    Box(
        modifier = Modifier
            .size(40.dp, 65.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.numback), // 프로젝트의 이미지 리소스
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Fit,
            colorFilter = ColorFilter.tint(color)
        )

        Text(
            modifier = Modifier
                .wrapContentHeight(align = androidx.compose.ui.Alignment.CenterVertically),
            text = num,
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Black
        )
    }
}