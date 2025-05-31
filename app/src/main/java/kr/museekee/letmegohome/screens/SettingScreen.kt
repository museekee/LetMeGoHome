package kr.museekee.letmegohome.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import kr.museekee.letmegohome.utils.PreferencesHelper

@Composable
fun SettingScreen(navController: NavController) {
    val context = LocalContext.current
    val prefsHelper = remember { PreferencesHelper(context) }

}