package kr.museekee.letmegohome.utils

import android.content.Context
import java.time.Duration
import java.time.LocalDateTime
import java.time.ZoneId

data class DT(
    val days: Int,
    val hours: Int,
    val minutes: Int,
    val seconds: Int,
)
fun calculateTimeRemaining(currentTime: LocalDateTime, targetDateTime: LocalDateTime): DT {
    // 현재 시간 (KST, 2025-05-31 20:57)
    val zoneId = ZoneId.of("Asia/Seoul")

    // 현재 시간과 목표 시간 간의 차이 계산
    val duration = Duration.between(currentTime.atZone(zoneId), targetDateTime.atZone(zoneId))

    // 일, 시간, 분, 초로 변환
    val days = duration.toDays()
    val hours = duration.toHours() % 24
    val minutes = duration.toMinutes() % 60
    val seconds = duration.seconds % 60

    // 결과 문자열 포맷
    return DT(days.toInt(), hours.toInt(), minutes.toInt(), seconds.toInt())
}