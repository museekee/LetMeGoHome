package kr.museekee.letmegohome

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kr.museekee.letmegohome.ui.theme.LetMeGoHomeTheme
import kr.museekee.letmegohome.utils.PreferencesHelper
import kr.museekee.letmegohome.utils.PrefsKeys

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val preferencesHelper = PreferencesHelper(this)
        if (preferencesHelper.getInt(PrefsKeys.PREF_SET) == 0)
            preferencesHelper.resetToDefaults()

        setContent {
            LetMeGoHomeTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = Color.Black
                ) {
                    Navigation()
                }
            }
        }
    }
}