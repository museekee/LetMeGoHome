package kr.museekee.letmegohome.utils

import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.temporal.WeekFields

fun toRealDate(
    weekOfYear: Int,
    dayOfWeek: String,
    hour: Int,
    minute: Int,
    year: Int = LocalDate.now().year // 기본값: 현재 연도
): LocalDateTime {
    val _dayOfWeek = try {
        DayOfWeek.valueOf(dayOfWeek.uppercase())
    } catch (e: IllegalArgumentException) {
        return LocalDateTime.now() // 잘못된 요일 문자열 처리
    }

    // 연도의 첫 날을 기준으로 주 번호 계산
    val firstDayOfYear = LocalDate.of(year, 1, 1)

    // WeekFields.ISO를 사용하여 ISO-8601 기준 주 번호 계산
    val weekFields = WeekFields.ISO

    // 주어진 weekOfYear와 dayOfWeek로 날짜 생성
    val date = firstDayOfYear
        .with(weekFields.weekOfYear(), weekOfYear.toLong())
        .with(weekFields.dayOfWeek(), _dayOfWeek.value.toLong())

    // LocalDateTime 생성
    return date.atTime(hour, minute)
}