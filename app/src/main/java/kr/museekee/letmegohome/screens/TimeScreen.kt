package kr.museekee.letmegohome.screens

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kr.museekee.letmegohome.R
import kr.museekee.letmegohome.components.TimeComponent
import kr.museekee.letmegohome.utils.PreferencesHelper
import kr.museekee.letmegohome.utils.PrefsKeys
import kr.museekee.letmegohome.utils.calculateTimeRemaining
import kr.museekee.letmegohome.utils.toRealDate
import androidx.compose.runtime.*
import kotlinx.coroutines.delay
import java.time.LocalDateTime

@Composable
fun TimeScreen(navController: NavController) {
    val context = LocalContext.current
    val prefsHelper = remember { PreferencesHelper(context) }

    // 현재 시간 상태
    var currentTime by remember { mutableStateOf(LocalDateTime.now()) }

    // 매 1초마다 현재 시간 업데이트
    LaunchedEffect(Unit) {
        while (true) {
            currentTime = LocalDateTime.now()
            delay(1000L)
        }
    }

    val pType = prefsHelper.getString(PrefsKeys.GO_HOME_TYPE)

    val (day, hh, mm) = when (pType) {
        "geumgwi" -> prefsHelper.getString(PrefsKeys.GEUMGWI_TIME)
        "togwi" -> prefsHelper.getString(PrefsKeys.TOGWI_TIME)
        "jalyu" -> prefsHelper.getString(PrefsKeys.JALYU_TIME)
        else -> {
            navController.navigate("select")
            "Monday 00 00"
        }
    }.split(" ")

    val pWeek = prefsHelper.getInt(PrefsKeys.WEEK)
    val destDate = toRealDate(
        weekOfYear = pWeek,
        dayOfWeek = day,
        hour = hh.toInt(),
        minute = mm.toInt()
    )

    // 남은 시간 계산: currentTime 사용
    val remain = calculateTimeRemaining(currentTime, destDate)

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
            text = stringResource(R.string.dday_Title),
            style = MaterialTheme.typography.titleLarge,
        )
        Column(
            modifier = Modifier
                .weight(1f),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically)
        ) {
            if (pType != "jalyu") {
                TimeComponent(remain.days, "일")
                TimeComponent(remain.hours, "시간")
                TimeComponent(remain.minutes, "분")
                TimeComponent(remain.seconds, "초")
            } else {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                        .wrapContentHeight(align = Alignment.CenterVertically),
                    text = "잔류",
                    style = MaterialTheme.typography.titleLarge,
                    fontSize = 128.sp
                )
            }
        }
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .padding(end = 30.dp)
                .wrapContentHeight(align = Alignment.CenterVertically)
                .clickable {
                    navController.navigate("select")
                },
            textAlign = TextAlign.End,
            text = "다시 설정 하기...",
            color = Color(0xFF888888),
            style = MaterialTheme.typography.bodySmall,
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(horizontal = 20.dp)
                .wrapContentHeight(align = Alignment.CenterVertically),
            style = MaterialTheme.typography.titleMedium,
            fontSize = 60.sp,
            text = "남았어요!"
        )
    }
}
