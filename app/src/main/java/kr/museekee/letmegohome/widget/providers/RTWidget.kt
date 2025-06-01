package kr.museekee.letmegohome.widget.providers

import android.content.Context
import androidx.glance.GlanceId
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.provideContent
import kr.museekee.letmegohome.widget.components.RTWidgetContent

class RTWidget : GlanceAppWidget() {
    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            RTWidgetContent()
        }
    }
}