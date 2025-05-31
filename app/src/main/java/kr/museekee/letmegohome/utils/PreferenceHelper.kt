package kr.museekee.letmegohome.utils

import android.content.Context
import androidx.core.content.edit

class PreferencesHelper(context: Context) {
    private val prefs = context.getSharedPreferences("Setting", Context.MODE_PRIVATE)

    fun saveString(key: String, value: String) {
        prefs.edit { putString(key, value) }
    }

    fun getString(key: String, defaultValue: String = ""): String {
        return prefs.getString(key, "") ?: ""
    }

    fun saveInt(key: String, value: Int) {
        prefs.edit { putInt(key, value) }
    }

    fun getInt(key: String, defaultValue: Int = 0): Int {
        return prefs.getInt(key, defaultValue)
    }

    fun clear() {
        prefs.edit { clear() }
    }

    fun resetToDefaults() {
        prefs.edit {
            putInt(PrefsKeys.PREF_SET, PrefsDefaults.DEFAULT_PREF_SET)

            putString(PrefsKeys.GO_HOME_TYPE, PrefsDefaults.DEFAULT_GO_HOME_TYPE)
            putString(PrefsKeys.GEUMGWI_TIME, PrefsDefaults.DEFAULT_GEUMGWI_TIME)
            putString(PrefsKeys.TOGWI_TIME, PrefsDefaults.DEFAULT_TOGWI_TIME)
            putString(PrefsKeys.JALYU_TIME, PrefsDefaults.DEFAULT_JALYU_TIME)
            putString(PrefsKeys.WEEK, PrefsDefaults.DEFAULT_WEEK)
        }
    }
}