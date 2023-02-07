package com.example.composedeeplink

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * Created by Ruben Quadros on 07/02/23
 **/
@Composable
fun HomeScreen(
    normalScreen: () -> Unit,
    deeplinkScreen: () -> Unit,
    normalSheet1: () -> Unit,
    deeplinkSheet1: () -> Unit,
    normalSheet2: () -> Unit,
    deeplinkSheet2: () -> Unit,
) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Blue)) {

        Column(
            modifier = Modifier.align(Alignment.TopCenter)
        ) {
            Button(
                modifier = Modifier.padding(8.dp),
                onClick = normalScreen
            ) {
                Text(text = "Normal Second screen")
            }

            Button(
                modifier = Modifier.padding(8.dp),
                onClick = deeplinkScreen
            ) {
                Text(text = "Deeplink Second screen")
            }
        }

        Column(
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
            Button(
                modifier = Modifier.padding(8.dp),
                onClick = normalSheet1
            ) {
                Text(text = "Normal sheet1")
            }

            Button(
                modifier = Modifier.padding(8.dp),
                onClick = deeplinkSheet1
            ) {
                Text(text = "Deeplink sheet1")
            }

            Button(
                modifier = Modifier.padding(8.dp),
                onClick = normalSheet2
            ) {
                Text(text = "Normal sheet2")
            }

            Button(
                modifier = Modifier.padding(8.dp),
                onClick = deeplinkSheet2
            ) {
                Text(text = "Deeplink sheet2")
            }
        }
    }
}

@Composable
fun SecondScreen() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Green))
}

@Composable
fun BottomSheet1() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(400.dp)
        .background(Color.Red))
}

@Composable
fun BottomSheet2() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(400.dp)
        .background(Color.Yellow))
}