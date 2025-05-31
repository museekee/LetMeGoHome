package kr.museekee.letmegohome.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kr.museekee.letmegohome.R
import kr.museekee.letmegohome.ui.theme.Moris9
import kr.museekee.letmegohome.utils.PreferencesHelper
import kr.museekee.letmegohome.utils.PrefsKeys
import java.time.LocalDateTime
import java.time.temporal.IsoFields

@Composable
fun SelectScreen(navController: NavController) {
    val context = LocalContext.current
    val prefsHelper = remember { PreferencesHelper(context) }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .wrapContentHeight(align = Alignment.CenterVertically),
            text = stringResource(R.string.select_title),
            style = MaterialTheme.typography.titleMedium,
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            data class GoHomeType(
                val id: String,
                val label: String,
                val image: Int
            )
            val types = listOf(
                GoHomeType(
                    id = "geumgwi",
                    label = "금귀",
                    image = R.drawable.geumgwi
                ),
                GoHomeType(
                    id = "togwi",
                    label = "토귀",
                    image = R.drawable.togwi
                ),
                GoHomeType(
                    id = "jalyu",
                    label = "잔류",
                    image = R.drawable.jalyu
                )
            )
            types.forEach {
                Image(
                    modifier = Modifier
                        .size(300.dp, 100.dp)
                        .clickable {
                            prefsHelper.saveString(PrefsKeys.GO_HOME_TYPE, it.id)
                            prefsHelper.saveInt(PrefsKeys.WEEK, LocalDateTime.now().get(IsoFields.WEEK_OF_WEEK_BASED_YEAR))

                            navController.navigate("time")
                        },
                    painter = painterResource(it.image),
                    contentDescription = it.label
                )
            }
        }
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .padding(end = 30.dp)
                .wrapContentHeight(align = Alignment.CenterVertically)
                .clickable {  },
            textAlign = TextAlign.End,
            text = "시간 설정 하기...",
            color = Color(0xFF888888),
            style = MaterialTheme.typography.bodySmall,
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .padding(horizontal = 20.dp)
                .wrapContentHeight(align = Alignment.CenterVertically),
            textAlign = TextAlign.Center,
            text = stringResource(R.string.inseongjil),
            fontSize = 20.sp,
            fontFamily = Moris9,
            color = Color.White
        )
    }
}