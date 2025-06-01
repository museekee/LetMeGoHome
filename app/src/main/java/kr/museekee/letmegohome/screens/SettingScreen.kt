package kr.museekee.letmegohome.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kr.museekee.letmegohome.R
import kr.museekee.letmegohome.components.NumberSelection
import kr.museekee.letmegohome.utils.PreferencesHelper
import kr.museekee.letmegohome.utils.PrefsKeys

@Composable
fun SettingScreen(navController: NavController) {
    val context = LocalContext.current
    val prefsHelper = remember { PreferencesHelper(context) }
    var h1 by remember { mutableIntStateOf(0) }
    var h2 by remember { mutableIntStateOf(0) }
    var m1 by remember { mutableIntStateOf(0) }
    var m2 by remember { mutableIntStateOf(0) }

    var currentIndex by remember { mutableIntStateOf(0) }

    data class GoHomeType(
        val id: String,
        val label: String,
        val image: Int,
        val pref: String
    )
    val types = listOf(
        GoHomeType(
            id = "geumgwi",
            label = "금귀",
            image = R.drawable.geumgwi,
            pref = PrefsKeys.GEUMGWI_TIME
        ),
        GoHomeType(
            id = "togwi",
            label = "토귀",
            image = R.drawable.togwi,
            pref = PrefsKeys.TOGWI_TIME
        )
    )

    LaunchedEffect(Unit, currentIndex) {
        val (_, hh, mm) = prefsHelper.getString(types[currentIndex].pref).split(" ")
        val (h1d, h2d) = hh.padStart(2, '0').chunked(1)
        val (m1d, m2d) = mm.padStart(2, '0').chunked(1)

        h1 = h1d.toInt()
        h2 = h2d.toInt()
        m1 = m1d.toInt()
        m2 = m2d.toInt()
        Log.d("Settings", "$h1 $h2 $m1 $m2")
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .wrapContentHeight(align = Alignment.CenterVertically),
            text = "시간 설정",
            style = MaterialTheme.typography.titleLarge,
        )
        Image(
            modifier = Modifier
                .size(300.dp, 100.dp)
                .pointerInput(Unit) {
                    detectTapGestures { offset ->
                        val imageWidth = size.width // 이미지 너비 (픽셀 단위)
                        val leftBoundary = imageWidth / 4 // 첫 1/4 지점
                        val rightBoundary = imageWidth * 3 / 4 // 마지막 1/4 시작 지점

                        when {
                            offset.x < leftBoundary -> {
                                currentIndex = (currentIndex - 1 + types.size) % types.size // 이전 인덱스 (순환)
                            }
                            offset.x >= rightBoundary -> {
                                currentIndex = (currentIndex + 1) % types.size // 다음 인덱스 (순환)
                            }
                        }
                    }
                },
            painter = painterResource(types[currentIndex].image),
            contentDescription = types[currentIndex].label
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(5.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically
        ) {
            NumberSelection(
                onChange ={
                    h1 = it
                },
                default = h1,
                max = 2
            )
            NumberSelection(
                onChange ={
                    h2 = it
                },
                default = h2,
                max = if (h1 == 2) 4 else 9
            )
            NumberSelection(
                onChange ={
                    m1 = it
                },
                default = m1,
                max = 5
            )
            NumberSelection(
                onChange ={
                    m2 = it
                },
                default = m2,
                max = 9
            )
        }
    }
}