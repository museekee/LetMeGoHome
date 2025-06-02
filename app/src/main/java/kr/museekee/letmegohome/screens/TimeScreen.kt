package kr.museekee.letmegohome.screens

import android.app.Activity
import androidx.activity.compose.BackHandler
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import kr.museekee.letmegohome.R
import kr.museekee.letmegohome.components.MiniWarp
import kr.museekee.letmegohome.components.TimeComponent
import kr.museekee.letmegohome.utils.PreferencesHelper
import kr.museekee.letmegohome.utils.PrefsKeys
import kr.museekee.letmegohome.utils.calculateTimeRemaining
import kr.museekee.letmegohome.utils.toRealDate
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
    BackHandler {
        (context as Activity).finish()
    }

    val pType = prefsHelper.getString(PrefsKeys.GO_HOME_TYPE)

    val (day, hh, mm) = prefsHelper.getString(pType).split(" ")

    val pWeek = prefsHelper.getInt(PrefsKeys.WEEK)
    val destDate = toRealDate(
        weekOfYear = pWeek,
        dayOfWeek = day,
        hour = hh.toInt(),
        minute = mm.toInt()
    )

    // 남은 시간 계산: currentTime 사용
    val remain = calculateTimeRemaining(currentTime, destDate)
    val oneDayLeft = remain.days == 0
    val twoHourLeft = oneDayLeft && remain.hours < 2
    val color = if (twoHourLeft) Color(0xFFFF3F3F) else if (oneDayLeft) Color(0xFFFFCC00) else Color(0xFFFFFFFF)

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
            if (pType != PrefsKeys.JALYU_TIME)
            {
                TimeComponent(remain.days, "일", color)
                TimeComponent(remain.hours, "시간", color)
                TimeComponent(remain.minutes, "분", color)
                TimeComponent(remain.seconds, "초", color)
            } else {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                        .wrapContentHeight(align = Alignment.CenterVertically),
                    text = "-잔류-",
                    style = MaterialTheme.typography.titleLarge,
                    fontSize = 128.sp
                )
            }
        }
        MiniWarp(
            onClick = {
                navController.navigate("select") {
                    popUpTo(0)
                }
            },
            text = "다시 설정 하기..."
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
