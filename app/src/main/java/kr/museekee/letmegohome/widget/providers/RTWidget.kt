package kr.museekee.letmegohome.widget.providers

import android.content.Context
import android.util.Log
import androidx.glance.GlanceId
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.provideContent
import kr.museekee.letmegohome.utils.PreferencesHelper
import kr.museekee.letmegohome.utils.PrefsKeys
import kr.museekee.letmegohome.utils.calculateTimeRemaining
import kr.museekee.letmegohome.utils.toRealDate
import kr.museekee.letmegohome.widget.components.RTWidgetContent
import java.time.LocalDateTime

class RTWidget : GlanceAppWidget() {
    override suspend fun provideGlance(context: Context, id: GlanceId) {
        Log.d("RTWidget", "Hello World!")
        Log.d("RTWidget2", id.toString())
        val prefsHelper = PreferencesHelper(context)
        val (day, hh, mm) = prefsHelper.getString(prefsHelper.getString(PrefsKeys.GO_HOME_TYPE)).split(" ")
        val pWeek = prefsHelper.getInt(PrefsKeys.WEEK)
        val destDate = toRealDate(
            weekOfYear = pWeek,
            dayOfWeek = day,
            hour = hh.toInt(),
            minute = mm.toInt()
        )
        val remain = calculateTimeRemaining(LocalDateTime.now(), destDate)

        provideContent {
            RTWidgetContent(context, remain)
        }
    }
}