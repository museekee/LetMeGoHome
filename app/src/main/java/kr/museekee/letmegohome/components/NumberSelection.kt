package kr.museekee.letmegohome.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun NumberSelection(onChange: (num: Int) -> Unit, default: Int, max: Int) {
    var currentNumber by remember { mutableIntStateOf(default) }

    LaunchedEffect(default) {
        currentNumber = default
        onChange(currentNumber)
    }
    LaunchedEffect(currentNumber, max) {
        if (currentNumber > max)
            currentNumber = max
        onChange(currentNumber)
    }

    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        SemoComponent({
            currentNumber++
        }, currentNumber < max)
        NumberComponent(
            currentNumber.toString()
        )
        SemoComponent({
            currentNumber--
        }, currentNumber > 0, 180f)
    }
}