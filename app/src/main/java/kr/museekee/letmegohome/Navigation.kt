package kr.museekee.letmegohome

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kr.museekee.letmegohome.screens.SelectScreen
import kr.museekee.letmegohome.screens.TimeScreen
import kr.museekee.letmegohome.utils.PreferencesHelper
import kr.museekee.letmegohome.utils.PrefsKeys
import java.time.LocalDateTime
import java.time.temporal.IsoFields

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val context = LocalContext.current
    val prefsHelper = remember { PreferencesHelper(context) }
    if (prefsHelper.getInt(PrefsKeys.WEEK) != LocalDateTime.now().get(IsoFields.WEEK_OF_WEEK_BASED_YEAR)) // 설정 했던 주가 지나면
        prefsHelper.saveString(PrefsKeys.GO_HOME_TYPE, "") // 무조건 다시 선택하도록 강제.

    NavHost(navController = navController, startDestination = if (prefsHelper.getString(PrefsKeys.GO_HOME_TYPE) == "") "select" else "time") {
        composable("select") {
            SelectScreen(navController = navController)
        }
        composable("time") {
            TimeScreen(navController = navController)
        }
    }
}