package com.ludavigu.chicken

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.ludavigu.chicken.ui.theme.ChickeTheme
import com.ludavigu.chicken.ui.theme.Purple40

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ChickeTheme {
                Test()
            }
        }
    }
}

@Composable
fun Test() {

    val interactionSource = remember { MutableInteractionSource() }
    val interactionSourceTwo = remember { MutableInteractionSource() }

    val isPressed = interactionSource.collectIsPressedAsState()
    val isPressedTwo = interactionSourceTwo.collectIsPressedAsState()

    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = if (isPressed.value && isPressedTwo.value) Color.Green
                else if (isPressed.value) Color.Red
                else if (isPressedTwo.value) Purple40
                else Color.Gray
            )
    ) {
        Button(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f),
            interactionSource = interactionSource,
            onClick = {}
        ) { }
        Button(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f),
            interactionSource = interactionSourceTwo,
            onClick = {}
        ) { }
    }
}