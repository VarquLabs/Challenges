package com.varqulabs.challenges.darioLeev.transitions_01

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Xd() {
    var proMode by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(6.dp),
        contentAlignment = Alignment.Center
    ) {
        Buttons(proMode) { proMode = !proMode }
    }
}

@Composable
fun Buttons(proMode: Boolean, changeMode: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        val mainColumnWeight = if (proMode) 0.75f else 1f
        val proColumnWeight = if (proMode) 0.25f else 1f

        Column(
            modifier = Modifier.weight(mainColumnWeight),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "1")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "4")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "6")
            }
        }
        Column(
            modifier = Modifier.weight(mainColumnWeight),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "2")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "5")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "8")
            }
        }
        Column(
            modifier = Modifier.weight(mainColumnWeight),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "3")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "6")
            }
            Button(onClick = { changeMode() }) {
                Text(text = "pro")
            }
        }

        AnimatedVisibility(
            visible = proMode,
            enter = slideInHorizontally(initialOffsetX = { fullWidth -> fullWidth }).plus(
                fadeIn(
                    animationSpec = tween(durationMillis = 1000)
                )
            ),
            exit = slideOutHorizontally(targetOffsetX = { fullWidth -> fullWidth }).plus(
                fadeOut(
                    animationSpec = tween(durationMillis = 1000)
                )
            )
        ) {
            Box(
                modifier = Modifier
                    .weight(proColumnWeight)
                    .fillMaxHeight(),
                contentAlignment = Alignment.Center
            ) {
                ProColumn()
            }
        }
    }
}

@Composable
fun ProColumn() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { /*TODO*/ }) {
            Text(text = "X")
        }
        Button(onClick = { /*TODO*/ }) {
            Text(text = "-")
        }
        Button(onClick = { /*TODO*/ }) {
            Text(text = "%")
        }
    }
}