package kr.museekee.letmegohome.widget.receivers

import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import kr.museekee.letmegohome.widget.providers.RTWidget

class RTWidgetReceiver : GlanceAppWidgetReceiver() {
    override val glanceAppWidget: GlanceAppWidget = RTWidget()
}