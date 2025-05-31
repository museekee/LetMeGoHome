package kr.museekee.letmegohome.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import kr.museekee.letmegohome.R

val Moris9 = FontFamily(
    Font(R.font.moris9, FontWeight.Normal)
)

// Set of Material typography styles to start with
val MyTypography = Typography(
    titleLarge = TextStyle(
        fontFamily = Moris9,
        fontSize = 72.sp,
        textAlign = TextAlign.Center,
        color = Color.White
    ),
    titleMedium = TextStyle(
        fontFamily = Moris9,
        fontSize = 48.sp,
        textAlign = TextAlign.Center,
        color = Color.White
    ),
    bodyLarge = TextStyle(
        fontFamily = Moris9,
        fontSize = 64.sp,
        textAlign = TextAlign.Center,
        color = Color.White
    ),
    bodyMedium = TextStyle(
        fontFamily = Moris9,
        fontSize = 20.sp,
        textAlign = TextAlign.Center,
        color = Color.White
    ),
    bodySmall = TextStyle(
        fontFamily = Moris9,
        fontSize = 16.sp,
        textAlign = TextAlign.Center,
        color = Color.White
    ),
)